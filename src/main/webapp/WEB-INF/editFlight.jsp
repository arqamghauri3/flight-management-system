<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Flight</title>
    <style>
        body {
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
            background-image: url('https://i.ibb.co/H2nWhzR/Background.png');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            background-position: center;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
        }

        .navbar ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .navbar li {
            float: left;
        }

        .navbar a {
            display: block;
            color: #fff;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: #333;
        }

        .container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: inline-block;
            width: 100px;
            text-align: right;
            margin-right: 10px;
            font-weight: bold;
        }

        input {
            padding: 8px;
            margin-bottom: 10px;
            width: 200px;
        }

        input[type="submit"] {
            background-color: black;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>

        <div class="navbar">
            <ul>
                <li><a href="/flights">Flights</a></li>
                <li><a href="/airlines">Airlines</a></li>
		        <li><a href="/aircrafts">Aircraft</a></li>
		        <li><a href="/adminLogout">Logout</a></li>
				
            </ul>
        </div>

<div class="container">
    <h2 style="color: #333;">Edit Flight</h2>

    <form action="/flights/updateFlights/${flight.flightID}" method="post">
        <input type="hidden" name="_method" value="PUT">

        <label for="date">Date:</label>
        <input type="date" id="date" name="date" value="${flight.date}" required><br>

        <label for="departureTime">Departure Time:</label>
        <input type="time" id="departureTime" name="departureTime" value="${flight.departureTime}" required><br>

        <label for="arrivalTime">Arrival Time:</label>
        <input type="time" id="arrivalTime" name="arrivalTime" value="${flight.arrivalTime}" required><br>

        <label for="toCity">To City:</label>
        <input type="text" id="toCity" name="toCity" value="${flight.toCity}" required><br>

        <label for="fromCity">From City:</label>
        <input type="text" id="fromCity" name="fromCity" value="${flight.fromCity}" required><br>

        <label for="airlineName">Airline Name:</label>
        <input type="text" id="airlineName" name="airlineName" value="${flight.airlineName}" required><br>

        <label for="aircraftID">Aircraft ID:</label>
        <input type="text" id="aircraftID" name="aircraftID" value="${flight.aircraftID}" required><br>

        <input type="submit" value="Update Flight">
    </form>
</div>

</body>
</html>

