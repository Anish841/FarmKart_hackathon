package org.farmkart.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.farmkart.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class BuyCrop extends ActionSupport
{
	private static final long serialVersionUID = -8244104108431894374L;
	private String maincategory,subcategory;
	private String state,city,district,village,categoryname,cropname;
	private List<CropDetails> details=new ArrayList<>();
	public String execute()
	{
		try
		{
			int subcatid=Integer.parseInt(getSubcategory().substring(0, getSubcategory().indexOf('_')));
			categoryname=getSubcategory().substring(getSubcategory().indexOf('_')+1,getSubcategory().length());
			maincategory=getMaincategory().substring(getMaincategory().indexOf('_')+1,getMaincategory().length());
			Connection con=ConnectionPool.getConnection();
			System.out.println("hi");
			PreparedStatement ps=con.prepareStatement("select crop_detail_id,crop_id,price,quantity,userId,user_name,phoneNo from crop_details,user where crop_id=? && state=? && city=? && district=? && village=? && user_id=userId");
			ps.setInt(1, subcatid);
			ps.setString(2, getState());
			ps.setString(3, getCity());
			ps.setString(4, getDistrict());
			ps.setString(5, getVillage());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CropDetails c=new CropDetails();
				c.setCrop_detail_id(rs.getInt(1));
				c.setCropid(rs.getInt(2));
				c.setPrice(rs.getInt(3));
				c.setQuantity(rs.getInt(4));
				c.setUserId(rs.getInt(5));
				c.setUser_name(rs.getString(6));
				c.setPhoneNo(rs.getString(7));
				details.add(c);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}
	public String getMaincategory() {
		return maincategory;
	}
	public void setMaincategory(String maincategory) {
		this.maincategory = maincategory;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public List<CropDetails> getDetails() {
		return details;
	}
	public void setDetails(List<CropDetails> details) {
		this.details = details;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
}
