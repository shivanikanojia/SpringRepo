package com.shivani.srk.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "user_address")
@Table(name = "user_address", uniqueConstraints = {
		@UniqueConstraint(columnNames = "address_id")})
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false)
	private Long addressId;
	
	@Column(name = "address_line_1", nullable = false)
	private String line1;
	
	@Column(name = "address_line_2", nullable = false)
	private String line2;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String State;
	
	@Column(name = "zipcode", nullable = false)
	private String zipcode;
//	
//	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(targetEntity = UserDetails.class)
	@JoinColumn(name = "user_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
	private UserDetails user;


	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}

	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", State=" + State + ", zipcode="
				+ zipcode +"]";
	}

}
