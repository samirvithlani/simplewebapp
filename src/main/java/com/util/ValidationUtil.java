package com.util;

import java.awt.geom.FlatteningPathIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static boolean isEmpty(String param) {
		boolean flag = false;
		if (param == "" || param.trim().length() < 0) {

			flag = true;
		}

		return flag;
	}

	public static boolean isAge(int age) {

		boolean flag = false;
		if (age < 18) {

			flag = true;
		}

		return flag;

	}

	public static boolean isEmail(String email) {

		boolean flag = false;
		Pattern p = Pattern.compile(
				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		Matcher m = p.matcher(email);
		boolean res = m.matches();
		if (res != true) {

			flag = true;
		}

		return flag;
	}

}
