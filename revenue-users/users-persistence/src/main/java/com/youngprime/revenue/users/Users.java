package com.youngprime.revenue.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//import org.eclipse.persistence.annotations.UuidGenerator;


@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name=Users.USER_GETALL, query="SELECT o FROM Users o"),
	@NamedQuery(name=Users.USER_GET_BY_USERNAMEANDPASSWORD, 
		query="SELECT o FROM Users o WHERE o.username =:username AND o.password=:password")
})
//@UuidGenerator(name="idGenerator")
public class Users {
	
	@Transient
	public static final String USER_GETALL = "Users.getAll";
	@Transient
	public static final String USER_GET_BY_USERNAMEANDPASSWORD = "Users.getByUsernameAndPassword";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	@NotEmpty
	@Size(min=3, max=50, message="Username must be between 6 and 50 characters")
	@Column(name="username", unique=true)
	private String username;
	
	@NotEmpty
	@Size(min=3, max=50, message="Password must be between 6 and 50 characters")
	@Column(name="password")
	private String password;
	
	@Column(name="salt")
	private String salt;
	
	@NotEmpty
	@Email
	@Column(name="email_address", unique=true)
	private String emailAddress;
	
	@NotEmpty
	@Size(min=3, max=50, message="First name must be between 6 and 50 characters")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
	@Size(min=3, max=50, message="Last name must be between 6 and 50 characters")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="other_name")
	private String otherName;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="email_verified")
	private boolean emailVerified;
	
	@Column(name="phone_verified")
	private boolean phoneVerified;
	
	@Column(name="email_verified_date")
	private Date emailVerifiedDate;
	
	@Column(name="phone_verified_date")
	private Date phoneVerifiedDate;
	
	@Column(name="phone_verification_code")
	private String phoneVerificationCode;
	
	@Column(name="email_verification_code")
	private String emailVerificationCode;
	
	@Column(name="reset_password_code")
	private String resetPasswordCode;
	
	@Column(name="reset_password_request_date")
	private Date resetPasswordRequestDate;
	
	@Column(name="reset_password_date")
	private Date resetPasswordDate;
	
	@Column(name="verification_expired_date")
	private Date verificationExpiredDate;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", updatable=false)
	private Date updatedAt;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Version
	private Integer version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public Date getEmailVerifiedDate() {
		return emailVerifiedDate;
	}

	public void setEmailVerifiedDate(Date emailVerifiedDate) {
		this.emailVerifiedDate = emailVerifiedDate;
	}

	public Date getPhoneVerifiedDate() {
		return phoneVerifiedDate;
	}

	public void setPhoneVerifiedDate(Date phoneVerifiedDate) {
		this.phoneVerifiedDate = phoneVerifiedDate;
	}

	public String getPhoneVerificationCode() {
		return phoneVerificationCode;
	}

	public void setPhoneVerificationCode(String phoneVerificationCode) {
		this.phoneVerificationCode = phoneVerificationCode;
	}

	public String getEmailVerificationCode() {
		return emailVerificationCode;
	}

	public void setEmailVerificationCode(String emailVerificationCode) {
		this.emailVerificationCode = emailVerificationCode;
	}

	public String getResetPasswordCode() {
		return resetPasswordCode;
	}

	public void setResetPasswordCode(String resetPasswordCode) {
		this.resetPasswordCode = resetPasswordCode;
	}

	public Date getResetPasswordRequestDate() {
		return resetPasswordRequestDate;
	}

	public void setResetPasswordRequestDate(Date resetPasswordRequestDate) {
		this.resetPasswordRequestDate = resetPasswordRequestDate;
	}

	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}

	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}

	public Date getVerificationExpiredDate() {
		return verificationExpiredDate;
	}

	public void setVerificationExpiredDate(Date verificationExpiredDate) {
		this.verificationExpiredDate = verificationExpiredDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
