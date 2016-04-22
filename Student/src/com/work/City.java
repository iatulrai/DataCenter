package com.work;

import java.io.BufferedReader;
import java.io.FileReader;

import com.mysql.jdbc.Statement;

public class City {

	public static void main(String aa[]) {
		try {
			BufferedReader bufreader = new BufferedReader(new FileReader("city.txt"));
			String str,
					st = "Andaman And Nicobar:Andhra Pradesh:Arunachal Pradesh:Assam:Bihar:Chandigarh:Chhattisgarh:Dadar And Nagar Haveli:Daman and Diu:Delhi:Goa:Gujarat:Haryana:Himachal Pradesh:Jammu and Kashmir:Jharkhand:Karnataka:Kerala:Lakshadweep:Madhya Pradesh:Maharashtra:Manipur:Meghalaya:Mizoram:Nagaland:Orissa:Puducherry:Punjab:Rajasthan:Sikkim:Tamil Nadu:Telangana:Tripura:Uttar Pradesh:Uttarakhand:West Bengal";
			String ct[], ar[] = st.split(":");
			Statement s = (Statement) com.db.Admin.connect().createStatement();
			for (String n : ar) {
				ct = bufreader.readLine().split(":");
				for (String c : ct) {
					str = "insert into tblcity values('" + c + "','" + n + "')";
					s.execute(str);
					System.out.println(str);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
