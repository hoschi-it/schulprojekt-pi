<?php
include 'SQL_Connector.php';

//Einloggen
if($_GET['goal']=="login"){ //localhost:8080/schulprojekt/Controller.php?goal=login&email=dimitri.khodak@gmail.com&password=1234
  echo login($_GET['email'], $_GET['password']);
}

//Gerät mit zugehöriger Adresse hinzufügen
else if($_GET['goal']=="addDevice"){ //localhost:8080/schulprojekt/Controller.php?goal=addDevice&type=computer&lastmaintenance=YYYY-MM-DD&nextmaintenance=YYYY-MM-DD&idlocation=1&employeeno=1
  echo "INSERT INTO device(Type, Last_Maintenance, Next_Maintenance, Id_Location, Employee_No) VALUES('".$_GET['type']."', " . $_GET['lastmaintenance'] . ", " . $_GET['nextmaintenance'] . ", " . $_GET['idlocation'] . ", " . $_GET['employeeno'] . ")";
}

//Abrufen der dem eingeloggten Mitarbeiter zugewiesenen Geräte
else if($_GET['goal']=="getAllDevices"){ //localhost:8080/schulprojekt/Controller.php?goal=getAllDevices&employeeno=1
  echo "SELECT * FROM device WHERE Employee_No = " . $_GET['employeeno'];
}

//Nächste Wartung eines Geräts einsehen
else if($_GET['goal']=="getNextMaintenance"){ //localhost:8080/schulprojekt/Controller.php?goal=getNextMaintenance&deviceId=1
  echo "SELECT * FROM device WHERE Id_Device = " . $_GET['deviceId'];
  //call php file to get data
}

//Eintragen der Wartungen
else if($_GET['goal']=="setNextMaintenance"){ //localhost:8080/schulprojekt/Controller.php?goal=setNextMaintenance&deviceId=1&lastdate=YYYY-MM-DD&nextdate=YYYY-MM-DD
  echo "UPDATE device SET Last_Maintenance = '".$_GET['lastdate']."', Next_Maintenance = '".$_GET['nextdate']."' WHERE Id_Device = ".$_GET['deviceId'];
}
?>
