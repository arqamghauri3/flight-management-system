<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airlines Form</title>
    <style>
        body {
            font-family: 'Tw Cen MT', 'Arial', sans-serif;
            background-color: #f4f4f4;
            background-image: url('https://i.ibb.co/H2nWhzR/Background.png');
            background-size: 100% 100%;
            background-repeat: no-repeat;
            background-position: center;

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
    <h1>Airlines</h1>

    <form action="/airlines/updateAirlines/${airline.airlineID}" method="post">
    	<input type="hidden" name="_method" value="PUT">
        <label for="airlineName">Airline Name:</label>
        <input type="text" id="airlineName" name="airlineName" required>

        <label for="iaaaCode">IAAA Code:</label>
        <input type="text" id="iaaaCode" name="iaaaCode" required>

        <label for="countryName">Country Name:</label>
        <input type="text" id="countryName" name="countryName" required>

        <button type="submit">Add</button>
    </form>
</div>

</body>
</html>
