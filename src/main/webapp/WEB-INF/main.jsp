<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body {
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
		    background-size: 100% 100%;
            background-repeat: no-repeat;
            background-position: center;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            height: 737px; /* Adjust the height as needed */
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
		
        .headerDiv {
            position: relative;
            overflow: hidden; /* Hide overflow from absolutely positioned elements */
        }

        /* Darkening effect on hover */
        .headerDiv:hover img {
            filter: brightness(70%); /* Adjust the brightness value as needed */
			
        }

        /* Show the text container on hover */
        .headerDiv:hover .text-container {
            opacity: 1;
        }

		.flightmanagementlabel{
			position: absolute;
            top: 20%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white; 
            text-align: center;
			
		}
        .text-container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white; /* Text color */
            text-align: center;
            z-index: 1; /* Place the text container above the image */
            opacity: 0; /* Initially hidden */
            transition: opacity 0.3s; /* Smooth transition */
        }
		.flightbookingslabel{
			position: absolute;
            top: 20%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white; 
            text-align: center;

		}
		.footerDiv {
            position: relative;
            overflow: hidden; /* Hide overflow from absolutely positioned elements */
        }

        /* Darkening effect on hover */
        .footerDiv:hover img {
            filter: brightness(70%); /* Adjust the brightness value as needed */
			
        }

        /* Show the text container on hover */
        .footerDiv:hover .text-container {
            opacity: 1;
        }

		
    </style>
</head>
<body>
	<div class="headerDiv">
		<a href="/admin/login"><img class="flightmanagementImg" src="https://i.ibb.co/Vwfx3BB/header-Img.jpg" width="1900" height="419" alt=""/>
			<div class="text-container">
				<h1 class="flightmanagementlabel">Flight Management System</h1>
		</div>
			</a>
		</div>
	
	<div class="footerDiv">
			<a href="/user/login" ><img src="https://i.ibb.co/xJrPpXq/downImg.jpg" width="1900" height="500" alt=""/>
			<div class="text-container">
				<h1 class="flightbookingslabel">Flight Booking System</h1>
		</div>
		</a>
	</div>
</body>
</html>
