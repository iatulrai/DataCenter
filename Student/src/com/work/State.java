package com.work;

import com.mysql.jdbc.Statement;

public class State {

	public static void main(String aa[]) {
		try {
			String str,
					st = "Andaman And Nicobar:Andhra Pradesh:Arunachal Pradesh:Assam:Bihar:Chandigarh:Chhattisgarh:Dadar And Nagar Haveli:Daman and Diu:Delhi:Goa:Gujarat:Haryana:Himachal Pradesh:Jammu and Kashmir:Jharkhand:Karnataka:Kerala:Lakshadweep:Madhya Pradesh:Maharashtra:Manipur:Meghalaya:Mizoram:Nagaland:Orissa:Puducherry:Punjab:Rajasthan:Sikkim:Tamil Nadu:Telangana:Tripura:Uttar Pradesh:Uttarakhand:West Bengal";
			String ar[] = st.split(":");
			Statement s = (Statement) com.db.Admin.connect().createStatement();
			for (String n : ar) {
				str = "insert into tblstate values('" + n + "')";
				s.execute(str);
				System.out.println(str);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
