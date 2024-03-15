<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flight Details</title>
    <style>
        body {
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: black;
            overflow: hidden;
            text-align: center;
        }

        .navbar ul {
            margin: 0;
            padding: 0;
            list-style: none;
            display: flex;
            justify-content: center;
        }

        .navbar a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 30px; 
            text-decoration: none;
            transition: background-color 0.3s;
            margin-right: 10px; 
        }

        .navbar li {
            display: inline; 
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        @media (max-width: 850px) {
            .navbar a {
                display: block;
                width: 100%;
                text-align: left;
            }
        }

        .container {
            top: 20%;
            left: 50%;
            transform: translate(0%, -60%);
            max-width: 1200px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            height:400px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
		.headerImg{
			filter: brightness(70%)
		}
    </style>
</head>
<body>

        <div class="navbar">
            <ul>
                <li><a href="/user/viewBookings/${userID}">View Flight</a></li>
                <li><a href="/user/flights/${userID}">Book a Flight</a></li>
				<li><a href ="/user/profile/${userID}">Profile </a></li>
				<li><a href ="/user/logout">Logout </a></li>
            </ul>
        </div>
        <div><img class = "headerImg" src="https://i.ibb.co/18qnhv1/Leonardo-Diffusion-XL-create-ui-for-login-and-register-of-my-f-0.jpg" width="1900" height="649" alt=""/></div>
<div class="container">
	
  <h2>Flight Details</h2>
    <form action="/flights/getSearchedFlight/${userID}" method="post">

        <label for="toCity">To City:</label>
        <input type="text" id="toCity" name="toCity" required>

        <label for="fromCity">From City:</label>
        <input type="text" id="fromCity" name="fromCity" required>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>

        <button type="Submit">Search</button>
    </form>

    <table>
        <tr>
            <th>Flight ID</th>
            <th>Date</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>To City</th>
            <th>From City</th>
            <th>Airline Name</th>
            <th>Aircraft ID</th>
            <th>Action</th>
        </tr>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${flight.flightID}</td>
                <td>${flight.date}</td>
                <td>${flight.departureTime}</td>
                <td>${flight.arrivalTime}</td>
                <td>${flight.toCity}</td>
                <td>${flight.fromCity}</td>
                <td>${flight.airline.airlineID}</td>
                <td>${flight.aircraft.aircraftID}</td>
                <td>
                    <form action="/user/passengerForm/" method="post">
                        <input type="hidden" name="_method" value="SELECT">
                        <input type="hidden" name="flightID" value="${flight.flightID}">
                        <input type="hidden" name="userID" value="${userID}">                        
                        <input type="submit" value="Select">
                    </form>                    
                </td>
            </tr>
            
        </c:forEach>
    </table>
</div>

</body>
</html>
