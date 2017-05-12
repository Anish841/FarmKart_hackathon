<%@ page import="java.sql.*" %>
<%@ page import="org.farmkart.util.*" %>
<%@ include  file="../../headtag.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%! int maincatid; %>
<head>
</head>
<body>
<div class="panel panel-primary">
	<div class="panel-heading text-center">
	 	<label>BUY CROP</label>
	</div>
	<div class="panel-body">
		<form action="buycrop">
			<div class="container">
				<div class="row">
					<div class="col-md-2"><label>Select Main Category : </label></div>
					<div class="col-md-4">
						<select name="maincategory">
							<%
								Connection con=ConnectionPool.getConnection();
								try
								{
									PreparedStatement ps=con.prepareStatement("select * from category_master order by category_name");
									ResultSet rs=ps.executeQuery();
									while(rs.next())
									{%>
										<option value="<%=rs.getInt(1)+"_"+rs.getString(2) %>"><%=rs.getString(2) %></option>
									<% }
								}
								catch(Exception e)
								{
									e.printStackTrace();									
								}
							%>
						</select>
					</div>
				</div>
				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2"> <label>Select Sub Category : </label></div>
					<div class="col-md-4">
						<select name="subcategory">
						<%
								try
								{
									PreparedStatement ps=con.prepareStatement("select * from crop_master order by crop_name");
									ResultSet rs=ps.executeQuery();
									while(rs.next())
									{%>
										<option value="<%=rs.getInt(1)+"_"+rs.getString(2)%>"><%=rs.getString(2) %></option>
									<% }
								}
								catch(Exception e)
								{
									e.printStackTrace();									
								}
							%> 
						</select>
					</div>
				</div> 
				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2"><label>Select State :</label></div>
					<div class="col-md-4">					
						<select name="state">
							<option value="Madhya Pradesh">Madhya Pradesh</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Karnataka">Maharashtra</option>
							<option value="Andhra Pradesh">Andhra Pradesh</option>
						</select> 
					</div>
				</div>

				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2"><label>Select City :</label></div>
					<div class="col-md-4">					
						<select name="city">
							<option value="Indore">Indore</option>
							<option value="Bangalore">Bangalore</option>
							<option value="Hyderabad">Hyderabad</option>
							<option value="Pune">Pune</option>
						</select> 
					</div>
				</div>

				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2"><label>Select District :</label></div>
					<div class="col-md-4">					
						<select name="district">
							<option value="kurnool">kurnool</option>
							<option value="kadapa">kadapa</option>
							<option value="chattor">chattor</option>
							<option value="ujjain">ujjain</option>
							<option value="Indore">Indore</option>
						</select> 
					</div>
				</div>

				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2"><label>Select village :</label></div>
					<div class="col-md-4">					
						<select name="village">
							<option value="mandsor">mandsor</option>
							<option value="rajola">rajola</option>
							<option value="raichur">raichur</option>
							<option value="shantinagar">shantinagar</option>
						</select>
						 
					</div>
				</div> 
				
				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2 col-md-offset-2">
						<input type="submit" class="btn btn-primary" value="Submit">
					</div>
				</div>
				<s:if test="hasActionMessages()">
							 <div class="alert alert-info alert-dismissable">
								 <a class="panel-close close" data-dismiss="alert">×</a> 
								  <i class="fa fa-coffee"></i>
								  <s:actionmessage/>
							</div>
						</s:if>
				
				
			</div> 
		</form>
	</div>
</div>
</body>							
 
<!--  <script>
	function getSubCategories()
	{
		var catid=document.getElementById("maincategory").value;
		var xmlhttp;
		if (window.XMLHttpRequest)
		  xmlhttp=new XMLHttpRequest();

		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
			  var all=xmlhttp.getAllResponseHeaders();
		    }
		  };
		xmlhttp.open("POST","getsubcategories?maincategoryid="+catid,true);
		xmlhttp.send();
		return false;
	}
</script>
  -->