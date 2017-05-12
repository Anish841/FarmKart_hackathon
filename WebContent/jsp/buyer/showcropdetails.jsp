<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include  file="../../headtag.jsp" %>
<%int sno=0; %>
<div class="panel panel-primary">
	<div class="panel-heading text-center">
		<label>Chunk Details</label>
	</div>
	<div class="panel-body">
		<form action="requestcrop">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<table class="table-bordered  table-hover table-striped table-responsive">
							<thead>
								<tr>
									<th> S.no </th>
									<th> Select </th>
									<th> Category </th>
									<th> Crop </th>									
									<th> Available Quantity </th>
									<th> Price </th>
									<th> Vendor </th>									
									<th> Phone Number </th>
									<th> Request Price </th>																		
								</tr>
							</thead>
							<c:forEach items="${details}" var="detail">
								<tr>
									<td><%=++sno %></td>
 									<td><input type="radio" name="selected" value="<%= sno-1 %>_${detail.getCrop_detail_id()}" ></td> 									
									<td><s:property value="maincategory"/></td>
									<td><s:property value="categoryname"/></td>
									<td>${detail.getQuantity()}</td>
									<td>${detail.getPrice()}</td>
									<td>${detail.getUser_name()}</td>
									<td>${detail.getPhoneNo()}</td>
									<td><input type="text" name="negPrice.price" class="form-control"></td>
								</tr>
							</c:forEach>
						</table>
					</div>					
				</div>
				<div class="row">
					<div class="col-md-2">
						<input type="submit" value="Submit" class="form-control btn btn-primary" />
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
