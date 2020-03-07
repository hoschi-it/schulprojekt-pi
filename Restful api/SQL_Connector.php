<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "networkmaintenance";

function login($email, $password){
  // Create connection
  $conn = mysqli_connect($servername, $username, $password, $dbname);

  // Check connection
  if (!$conn) {
      die("Connection failed: " . mysqli_connect_error());
  }

  $sql = "SELECT * FROM user WHERE EMail = '" . $email . "' AND passwort = '". $password ."'";
  $result = mysqli_query($conn, $sql);

  return getJSON($result);
}

function getJSON($result){
  if (mysqli_num_rows($result) > 0) {
    $row = mysqli_fetch_assoc($result);
    $employee = array("Employee_No"=>$row["Employee_No"], "First_Name"=>$row["First_Name"], "Last_Name"=>$row["Last_Name"], "passwort"=>$row["passwort"], "EMail"=>$row["EMail"]);
      // output data of each row
      //while($row = mysqli_fetch_assoc($result)) {
          echo json_encode($employee);
      //}
  } else {  echo "0 results"; }
}

//The connection will be closed automatically when the script ends. To close the connection before, use the following:
//mysqli_close($conn);
?>
