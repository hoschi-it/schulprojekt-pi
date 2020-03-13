<?php
//Define database specifications
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


//Einloggen
if($_GET['goal']=="login"){ //localhost:8080/schulprojekt/Controller.php?goal=login&email=dimitri.khodak@gmail.com&password=1234
  $sql = "SELECT * FROM user WHERE EMail = '" .  $_GET['email'] . "' AND passwort = '" . $_GET['password'] . "'";
  $result = mysqli_query($conn, $sql);
  $row = mysqli_fetch_assoc($result);
  echo json_encode($row);
}

//Gerät mit zugehöriger Adresse hinzufügen
else if($_GET['goal']=="addDevice"){ //localhost:8080/schulprojekt/Controller.php?goal=addDevice&type=computer&lastmaintenance=YYYY-MM-DD&nextmaintenance=YYYY-MM-DD&idlocation=1&employeeno=1
  $sql = "INSERT INTO device(Type, Last_Maintenance, Next_Maintenance, Id_Location, Employee_No) VALUES('".$_GET['type']."', " . $_GET['lastmaintenance'] . ", " . $_GET['nextmaintenance'] . ", " . $_GET['idlocation'] . ", " . $_GET['employeeno'] . ")";
  echo mysqli_query($conn, $sql);
}

//Abrufen der dem eingeloggten Mitarbeiter zugewiesenen Geräte
else if($_GET['goal']=="getAllDevices"){ //localhost:8080/schulprojekt/Controller.php?goal=getAllDevices&employeeno=1
  $sql = "SELECT Id_Device, Type, Last_Maintenance, Next_Maintenance, location.Id_Location, City, Postal_Code, Street, Room_No FROM `location` INNER JOIN (SELECT * FROM `device` WHERE Employee_No = ".$_GET['employeeno'].") AS devices ON location.Id_Location = devices.Id_Location";
  $result = mysqli_query($conn, $sql);
  if ($result->num_rows > 0) {
    $devices = array();
    $index = 1;
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $devices['Device_'.$index] = array('Id_Device' => $row["Id_Device"], 'Type' => $row["Type"], 'Last_Maintenance'=>$row["Last_Maintenance"], 'Next_Maintenance'=>$row["Next_Maintenance"], 'Location' => array('location_Id' => $row["Id_Location"], 'City'=> $row["City"], 'Postal_Code' => $row["Postal_Code"], 'Street'=>$row["Street"], 'Room_Number'=>$row["Room_No"]));
      $index++;
    }
    echo json_encode($devices);
} else {
    echo "0 results";
}
  $row = mysqli_fetch_assoc($result);
  //echo json_encode($row);
}

//Nächste Wartung eines Geräts einsehen
else if($_GET['goal']=="getNextMaintenance"){ //localhost:8080/schulprojekt/Controller.php?goal=getNextMaintenance&deviceId=1
  $sql = "SELECT * FROM device WHERE Id_Device = " . $_GET['deviceId'];
  $result = mysqli_query($conn, $sql);
  $row = mysqli_fetch_assoc($result);
  $device = array('Device_Id'=>$row["Id_Device"], 'Last_Maintenance'=>$row["Last_Maintenance"], 'Next_Maintenance'=>$row["Next_Maintenance"]);
  echo json_encode($device);
}

//Eintragen der Wartungen
else if($_GET['goal']=="setNextMaintenance"){ //localhost:8080/schulprojekt/Controller.php?goal=setNextMaintenance&deviceId=1&lastdate=YYYY-MM-DD&nextdate=YYYY-MM-DD
  $sql = "UPDATE device SET Last_Maintenance = '".$_GET['lastdate']."', Next_Maintenance = '".$_GET['nextdate']."' WHERE Id_Device = ".$_GET['deviceId'];
  echo mysqli_query($conn, $sql);
}
?>
