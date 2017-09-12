<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Apply Leave Form</title>
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
	</style>
</head>
<body>
	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'ApplyLeave')" id="defaultOpen">Leave Application Form</button>
		<button class="tablinks" onclick="openCity(event, 'Profile')">Profile</button>
		<button class="tablinks" onclick="openCity(event, 'Logout')">Logout</button>
	</div>
	
	<div id="ApplyLeave" class="tabcontent">
		<form action="/ApplyLeave" method="post">
			welcome ${username}<br><br>
			Staff Id<br>
			<input type="text" name="staffid" value="${staffId}" disabled="disabled"><br><br>
			To<br>
			<input type="date" name="to"><br><br>
			From<br>
			<input type="date" name="from"><br><br>
			Reason<br>
			<input type="text" name="reason"><br><br>
			
			<input type="submit" value="Apply Leave">
		</form>
	</div>
	
	<div id="Profile" class="tabcontent">
		Staff Id:<br>
		<input type="text" name="id" disabled="disabled" value="${staffId}"><br>
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