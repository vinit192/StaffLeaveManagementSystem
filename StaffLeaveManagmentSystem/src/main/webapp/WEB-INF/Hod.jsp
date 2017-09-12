<%@page import="com.nvdevelopers.dto.LeaveRecords"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator"%>
<%@page import="com.nvdevelopers.service.FetchRecordsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Leave Management System HOD</title>
</head>
	<style>
		body {font-family: "Lato", sans-serif;}
		
		/* Style the tab */
		div.tab {
			overflow: hidden;
			border: 1px solid #ccc;
			background-color: #f1f1f1; 
		}
		
		/* Style the buttons inside the tab*/
		div.tab button {
			background-color: inherit;
			float: left;
			border: none;
			outline: none;
			cursor: pointer;
			padding: 14px 16px;
			transition: 0.3s;
			font-size: 17px;
		}
		
		/*Change the background color of buttons on hover*/
		div.tab button:hover {
			background-color: #ddd;
		}
		
		/*Create an active/current tablink class*/
		div.tab button.active {
			background-color: #ccc;
		}
		
		/*Style the tab content*/
		.tabcontent {
			display: none;
			padding: 6px 12px;
			border: 1px solid #ccc;
			border-top: none;
		}
		
		table {
			font-family: arial, sans-serif;
			border-collapse: collapse;
			width: 100%;
		}
		
		td, th {
			border: 1px solid #dddddd;
			text-align: left;
			padding: 8px;
		}
		
		tr:nth-child(even) {
			background-color: #dddddd;
		}
		
		tr:NOT(:FIRST-CHILD) {
			cursor: pointer;
		}
		
		tr:NOT(:FIRST-CHILD):hover
		{
			background-color: #aaa;
		}
	</style>
<body>
	welcome ${username}
	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'All Leave Applications')" id="defaultOpen">All Leave Applications</button>
		<button class="tablinks" onclick="openCity(event, 'Pending Leave Applications')">Pending Leave Applications</button>
		<button class="tablinks" onclick="openCity(event, 'Rejected Leave Application')">Rejected Leave Applications</button>
		<button class="tablinks" onclick="openCity(event, 'Profile')">Profile</button>
		<button class="tablinks" onclick="openCity(event, 'Logout')">Logout</button>
	</div>
	
	<div id="All Leave Applications" class="tabcontent">
		<table>
			<tr>
				<th>Leave Id</th>
				<th>Staff Id</th>
				<th>To</th>
				<th>From</th>
				<th>Reason</th>
				<th>Status</th>
			</tr>
			
			<%
				FetchRecordsService fetchRecordsService = new FetchRecordsService();
				List allLeaveRecords = fetchRecordsService.showAllLeaveRecord();
				
				Iterator it = allLeaveRecords.listIterator();
				
				while (it.hasNext())
				{
					LeaveRecords leaveRecords = (LeaveRecords) it.next();		
			%>
			
					<tr>
						<td><%= leaveRecords.getLeaveId() %></td>
						<td><%= leaveRecords.getStaffId() %></td>
						<td><%= leaveRecords.getToDate() %></td>
						<td><%= leaveRecords.getFromDate() %></td>
						<td><%= leaveRecords.getReason() %></td>
						<td><%= leaveRecords.getGranted() %></td>
					</tr>
			
			<%
				}
			%>
			
		</table>
	</div>
	
	<div id="Pending Leave Applications" class="tabcontent">
		<table id="pendingleaveapplicationstable">
			<tr>
				<th>Leave Id</th>
				<th>Staff Id</th>
				<th>To</th>
				<th>From</th>
				<th>Reason</th>
				<th>Status</th>
			</tr>
			<%
				FetchRecordsService fetchRecordsService2 = new FetchRecordsService();
				List allPendingLeaveRecords = fetchRecordsService2.showAllPendingLeaveRecords();
				
				Iterator it1 = allPendingLeaveRecords.listIterator();
				
				while (it1.hasNext())
				{
					LeaveRecords leaveRecords = (LeaveRecords) it1.next();		
			%>
			
					<tr>
						<td><%= leaveRecords.getLeaveId() %></td>
						<td><%= leaveRecords.getStaffId() %></td>
						<td><%= leaveRecords.getToDate() %></td>
						<td><%= leaveRecords.getFromDate() %></td>
						<td><%= leaveRecords.getReason() %></td>
						<td><%= leaveRecords.getGranted() %></td>
					</tr>
			
			<%
				}
			%>
		</table>
		
		<form action="/PermitLeave" method="post">
			Leave Id<br>
			<input type="text" name="leaveid" id="leaveid"><br><br>
			Staff Id<br>
			<input type="text" name="staffid" id="staffid"><br><br>
			To<br>
			<input type="text" name="to" id="to"><br><br>
			From<br>
			<input type="text" name="from" id="from"><br><br>
			Reason<br>
			<input type="text" name="reason" id="reason"><br><br>
			
			<input type="submit" value="Grant Leave">
		</form>
		
		<form action="/RejectLeave" method="post">
			Leave Id<br>
			<input type="text" name="leaveid" id="leaveid2"><br><br>
			
			<input type="submit" value="Reject Leave">
		</form>
		
	</div>
	
	<div id="Rejected Leave Application" class="tabcontent">
		<table>
			<tr>
				<th>Leave Id</th>
				<th>Staff Id</th>
				<th>To</th>
				<th>From</th>
				<th>Reason</th>
				<th>Status</th>
			</tr>
			<%
				FetchRecordsService fetchRecordsService3 = new FetchRecordsService();
				List allRejectedLeaveRecords = fetchRecordsService3.showAllRejectedLeaveRecords();
				
				Iterator it2 = allRejectedLeaveRecords.listIterator();
				
				while (it2.hasNext())
				{
					LeaveRecords leaveRecords = (LeaveRecords) it2.next();		
			%>
			
					<tr>
						<td><%= leaveRecords.getLeaveId() %></td>
						<td><%= leaveRecords.getStaffId() %></td>
						<td><%= leaveRecords.getToDate() %></td>
						<td><%= leaveRecords.getFromDate() %></td>
						<td><%= leaveRecords.getReason() %></td>
						<td><%= leaveRecords.getGranted() %></td>
					</tr>
			
			<%
				}
			%>
		</table>
	</div>
	
	<div id="Profile" class="tabcontent">
		<input type="text" name="id" disabled="disabled" value="${staffid}"><br>
		Name:<br>
		<input type="text" name="name" disabled="disabled" value="${name}"><br>
		Email:<br>
		<input type="text" name="email" disabled="disabled" value="${email}"><br>
		User name:<br>
		<input type="text" name="username" disabled="disabled" value="${username}"><br>
		Contact No:<br>
		<input type="text" name="contactno" disabled="disabled" value="${contactno}"><br><br>
	</div>
	
	<div id="Logout" class="tabcontent">
		<form action="/Logout" method="get">
			<input type="submit" value="Logout">
		</form>
	</div>
	
	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace("active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
		
		//Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
		
		var table = document.getElementById('pendingleaveapplicationstable');
		
		for (var i = 1; i < table.rows.length; i++)
			{
				table.rows[i].onclick = function()
				{
					document.getElementById("leaveid").value = this.cells[0].innerHTML;
					document.getElementById("staffid").value = this.cells[1].innerHTML;
					document.getElementById("to").value = this.cells[2].innerHTML;
					document.getElementById("from").value = this.cells[3].innerHTML;
					document.getElementById("reason").value = this.cells[4].innerHTML;
					document.getElementById("leaveid2").value = this.cells[0].innerHTML;
				};
			}
	</script>
	
</body>
</html>