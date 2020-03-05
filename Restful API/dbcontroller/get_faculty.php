<?php

error_reporting(E_ALL); 
ini_set('display_errors', 1);

require_once("dbcontroller.php");

if(!empty($_POST["campus_id"])) {
    $campus_id = $_POST["campus_id"];
    $query ="SELECT * FROM faculty WHERE campus_id = $campus_id";
    $result = mysqli_query($con, $query);

    if ( $result === false ) {
        echo mysqli_error($con);
        exit;
    }

    echo '<option value="">Select Campus</option>';

    while ( $faculty = mysqli_fetch_assoc($result) ) :  
        echo '<option value="' . $faculty['faculty_id'] . '">';
        echo $faculty['faculty_name']; 
        echo '</option>';
    endwhile;
    }
?>