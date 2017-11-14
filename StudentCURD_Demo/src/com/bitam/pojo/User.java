package com.bitam.pojo;

import java.sql.Date;

public class User {

	private int id;
	private String name;
	private String sex;
	private Date birthday;
	private String pic;
	private String likesome;
	private String phone;
	private String address;
	private String aboutme;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getLikesome() {
		return likesome;
	}
	public void setLikesome(String likesome) {
		this.likesome = likesome;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", pic=" + pic + ", likesome="
				+ likesome + ", phone=" + phone + ", address=" + address
				+ ", aboutme=" + aboutme + "]";
	}
	
}