package com.youngprime.revenue.users.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.bouncycastle.jcajce.provider.digest.SHA3;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Passwords implements IPasswords, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* serialVersionUID */
	private static final Random RANDOM = new SecureRandom();
	private static final int DEFAULT_SIZE = 64;
	private static final char[] symbols;

	static {
		final StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch) {
			tmp.append(ch);
		}
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			tmp.append(ch);
		}
		symbols = tmp.toString().toCharArray();
	}

	@Override
	public byte[] getSalt64() {
		return getSalt(DEFAULT_SIZE);
	}

	@Override
	public byte[] getSalt32() {
		return getSalt(32);
	}

	@Override
	public byte[] getSalt(int size) {
		final byte[] salt;
		if (size < 32) {
			final String message = String.format("Size < 32, using default of: %d", DEFAULT_SIZE);
			salt = new byte[DEFAULT_SIZE];
		} else {
			salt = new byte[size];
		}
		RANDOM.nextBytes(salt);
		return salt;
	}

	@Override
	public byte[] hash(String password, byte[] salt) {

		Validate.notNull(password, "Password must not be null");
		Validate.notNull(salt, "Salt must not be null");

		try {
			final byte[] passwordBytes = password.getBytes("UTF-8");
			final byte[] all = ArrayUtils.addAll(passwordBytes, salt);
			SHA3.DigestSHA3 md = new SHA3.Digest512();
			md.update(all);
			return md.digest();
		} catch (UnsupportedEncodingException e) {
			final String message = String.format("Caught UnsupportedEncodingException e: <%s>", e.getMessage());
		}
		return new byte[0];
	}

	@Override
	public boolean isExpectedPassword(final String password, final byte[] salt, final byte[] hash) {

		Validate.notNull(password, "Password must not be null");
		Validate.notNull(salt, "Salt must not be null");
		Validate.notNull(hash, "Hash must not be null");

		try {
			final byte[] passwordBytes = password.getBytes("UTF-8");
			final byte[] all = ArrayUtils.addAll(passwordBytes, salt);

			SHA3.DigestSHA3 md = new SHA3.Digest512();
			md.update(all);
			final byte[] digest = md.digest();
			return Arrays.equals(digest, hash);
		} catch (UnsupportedEncodingException e) {
			final String message = String.format("Caught UnsupportedEncodingException e: <%s>", e.getMessage());
		}
		return false;

	}

	@Override
	public String generateRandomPassword(final int length) {

		if (length < 1) {
			throw new IllegalArgumentException("length must be greater than 0");
		}

		final char[] buf = new char[length];
		for (int idx = 0; idx < buf.length; ++idx) {
			buf[idx] = symbols[RANDOM.nextInt(symbols.length)];
		}
		return shuffle(new String(buf));
	}

	private String shuffle(final String input) {
		final List<Character> characters = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			characters.add(c);
		}
		final StringBuilder output = new StringBuilder(input.length());
		while (characters.size() != 0) {
			int randPicker = (int) (Math.random() * characters.size());
			output.append(characters.remove(randPicker));
		}
		return output.toString();
	}
}