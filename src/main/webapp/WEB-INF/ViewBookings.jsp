<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airline Details</title>
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
            transform: translate(0%, -60%);			
            max-width: 1800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            height: 500px;
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
            <li><a href="/flights">View Flight</a></li>
            <li><a href="/airlines">Book a Flight</a></li>
          </ul>
        </div>
        <div><img class = "headerImg" src="https://i.ibb.co/18qnhv1/Leonardo-Diffusion-XL-create-ui-for-login-and-register-of-my-f-0.jpg" width="1900" height="649" alt=""/></div>

<div class="container">
    <h2>My Bookings</h2>

    <table>
        <tr>
            <th>Reservation ID</th>
            <th>Flight ID</th>
            <th>Payment ID</th>
            <th>Passenger ID</th>
            <th>Date</th>
            <th>ToCity</th>
            <th>From City</th>
        </tr>
        <c:forEach var="reservations" items="${reservations}">
            <tr>
				<td>${reservations.reservationID}</td>
                <td>${reservations.flight.flightID}</td>
                <td>${reservations.payment.paymentID}</td>
                <td>${reservations.passenger.passengerID}</td>
                <td>${reservations.flight.date}</td>
                <td>${reservations.flight.toCity}</td>
                <td>${reservations.flight.fromCity}</td>
                <td>
                    <form action="/user/deleteReservation/${reservations.reservationID} " method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>