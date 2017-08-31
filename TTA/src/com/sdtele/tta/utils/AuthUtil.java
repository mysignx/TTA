package com.sdtele.tta.utils;

public final class AuthUtil {
	private AuthUtil() {}
	
	/**
	 * 判断是否合法的用户名：字母开头，可含有大小写字母、数字以及下划线，长度6-20。
	 * @param username
	 * @return
	 * 		合法的用户名返回true，否则返回false;
	 * @see isValidEmail
	 * @see isValidMobilePhone
	 */
	public static boolean isValidUsername(String username) {
		return username.matches("^[A-Za-z][A-Za-z0-9_]{5,19}$");
	}
	
	/**
	 * 判断是否合法的邮件地址。
	 * @param email
	 * @return
	 * 		合法的邮件返回true，否则返回false;
	 * @see isValidUsername
	 * @see isValidMobilePhone
	 */
	public static boolean isValidEmail(String email) {
		return email.matches("[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}");
	}
	
	/**
	 * 判断是否合法的手机号。
	 * @param phone
	 * @return
	 * 		合法的手机号返回true，否则返回false;
	 * @see isValidUsername
	 * @see isValidEmail
	 */
	public static boolean isValidMobilePhone(String phone) {
		return phone.matches("^1[3|4|5|8][0-9]\\d{8}$");
	}
}