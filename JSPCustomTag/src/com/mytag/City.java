package com.mytag;

import java.io.BufferedReader;
import java.io.FileReader;

import com.mysql.jdbc.Statement;

public class City {

	public static void main(String[] args) {

		try {
			BufferedReader r = new BufferedReader(new FileReader("D:/Work-Study/city.txt"));

			Statement s = (Statement) com.db.Admin.connect().createStatement();
			String st = "Andaman And Nicobar:Andhra Pradesh:Arunachal Pradesh:Assam:Bihar:Chandigarh:Chhattisgarh:Dadar And Nagar Haveli:Daman and Diu:Delhi:Goa:Gujarat:Haryana:Himachal Pradesh:Jammu and Kashmir:Jharkhand:Karnataka:Kerala:Lakshadweep:Madhya Pradesh:Maharashtra:Manipur:Meghalaya:Mizoram:Nagaland:Orissa:Puducherry:Punjab:Rajasthan:Sikkim:Tamil Nadu:Tripura:Uttar Pradesh:Uttarakhand:West Bengal";
			String ct[], str, ar[] = st.split(":");
			for (String n : ar) {
				ct = r.readLine().split(":");
				for (String c : ct) {
					str = "insert into tbl_City values('" + c + "','" + n + "')";
					System.out.println(str);
					s.execute(str);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
	}

}
