<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "networkmaintenance";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT Employee_No, First_Name, Last_Name, passwort, EMail FROM user WHERE Employee_No=1";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_assoc($result);
  $employee = array("Employee_No"=>$row["Employee_No"], "First_Name:"=>$row["First_Name"]);
    // output data of each row
    //while($row = mysqli_fetch_assoc($result)) {
    //    echo "Employee_No: " . $row["Employee_No"]. " - Name: " . $row["First_Name"]. " " . $row["Last_Name"]. " " . " - passwort: " . $row["passwort"] . "<br>";
        echo json_encode($employee);
    //}
} else {
    echo "0 results";
}

//The connection will be closed automatically when the script ends. To close the connection before, use the following:
mysqli_close($conn);
?>
