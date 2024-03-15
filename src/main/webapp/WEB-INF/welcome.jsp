<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Flight Management System</title>
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
            max-width: 1200px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            height: 737px; 
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;    
        }

        .buttons {
            text-align: center;
        }

        .button {
            display: inline-block;
            background-color: #000;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            width: 500px;
            margin-bottom: 50px;    
        }

        .button:hover {
            background-color: #444;
        }

        .headerImg {
            filter: brightness(70%);
        }
		
		.viewFlights{
			border-radius: 20px;

		}
		.bookFlights{
			border-radius: 20px;

		}
			.text-container {
			position: absolute;
            transform: translate(130%, -200%);
            color: white;
            text-align: center;
            z-index: 1;
            opacity: 0; 
            transition: opacity 0.3s; 
		}

		.bookingDiv{
            transform: translate(45%, -130%);

		}
        .bookingDiv:hover img {
            filter: brightness(70%); 
			
        }

        .bookingDiv:hover .text-container {
            opacity: 1;
        }
		.bookFlightsLabel{
			color: white;
		}
		
		.viewDiv{
            transform: translate(20%, -30%);
			
		}
        .viewDiv:hover img {
            filter: brightness(70%); 
        }

        
        .viewDiv:hover .text-container {
            opacity: 1;
        }
		.text-container1{
			
		}
		
		.welcomeLabel{
			position: absolute;
            transform: translate(120%, -1000%);
			color: white;
			font-size: 36px;
		}
		.aircraftDiv{
            transform: translate(20%, -30%);
			
		}
        .aircraftDiv:hover img {
            filter: brightness(70%); 
        }

        
        .aircraftDiv:hover .text-container {
            opacity: 1;
        }
		
		.aircraftDiv{
            transform: translate(70%, -230%);
		}
    </style>
</head>
<body>

    <div>
        <div class="navbar">
            <ul>
                <li><a href="/flights">Flights</a></li>
                <li><a href="/airlines">Airlines</a></li>
		        <li><a href="/aircrafts">Aircraft</a></li>
		        <li><a href="/adminLogout">Logout</a></li>
				
            </ul>
        </div>
		<div>
        <img class="headerImg" src="https://i.ibb.co/xJrPpXq/downImg.jpg" width="1900" height="500" alt=""/>
				<div class="text-container1">
				<h1 class="welcomeLabel">Welcome To Flight Management System</h1>
		</div>

		</div>
		<div class = "viewDiv">
        <a href="/flights"><img class="viewFlights" src="https://i.ibb.co/FHB0Byy/Leonardo-Diffusion-XL-create-a-background-photo-of-an-airplane-3.jpg" width="20%" height="20%" alt=""/></a>
				<div class="text-container">
				<h1 class="bookFlightsLabel">Flights</h1>
		</div>

		</div>
		<div class="bookingDiv">
        <a href="/airlines" ><img class="bookFlights" src="https://i.ibb.co/jMCXPSL/Leonardo-Diffusion-XL-create-a-background-photo-of-an-airplane-1.jpg" width="385px" height="20%" alt=""/>
			<div class="text-container">
				<h1 class="bookFlightsLabel">Airlines</h1>
		</div>

		</a>
		</div>
		<div class="aircraftDiv">
        <a href="/aircrafts" ><img class="bookFlights" src="https://i.ibb.co/jMCXPSL/Leonardo-Diffusion-XL-create-a-background-photo-of-an-airplane-1.jpg" width="385px" height="20%" alt=""/>
			<div class="text-container">
				<h1 class="bookFlightsLabel">Aircrafts</h1>
		</div>

		</a>
		</div>
    </div>
</body>
</html>
