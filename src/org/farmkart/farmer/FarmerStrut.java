package org.farmkart.farmer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.farmkart.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;


public class FarmerStrut extends ActionSupport{

	String catId;
	String cropId;
	String quantity;
	String price;
	String state;
	String district;
	String city;
	String village;
	
	
public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCropId() {
		return cropId;
	}

	public void setCropId(String cropId) {
		this.cropId = cropId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

public String calculateExpectedPrice(int quantity,int cropId){
	double pri=quantity*0.9 +(cropId*1000)*0.5;
	return String.valueOf(pri);
}
public String checkExpectedPrice()
{
	setPrice(calculateExpectedPrice(Integer.parseInt(quantity),Integer.parseInt(cropId)));
	return "success";
}
public String cropPostAction(){
	System.out.println("inside struts");
	Connection connection = ConnectionPool.getConnection();
	ArrayList<Category> al=new ArrayList<Category>();
	try {
		PreparedStatement stmt = connection
				.prepareStatement("insert into crop_details(state,district,city,price,quantity,crop_id,user_id,village) values(?,?,?,?,?,?,?,?)");
		stmt.setString(1, state);
		stmt.setString(2, district);
		stmt.setString(3, city);
		stmt.setString(4, price);
		stmt.setString(5, quantity);
		stmt.setString(6, cropId);
		stmt.setString(7, "2");
		stmt.setString(8, village);
		stmt.executeUpdate();
		
		addActionMessage("Your Post has been posted successfully.");
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		ConnectionPool.freeConnection(connection);
	}
	
	return "success";
}
public String execute(){
	return "success";
}
}
