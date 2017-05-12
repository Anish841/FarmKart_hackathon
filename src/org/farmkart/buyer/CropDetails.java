package org.farmkart.buyer;

public class CropDetails {
	private String user_name,phoneNo,cropname,cropcategoryname;
	private int quantity,cropid,crop_detail_id,price,userId;
	public int getCropid() {
		return cropid;
	}
	public void setCropid(int cropid) {
		this.cropid = cropid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getCrop_detail_id() {
		return crop_detail_id;
	}
	public void setCrop_detail_id(int crop_detail_id) {
		this.crop_detail_id = crop_detail_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getCropcategoryname() {
		return cropcategoryname;
	}
	public void setCropcategoryname(String cropcategoryname) {
		this.cropcategoryname = cropcategoryname;
	}	
}
