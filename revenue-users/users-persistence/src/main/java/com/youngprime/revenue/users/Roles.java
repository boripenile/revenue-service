package com.youngprime.revenue.users;

import java.io.Serializable;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="roles")
@NamedQueries({
	@NamedQuery(name=Roles.ROLE_GETALL, query="SELECT o FROM Roles o"),
	@NamedQuery(name=Roles.ROLE_GET_BY_ROLENAME, 
		query="SELECT o FROM Roles o WHERE o.roleName =:roleName")
})
public class Roles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	public static final String ROLE_GETALL = "Roles.getAll";
	@Transient
	public static final String ROLE_GET_BY_ROLENAME = "Roles.getByRoleName";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	@NotEmpty
	@Size(min=5, max=50, message="Rolename must be between 5 and 50 characters")
	@Column(name="role_name", unique=true)
	private String roleName;
	
	@NotEmpty
	@Size(min=6, max=100, message="Description must be between 6 and 100 characters")
	@Column(name="description", unique=true)
	private String description;

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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
