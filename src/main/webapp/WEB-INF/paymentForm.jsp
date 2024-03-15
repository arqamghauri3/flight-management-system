<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Airlines Form</title>
    <style>
        body {
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            top: 20%;
            left: 50%;
            transform: translate(0%, -60%);						
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            height: 500px;
        }

        h1 {
            text-align: center;
            color: #333;
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
            text-decoration: underline;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
            color: #333;
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
            font-size: 18px;
        }

        input {
            padding: 10px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
        }

        button {
            background-color: #000;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            align-self: flex-end;
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
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
    <h1>Payments</h1>
    <form action = "/user/paymentForm/" method = "post">

        <label for="ccno">Credit Card Number: </label>
        <input type="text" id="ccno" name="ccno"  required>
        <label for="name">Name on Card: </label>
        <input type="text" id="name" name="name"  required>
        <label for="exDate">Expiry Date: </label>
        <input type="date" id="exDate" name="exDate"  required>
        <label for="CVS">CVS: </label>
        <input type="number" id="CVS" name="CVS"  required>
        <label for="amount">Amount: </label>
        <input type="number" id="amount" name="amount" value="${price}" required>

		<input type="hidden" name="flightID" value="${flightID}">
		<input type="hidden" name="passengerID" value="${passengerID}">
		<input type="hidden" name="userID" value="${userID}">
        <button type="submit">Add</button>
    
    
    </form>
</div>
</body>
</html>