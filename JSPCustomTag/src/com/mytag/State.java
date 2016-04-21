package com.mytag;

import com.mysql.jdbc.Statement;

public class State {
	public static void main(String[] args) {

		try {
			Statement s = (Statement) com.db.Admin.connect().createStatement();

			String state = "Andaman And Nicobar:Andhra Pradesh:Arunachal Pradesh:Assam:Bihar:Chandigarh:Chhattisgarh:Dadar And Nagar Haveli:Daman and Diu:Delhi:Goa:Gujarat:Haryana:Himachal Pradesh:Jammu and Kashmir:Jharkhand:Karnataka:Kerala:Lakshadweep:Madhya Pradesh:Maharashtra:Manipur:Meghalaya:Mizoram:Nagaland:Orissa:Puducherry:Punjab:Rajasthan:Sikkim:Tamil Nadu:Tripura:Uttar Pradesh:Uttarakhand:West Bengal";

			String str, ar[] = state.split(":");

			for (String string : ar) {

				str = "insert into tbl_State values ('" + string + "')";
				System.err.println(str);
				s.execute(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}
}
