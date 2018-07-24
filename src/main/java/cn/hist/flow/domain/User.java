package cn.hist.flow.domain;

public class User {
	private String id;
	private String loginName;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String status; // 0:正常，1锁定

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "id=" + id + ", loginName=" + loginName + ", name=" + name
				+ ", pwd=" + pwd + ", email=" + email + ", phone=" + phone
				+ ", status=" + status;
	}
}