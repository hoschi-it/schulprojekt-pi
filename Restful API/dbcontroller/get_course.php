<?php

error_reporting(E_ALL); 
ini_set('display_errors', 1);

require_once("dbcontroller.php");

if(!empty($_POST["campus_id"])) {
    $campus_id = $_POST["campus_id"];
    $faculty_id=$_POST["faculty_id"];
    
    $query ="SELECT * FROM `course` WHERE `campus_id`=$campus_id and `faculty_id` = $faculty_id";
    $result = mysqli_query($con, $query);

    if ( $result === false ) {
        echo mysqli_error($con);
        exit;
    }

    echo '<option value="">Select Course</option>';

    while ( $course = mysqli_fetch_assoc($result) ) :   
        echo '<option value="' . $course['course_id'] . '">';
        echo $course['course_name']; 
        echo '</option>';
    endwhile;
    }
?>