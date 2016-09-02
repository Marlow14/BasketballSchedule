<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.games_schedule.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Games Log</title>
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="index.html">Home</a> <a href="addToDB.html">Add</a> <a
			href="displayGameDB.jsp">Read</a> <a href="updateDB.jsp">Update</a> <a
			href="delete.jsp">Delete</a>
	</div>

	<div id="main">
		<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;
			open</span>
		<h1 class="text-center">Games Database Log</h1>
		<h2 class="text-center">
			<small>Update Database Page</small>
		</h2>

		<main>
		<table class="table">
			<tr>
				<th>Game Number</th>
				<th>Game Level</th>
				<th>Game Location</th>
				<th>Date</th>
				<th>Time</th>
				<th>Home Team</th>
				<th>Away Team</th>
				<th>Home Team Score</th>
				<th>Away Team Score</th>
				<th>Game Winner</th>
			</tr>
			<%
				DAO.readFromDB();
			%>
			<%
				GameInfo readToJSP = new GameInfo();
				for (int i = 0; i < DAO.myGameList.size(); i++) {
					readToJSP = DAO.myGameList.get(i);
			%>

			<tr>
				<td><%=readToJSP.getGameNumber()%></td>
				<td><%=readToJSP.getGameLevel()%></td>
				<td><%=readToJSP.getGameLocation()%></td>
				<td><%=readToJSP.getDate()%></td>
				<td><%=readToJSP.getTime()%></td>
				<td><%=readToJSP.getHomeTeam()%></td>
				<td><%=readToJSP.getAwayTeam()%></td>
				<td><%=readToJSP.getHomeTeamScore()%></td>
				<td><%=readToJSP.getAwayTeamScore()%></td>
				<td><%=readToJSP.getGameWinner()%></td>
			</tr>

			<%
				}
				DAO.myGameList.clear();
			%>

		</table>
		</main>
	</div>

	<aside>
	<form class="navbar-form" action="updateDB" method="post">
		<div class="form-group">
			<div>
				<label for="inputGameNumber"> Game number</label><br> <input
					type="text" class="form-control" id="inputGameNumber"
					placeholder="Game Number" name="gameNumber"><br>
			</div>
			<div>
				<label for="inputGamelevel"> Game Level</label><br> <input
					type="text" class="form-control" id="inputGameLevel"
					placeholder="Game Level" name="gameLevel"><br>
			</div>
			<div>
				<label for="inputGamelocation"> Game Location</label><br> <input
					type="text" class="form-control" id="inputGameLocation"
					placeholder="Game Location" name="gameLocation"><br>
			</div>
			<div>
				<label for="inputDate"> Date</label><br> <input type="text"
					class="form-control" id="inputDate" placeholder="Date" name="date"><br>
			</div>
			<label for="inputTime"> Time</label><br> <input type="text"
				class="form-control" id="inputTime" placeholder="Time" name="time"><br>
		</div>
		<div>
			<label for="inputHomeTeam"> Home Team</label><br> <input
				type="text" class="form-control" id="inputHomeTeam"
				placeholder="Home Team" name="homeTeam"><br>
		</div>
		<div>
			<label for="inputAwayTeam"> Away Team</label><br> <input
				type="text" class="form-control" id="inputAwayTeam"
				placeholder="Away Team" name="awayTeam"><br>
		</div>
		<div>
			<label for="inputHomeTeamScore">Home Team Score</label><br> <input
				type="text" class="form-control" id="inputHomeTeamScore"
				placeholder="Home Team Score" name="homeTeamScore"><br>
		</div>
		<div>
			<label for="inputAwayTeamScore"> Away Team Score</label><br> <input
				type="text" class="form-control" id="inputAwayTeamScore"
				placeholder="Away Team Score" name="awayTeamScore"><br>
		</div>
		<div>
			<label for="inputGameWinner"> Game Winner</label><br> <input
				type="text" class="form-control" id="inputGameWinner"
				placeholder="Game Winner" name="gameWinner"><br>
		</div>
		</div>
		<br>

		<button type="submit" class="btn btn-success">Update</button>

	</form>
	</aside>

	<footer> </footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
			document.getElementById("main").style.marginLeft = "250px";
			document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
			document.body.style.backgroundColor = "white";
		}
	</script>
</body>
</html>