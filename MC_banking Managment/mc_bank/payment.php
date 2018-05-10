<?php

$response=array();

if(isset($_POST['date']) && isset($_POST['acc']) && isset($_POST['loan'])&& isset($_POST['amount']))
{
 $date=$_POST['date'];    
$acc=$_POST['acc'];
    $loan=$_POST['loan'];
  
    $amount=$_POST['amount'];



    $con=mysql_connect("localhost", "root", "");
    mysql_select_db("bank");

    
    
    $query="insert into payment (date,acc,loan,amount) values ('".$date."','".$acc."','".$loan."','".$amount."')" ;
    $result=mysql_query($query);
    if($result)
    {
        $response['success']=1;
        $response['message']='Payment Recorded';
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