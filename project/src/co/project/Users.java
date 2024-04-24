package co.project;


public class Users {
	private String usersDate;
	private String usersId;
	private String usersPw;
	private String usersName;
	private String usersBirthday;
	private String usersPhone;
	
	
	public String getUsersDate() {
		return usersDate;
	}
	public void setUsersDate(String usersDate) {
		this.usersDate = usersDate;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersPw() {
		return usersPw;
	}
	public void setUsersPw(String usersPw) {
		this.usersPw = usersPw;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersBirthday() {
		return usersBirthday;
	}
	public void setUsersBirthday(String usersBirthday) {
		this.usersBirthday = usersBirthday;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
	@Override
	public String toString() {
		return String.format("3%d %4s $-12s %5d",usersDate, usersId, usersPw, usersName, usersBirthday, usersPhone);
	}
}//