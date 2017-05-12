
<html>
<head>
	<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Registration Complete</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">-->


        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />
        <link rel="stylesheet" href="assets/css/opensans-web-font.css" />
        <link rel="stylesheet" href="assets/css/montserrat-web-font.css" />

		<!--For font-awesome css-->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body>

<?php 

include'config.php';

//connect to db
if(!($connection = @ mysql_connect($hostName, $username, $password)))
	showerror();
//select db
if(!mysql_select_db($databaseName, $connection))
	showerror();

//create SQL statement
$fname = $_POST['fname'];
$lname = $_POST['lname'];
$email = $_POST['email'];
$address = $_POST['address'];
$passw = $_POST['passw'];
$phone = $_POST['phone'];


$query = "INSERT INTO CUSTOMER (Fname, Lname, Email, Address, Passw, Phone) VALUES ('$fname', '$lname', '$email', '$address', '$passw', '$phone')";

//execute statement
if(!($result = @ mysql_query ($query, $connection)))
	showerror();

echo "Registration Successful";
 ?>

<a href="index.html">RETURN HOME</a>

</body>
</html>