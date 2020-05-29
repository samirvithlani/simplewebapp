package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean addUser(UserBean userBean) {
		boolean flag = false;
		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String insertsql = "insert into users(uname,uemail,upassword,uage)values(?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertsql);
				pstmt.setString(1, userBean.getuName());
				pstmt.setString(2, userBean.getuEmail());
				pstmt.setString(3, userBean.getuPassword());
				pstmt.setInt(4, userBean.getuAge());
				

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	public List<UserBean> userList() {

		conn = DBConnection.getDBConnection();
		List<UserBean> listOfUsers = new ArrayList<UserBean>();
		if (conn != null) {

			String selectSQl = "select * from user";
			try {
				pstmt = conn.prepareStatement(selectSQl);
				rs = pstmt.executeQuery();// DDL

				while (rs.next()) {

					// System.out.println(rs.getInt("uid"));

					UserBean userBean = new UserBean();

					userBean.setuId(rs.getInt("uid"));
					userBean.setuName(rs.getString("uname"));
					userBean.setuEmail(rs.getString("uemail"));
					userBean.setuPassword(rs.getString("upassword"));
					userBean.setuAge(rs.getInt("uage"));

					listOfUsers.add(userBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return listOfUsers;

	}

	public boolean updateUser(UserBean userBean) {

		conn = DBConnection.getDBConnection();
		boolean flag = false;
		if (conn != null) {

			String updateSQL = "update user set uname=?,uemail=?,upassword=?,uage=? where uid =?";

			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, userBean.getuName());
				pstmt.setString(2, userBean.getuEmail());
				pstmt.setString(3, userBean.getuPassword());
				pstmt.setInt(4, userBean.getuAge());
				pstmt.setInt(5, userBean.getuId());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public UserBean getDataById(int uid) {

		conn = DBConnection.getDBConnection();
		UserBean userBean = null;
		if (conn != null) {

			String selectSQl = "select * from user where uid = ?";
			try {
				pstmt = conn.prepareStatement(selectSQl);
				pstmt.setInt(1, uid);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					userBean = new UserBean();

					userBean.setuId(rs.getInt("uid"));
					userBean.setuName(rs.getString("uname"));
					userBean.setuEmail(rs.getString("uemail"));
					userBean.setuPassword(rs.getString("upassword"));
					userBean.setuAge(rs.getInt("uage"));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return userBean;
	}

	public boolean deleteUser(int id) {

		conn = DBConnection.getDBConnection();
		boolean flag = false;
		if (conn != null) {

			String deleteSQL = " delete from user where uid =?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, id);
				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;

	}

	public UserBean loginUser(String uEmail, String uPassword) {

		conn = DBConnection.getDBConnection();
		UserBean userBean = null;
		if (conn != null) {

			String loginSQL = "select * from user where uemail =? and upassword =?";
			try {
				pstmt = conn.prepareStatement(loginSQL);
				pstmt.setString(1, uEmail);
				pstmt.setString(2, uPassword);

				rs = pstmt.executeQuery();
				while (rs.next()) {

					userBean = new UserBean();
					userBean.setuId(rs.getInt("uid"));
					userBean.setuName(rs.getString("uname"));
					System.out.println(rs.getString("uname"));
					userBean.setuEmail(rs.getString("uemail"));
					userBean.setuAge(rs.getInt("uage"));
					userBean.setuPassword(rs.getString("upassword"));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return userBean;
	}

}
