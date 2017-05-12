<%@ page import="java.sql.*" %>
<%@ page import="org.farmkart.util.*" %>
<%@ page import="java.util.*" %>
<%@page import="org.farmkart.farmer.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="headtag.jsp" %>
<head>
<%-- <script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
		<script src="js/scripts.js"></script>
		<link href="css/customStyle.css" rel="stylesheet">
 --%>	<script type="text/javascript">
	
		function fetchSubCategory(){
			document.getElementById("catForm").submit();
		}
		function postCrop(){
		/* 	document.getElementById("cropPostForm").action='cropPostAction'; */
		document.getElementById("buycrop").submit();
		// $('#buycrop').submit();
			
		}
		function  checkExpectedPrice(){
			var catId=document.getElementById("categoryId").value;
			var cropId=document.getElementById("cropId").value;
			var quantity=document.getElementById("quantity").value;
			var pri=quantity*0.9 +(cropId*1000)*0.5;
			 $("#divep").show();
       	  	$("#ep").val(pri);
		/* 	 $.ajax({
		            url: "checkExpectedPrice",
		            type: 'get',
		            dataType: 'json',
		            data: {
		            	"catId":catId,
		            	"cropId":cropId,
		            	"quantity":quantity,
		            },
		            contentType: "application/json; charset=utf-8",
		            success:function(data){
		            	  $("#divep").show();
		            	  $("#ep").val(data.price);
		            },
		            error:function(jqXhr, textStatus, errorThrown){
		           	 alert("Something went wrong.Please refersh the page.");
		            }
		        });   */  
		}
	</script>
	
</head>
<div class="panel panel-primary">
	<div class="panel-heading text-center">
	 	<label>Post CROP</label>
	</div>
	<s:if test="hasActionMessages()">
							 <div class="alert alert-info alert-dismissable">
								 <a class="panel-close close" data-dismiss="alert">×</a> 
								  <i class="fa fa-coffee"></i>
								  <s:actionmessage/>
							</div>
						</s:if>
	<div class="panel-body">
		<form name="buycrop" id="buycrop" action="cropPostAction">
			<div class="container">
				<div class="row">
					<div class="col-md-2"><label>Enter Crop Details : </label></div>
					
					<div class="col-md-4">
						Select Category:
						<select name="catId" id="categoryId">
							<% ArrayList<Category> al=UserDAOImpl.getCategoryList(); %>
							<%for(int i=0;i<al.size();i++){ 
								Category c=al.get(i);
							%>
							<option value="<%=c.getCategoryId()%>"><%=c.getCategoryName() %></option>
							<%} %>
						</select>
					</div>
					<div class="col-md-4">
						Select Crop :
						<select name="cropId" id="cropId">
							<% ArrayList<Category> cList=UserDAOImpl.getCropList(); %>
							<%for(int i=0;i<cList.size();i++){ 
								Category c=cList.get(i);
							%>
							<option value="<%=c.getCategoryId()%>"><%=c.getCategoryName() %></option>
							<%} %>
						</select>
						
					</div>
					<div class="col-md-4">
						Quantity :
						<input type="text" name="quantity" id="quantity" placeholder="Enter Quantity"/>
						<input type="button" onclick="checkExpectedPrice()" value="Check Expected Price"/>
					</div>
					<div class="col-md-4" id="divep" style="display:none;">
						You can expect :<input type="text" disabled="true" name="ep" id="ep" value=""/>
					</div>
					
					<div class="col-md-4">
						List Price :
						<input type="text" name="price" placeholder="Enter price"/>
						
					</div>
					<div class="col-md-4">
						State :
						<select name="state">
							<option value="Madhya Pradesh">Madhya Pradesh</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Karnataka">Maharashtra</option>
							<option value="Andhra Pradesh">Andhra Pradesh</option>
						</select>
						
					</div>
					<div class="col-md-4">
						City :
						<select name="city">
							<option value="Indore">Indore</option>
							<option value="Bangalore">Bangalore</option>
							<option value="Hyderabad">Hyderabad</option>
							<option value="Pune">Pune</option>
						</select>
						
					</div>
					
					<div class="col-md-4">
						District:
						<select name="district">
							<option value="kurnool">kurnool</option>
							<option value="kadapa">kadapa</option>
							<option value="chattor">chattor</option>
							<option value="ujjain">ujjain</option>
							<option value="Indore">Indore</option>
						</select>
						
					</div>
					<div class="col-md-4">
						Village:
						<select name="village">
							<option value="mandsor">mandsor</option>
							<option value="rajola">rajola</option>
							<option value="raichur">raichur</option>
							<option value="shantinagar">shantinagar</option>
						</select>
						
					</div>
					</form>
				</div>
				<div class="row"><div class="col-md-12"><label> </label></div></div>
				
				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
					<div class="col-md-2 col-md-offset-2"><input class="form-control btn btn-primary" onclick="postCrop()" type="button" value="Post Crop"></div>
				</div>
				<div class="row"><div class="col-md-12"><label> </label></div></div>
				<div class="row">
				 	<div class="col-md-6 col-md-offset-2"><div id="errmsg"></div></div>
				</div>
			</div> 
	</div>
</div>

