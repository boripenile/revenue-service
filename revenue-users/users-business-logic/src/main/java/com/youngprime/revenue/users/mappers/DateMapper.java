package com.youngprime.revenue.users.mappers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DateMapper {

	public String asString(Date date) {
		return date != null ? new SimpleDateFormat("dd-MM-yyyy")
				.format(date) : null;
	}
	
	public Date asDate(String date) {
		try {
			return date != null ? new SimpleDateFormat("dd-MM-yyyy")
					.parse(date) : null;
		} catch (Exception e) {
			throw new RuntimeException("Date must be in this format: dd-MM-yyyy");
		}
	}
}
