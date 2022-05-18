package com.inexture.ems.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@Column(name="id",updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	@Size(min=2,message="FirstName Required")
	private String first_name;
	
	@Column(name="lastname")
	@Size(min=2,message="LastName Required")
	private String last_name;
	
	@Column(name="email",unique = true,nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}$",message="Email Formate Mismatched")
	private String email;
	
	@Column(name="phone")
	@Size(min=10,max=10,message="Phone should be 10 digit long")
	private String phone;
	
	@Column(name="gender")
	@NotNull(message="Gender Can't be Empty")
	private String gender;
	
	@Column(name="dob")
	@NotNull(message="Date Can't be Empty")
	private String date;
	
	@Column(name="lang")
	private String checkbox;
	
	@Column(name="password")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message="Password Formate Mismatched")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Transient
	@NotNull(message="Image is Required")
	private CommonsMultipartFile image1;
	
	@Lob
	@Column(name="picture")
	private byte[] image;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Address> list;
	
	public List<Address> getList() {
		return new ArrayList<Address>(list);
	}
	public void setList(List<Address> list) {
		this.list = new ArrayList<Address>(list);
	}
	@Transient
	String base64Image;
	
	public byte[] getImage() {
		return Arrays.copyOf(image,image.length);
	}
	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(this.image);
	}
	public void setImage(byte[] image) {
		this.image = Arrays.copyOf(image,image.length);
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	
	//--------------------------------------------------------------------------------
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getDate() {
		return date;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public CommonsMultipartFile getImage1() {
		return new CommonsMultipartFile(image1.getFileItem());
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public void setImage1(CommonsMultipartFile image1) {
		this.image1 = new CommonsMultipartFile(image1.getFileItem());
	}
	public User() {
		super();
	}
	public User(int id, String first_name, String last_name, String email, String phone, String gender, String date,
			String checkbox, String password, String role, CommonsMultipartFile image1, byte[] image,
			List<Address> list, String base64Image) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.date = date;
		this.checkbox = checkbox;
		this.password = password;
		this.role = role;
		this.image1 = new CommonsMultipartFile(image1.getFileItem());
		this.image = Arrays.copyOf(image,image.length);
		this.list = new ArrayList<Address>(list);
		this.base64Image = base64Image;
	}
}
