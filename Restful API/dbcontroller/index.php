   <?php
require_once("dbcontroller.php");


$query ="SELECT * FROM campus";

?>
<html>
<head>
    <TITLE>Campus and Faculty Select</TITLE>
<head>
<style>
        body{width:610px;}
        .frmDronpDown {border: 1px solid #F0F0F0;background-color:#C8EEFD;margin: 2px 0px;padding:40px;}
        .demoInputBox {padding: 10px;border: #F0F0F0 1px solid;border-radius: 4px;background-color: #FFF;width: 50%;}
        .row{padding-bottom:15px;}
</style>
    <script src="jquery.min.js" type="text/javascript"></script>
<script>
    function getcampus_id(val) {
        $.ajax({
        type: "POST",
        url: "get_faculty.php",
        data:'campus_id='+val,
        success: function(data){
            $("#faculty-list").html(data);
        }
        });
    }

    function getfaculty_id(val) {
        
        $.ajax({
        type: "POST",
        url: "get_course.php",
        data:{
            'faculty_id':val,
            'campus_id':$('#campus-list').val()
        },
        success: function(data){
            $("#course-list").html(data);
        }
        });
    }

    function selectcampus_id(val) {
    $("#search-box").val(val);
    $("#suggesstion-box").hide();
    }
</script>
</head>
<body>
<form id="rightcol" action="form.php" method="post" class="container">
    <div class="frmDronpDown">
        <div class="row">
            <label>Campus:</label><br/>
                <select name="campus" id="campus-list" class="demoInputBox" onChange="getcampus_id(this.value);">
                    <option value="">Select Campus</option>
                    <?php
                                $query ="SELECT * FROM campus";
                                $result = mysqli_query($con, $query);
                                //loop
                                while($campus = mysqli_fetch_assoc($result)) :
                                //foreach ($result as $campus){
                            ?>
                        <option value="<?php echo $campus["campus_id"]; ?>"> <?php echo $campus["name"]; ?></option>
                        <?php
                        endwhile;
                        ?>
                </select>
        </div>
        <div class="row">
            <label>Faculty:</label><br/>
                <select name="faculty" id="faculty-list" class="demoInputBox" onChange="getfaculty_id(this.value);">
                    <option value="">Select Faculty</option>
                </select>
        </div>
        <div class="row">
            <label>Course:</label><br/>
                <select name="course" id="course-list" class="demoInputBox" >
                    <option value="">Select Course</option>
                </select>
        </div>
    </div>
</body>
</html>