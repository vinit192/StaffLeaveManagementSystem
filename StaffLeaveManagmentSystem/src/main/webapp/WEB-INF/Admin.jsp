<%@page import="com.nvdevelopers.dto.UserDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>
<%@page import="com.nvdevelopers.service.FetchRecordsService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Leave Management System Admin</title>
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
	</style>
</head>
<body>
	Welcome ${username}
	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'All Staff Details')" id="defaultOpen">All Staff Details</button>
		<button class="tablinks" onclick="openCity(event, 'Profile')">Profile</button>
		<button class="tablinks" onclick="openCity(event, 'Logout')">Logout</button>
	</div>
	
	<div id="All Staff Details" class="tabcontent">
		<table>
			
				<tr>
					<th>Staff Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Username</th>
					<th>Contact no</th>
					<th>Total Leaves</th>
				</tr>
			
			
				<%
					FetchRecordsService fetchRecordsService = new FetchRecordsService();
					List user = fetchRecordsService.showAllRecords();
					
					Iterator it = user.listIterator();
					while (it.hasNext())
					{
						UserDetails userDetails = (UserDetails) it.next();
				%>
				
				<tr>
					<td><%= userDetails.getStaffId() %></td>
					<td><%= userDetails.getName() %></td>
					<td><%= userDetails.getEmail() %></td>
					<td><%= userDetails.getUsername() %></td>
					<td><%= userDetails.getContactno() %></td>
					<td><%= userDetails.getTotalLeaves() %></td>
					<td class="action">
						<a href="" class="grant">Grant</a>
						<a href="" class="reject">Reject</a>
					</td>
				</tr>
				
				<%
					}
				%>
			
		</table>
	</div>
	
	<div id="Profile" class="tabcontent">
		Staff Id:<br>
		<input type="text" name="id" disabled="disabled" value="${staffid}"><br>
		Name:<br>
		<input type="text" name="name" disabled="disabled" value="${name}"><br>
		Email:<br>
		<input type="text" name="email" disabled="disabled" value="${email}"><br>
		Username:<br>
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
	</script>
</body>
</html>