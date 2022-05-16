package com.inexture.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_table")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",referencedColumnName ="id",nullable=false)
	private User user;
	
	@Column(name="address")
	private String address;
	@Column(name="zipcode")
	private int zip;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="contry")
	private String contry;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the addressid
	 */
	public int getAddressid() {
		return addressid;
	}
	/**
	 * @param addressid the addressid to set
	 */
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	/**
	 * @return the userid
	 */
//	public User getUserid() {
//		return id;
//	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return the contry
	 */
	public String getContry() {
		return contry;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * @param userid the userid to set
	 */
//	public void setUserid(User userid) {
//		this.id = userid;
//	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @param contry the contry to set
	 */
	public void setContry(String contry) {
		this.contry = contry;
	}
	public Address(int addressid, User user, String address, int zip, String city, String state, String contry) {
		super();
		this.addressid = addressid;
		this.user = user;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.contry = contry;
	}
	public Address() {
		super();
	}
	
	
}
