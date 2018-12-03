package com.shivani.srk.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_details", uniqueConstraints = {
@UniqueConstraint(columnNames = "user_id"),
@UniqueConstraint(columnNames = "email"),
@UniqueConstraint(columnNames = "user_name")})

public class UserDetails {
//	@Id
//	@GeneratedValue(generator="increment")
//	@GenericGenerator(name="increment",strategy="increment")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name = "first_name", nullable = false) 
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "contact", unique = true, nullable = false)
	private String contact;
	
	@Column(name = "gender", unique = true, nullable = false)
	private String gender;
	

    @Temporal(TemporalType.DATE)
	@Column(name = "dob", unique = true, nullable = false)
	private Date date;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="user_address", 
//	joinColumns= @JoinColumn(name="user_id", referencedColumnName="user_id"),
//	inverseJoinColumns=@JoinColumn(name="address_id"))
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private List<Address> address;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
//  @JoinColumn(name="user_id", referencedColumnName="user_id")
//	@JoinTable(name="images", 
//	joinColumns= @JoinColumn(name="user_id", referencedColumnName="user_id"),
//	inverseJoinColumns=@JoinColumn(name="aFILE_ID"))
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private List<ImageFile> file;
	
	
/*	@OneToMany
	private List<Image> images = new ArrayList<Image>();*/
	
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer UserId) {
//		this.userId = userId;
//	}
	
	
	
	public List<ImageFile> getFile() {
		return file;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setFile(List<ImageFile> file) {
		this.file = file;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	} 
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", email=" + email + ", contact=" + contact + ", gender="
				+ gender + ", address=" + address + "]";
	}
}
