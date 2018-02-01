package com.peacebird.ams.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kevin.dai
 * @since 2018-01-24
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 0-超级管理员；1-普通用户
     */
	private Integer type;
	private String password;
	private String email;
	private String mobile;
	private String realname;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username=" + username +
			", type=" + type +
			", password=" + password +
			", email=" + email +
			", mobile=" + mobile +
			", realname=" + realname +
			"}";
	}
}
