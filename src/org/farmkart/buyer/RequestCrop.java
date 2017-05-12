package org.farmkart.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.farmkart.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class RequestCrop extends ActionSupport
{
	private static final long serialVersionUID = 4870791706963318411L;
	private String selected;
	private List<Data> negPrice;
	
	public String execute()
	{
		try
		{
			Connection con=ConnectionPool.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into request_approval(quotated_price,approval_state,userId,crop_id) values(?,'pending',?,?)");
			ps.setInt(1,Integer.parseInt(negPrice.get(Integer.parseInt(selected.substring(0, selected.indexOf('_')))).getPrice()));
			ps.setInt(2,1);//hardcoded userid
			System.out.println(selected.substring(selected.indexOf('_')+1, selected.length()));
			ps.setInt(3,Integer.parseInt(selected.substring(selected.indexOf('_')+1, selected.length())));
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		addActionMessage("Crop Requested Successfully");
		return "success";
	}

	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public List<Data> getNegPrice() {
		return negPrice;
	}
	public void setNegPrice(List<Data> negPrice) {
		this.negPrice = negPrice;
	}
}
