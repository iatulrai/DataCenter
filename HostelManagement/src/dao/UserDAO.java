package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import dto.UserDTO;

public class UserDAO {
	static Connection connection = null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle12c", "hm", "system");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveUser(int challan, String name, String fname, String dob, String mob, String fmob, String add,
			String course, String sem, String email, String doe) {
		try {

			PreparedStatement preStat = connection.prepareStatement(
					"insert into user_form(CHALLAN,NAME,FNAME,DOB,MOB,FMOB,ADDRESS,COURSE,SEMESTER,EMAIL,DOE) "
							+ "values (?,?,?,?,?,?,?,?,?,?,?)");
			preStat.setInt(1, challan);
			preStat.setString(2, name);
			preStat.setString(3, fname);
			preStat.setString(4, dob);
			preStat.setString(5, mob);
			preStat.setString(6, fmob);
			preStat.setString(7, add);
			preStat.setString(8, course);
			preStat.setString(9, sem);
			preStat.setString(10, email);
			preStat.setString(11, doe);

			// here we convert string values into date object in java

			DateFormat datef = new SimpleDateFormat("YYYY-MM-DD");
			Date date = null;
			try {
				date = datef.parse(doe);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			preStat.setDate(11, new java.sql.Date(date.getTime()));
			// execute query
			preStat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserDTO getUserInfoByCh(int challan) {
		UserDTO userDTO = new UserDTO();
		try {
			PreparedStatement preStat = connection
					.prepareStatement("select CHALLAN, NAME, FNAME from user_form where CHALLAN = ?");

			preStat.setInt(1, challan);

			ResultSet result = preStat.executeQuery();

			while (result.next()) {
				userDTO.setChallan(result.getInt(1));
				userDTO.setName(result.getString(2));
				userDTO.setFname(result.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userDTO;
	}

	public void addHoliday(int challan, String year, String month, int holiday) {

		try {
			PreparedStatement preStat = connection.prepareStatement(
					"insert into holiday_info(challan, year, month, no_holiday)" + "values (?,?,?,?)");

			preStat.setInt(1, challan);
			preStat.setString(2, year);
			preStat.setString(3, month);
			preStat.setInt(4, holiday);

			preStat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<UserDTO> messMoneyReport(String year, String month, String course) {
		List<UserDTO> list = null;
		try {
			// PreparedStatement preStat =
			// connection.prepareStatement("SELECT uf.challan, uf.name,
			// uf.fname, uf.course, hi.no_holiday "
			// +
			// "FROM user_form uf left outer join holiday_info hi on uf.challan
			// = hi.challan "
			// + "WHERE hi.year = ? and hi.month = ? and uf.course = ?");

			String sql = "SELECT uf.challan, uf.name, uf.fname, uf.course, ( select hi.no_holiday FROM holiday_info hi WHERE  hi.month = ? and hi.year = ?  and hi.challan =uf.challan) no_holiday, "
					+ "(select TO_NUMBER(TO_CHAR(uff.doe,'dd')) -1 FROM  user_form uff WHERE  TO_NUMBER(TO_CHAR(uff.doe,'mm'))  = ? and TO_NUMBER(TO_CHAR(doe,'yyyy')) = ? and uff.challan = uf.challan) unpaid_day_no "
					+ "FROM  user_form uf WHERE  uf.course = ?  and (TO_NUMBER(TO_CHAR(uf.doe,'yyyy')) < ? or ( TO_NUMBER(TO_CHAR(uf.doe,'yyyy')) = ? and TO_NUMBER(TO_CHAR(uf.doe,'mm')) <= ?  )) ";

			PreparedStatement preStat = connection.prepareStatement(sql);

			preStat.setString(1, month);
			preStat.setString(2, year);
			preStat.setString(3, month);
			preStat.setString(4, year);
			preStat.setString(5, course);
			preStat.setString(6, year);
			preStat.setString(7, year);
			preStat.setString(8, month);

			// preStat.setString(1, year);
			// preStat.setString(2, month);
			// preStat.setString(3, course);

			int intYear = Integer.parseInt(year);
			int intMonth = Integer.parseInt(month);
			Calendar mycal = new GregorianCalendar(intYear, intMonth - 1, 1);
			int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);

			list = new ArrayList<UserDTO>();
			ResultSet result = preStat.executeQuery();
			while (result.next()) {

				UserDTO userDTO = new UserDTO();

				userDTO.setChallan(result.getInt(1));
				userDTO.setName(result.getString(2));
				userDTO.setFname(result.getString(3));
				userDTO.setCourse(result.getString(4));
				Integer hdNum = result.getInt(5);
				if (hdNum != null) {
					userDTO.setNoHoliday(hdNum);
				} else {
					userDTO.setNoHoliday(0);
				}
				Integer unpaidDays = result.getInt(6);
				if (unpaidDays == null) {
					unpaidDays = 0;
				}
				// calculate mess amount
				// TODO consider where to put mess rate, it should not be hard
				// coded
				int messAmt = (daysInMonth - userDTO.getNoHoliday() - unpaidDays) * 50;
				userDTO.setMessAmount(messAmt);
				list.add(userDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<UserDTO> stdMessMoneyt(String year, String month, String course) {
		List<UserDTO> list = null;
		try {
			PreparedStatement preStat = connection
					.prepareStatement("SELECT uf.challan, uf.name, uf.fname, uf.course, hi.no_holiday "
							+ "FROM  user_form uf inner join holiday_info hi on  hi.challan = hi.challan   "
							+ "WHERE hi.year = ? and hi.month = ? and uf.course = ?");

			preStat.setString(1, year);
			preStat.setString(2, month);
			preStat.setString(3, course);

			int intYear = Integer.parseInt(year);
			int intMonth = Integer.parseInt(month);
			Calendar mycal = new GregorianCalendar(intYear, intMonth - 1, 1);
			int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);

			list = new ArrayList<UserDTO>();
			ResultSet result = preStat.executeQuery();
			while (result.next()) {

				UserDTO userDTO = new UserDTO();

				userDTO.setChallan(result.getInt(1));
				userDTO.setName(result.getString(2));
				userDTO.setFname(result.getString(3));
				userDTO.setCourse(result.getString(4));
				userDTO.setNoHoliday(result.getInt(5));
				// calculate mess amount
				// TODO consider where to put mess rate, it should not be hard
				// coded
				int messAmt = (daysInMonth - userDTO.getNoHoliday()) * 50;
				userDTO.setMessAmount(messAmt);
				list.add(userDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
