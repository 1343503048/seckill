package org.seckill.entity;

public class User {
  private long userId;
  private String userName;
  private long userPhone;
  private String userPassword;

  @Override
  public String toString() {
    return "User{"
        + "userId="
        + userId
        + ", userName='"
        + userName
        + '\''
        + ", userPhone="
        + userPhone
        + ", userPassword='"
        + userPassword
        + '\''
        + '}';
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(long userPhone) {
    this.userPhone = userPhone;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
}
