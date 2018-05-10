<?php

$response=array();

if(isset($_POST['acc']) && isset($_POST['date'])&& isset($_POST['name'])&& isset($_POST['phone'])&& isset($_POST['nid'])&& isset($_POST['occupation'])&& isset($_POST['address']))
{
    $acc=$_POST['acc'];
    $date=$_POST['date'];
    $name=$_POST['name'];
    $phone=$_POST['phone'];
    $nid=$_POST['nid'];
    $occupation=$_POST['occupation'];
    $address=$_POST['address'];

    $con=mysql_connect("localhost", "root", "");
    mysql_select_db("bank");

    
    
    $query="insert into info (acc,date,name,phone,nid,occupation,address) values ('".$acc."','".$date."','".$name."','".$phone."','".$nid."','".$occupation."','".$address."')" ;
    $result=mysql_query($query);
    if($result)
    {
        $response['success']=1;
        $response['message']='Account Createdd';
        echo json_encode($response);
    }
    else
    {
        $response['success']=0;
        $response['message']='An error occurred';
        echo json_encode($response);
    }
}
else
{
    $response['success']=0;
    $response['message']='Required field(s) missing';
    echo json_encode($response);
}


?>