package com.myclass.dto;

public class UserDto {
	private int id;
	private String email;
	private String password;
	private String fullName;
	private String avatar;
	private int roleId;
	private String roleDesc;

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String string) {
		this.roleDesc = string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UserDto(int id, String email, String password, String fullName, String avatar, int roleId, String roleDesc) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.avatar = avatar;
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
