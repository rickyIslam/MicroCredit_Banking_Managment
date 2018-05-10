<?php

$response=array();

if(isset($_POST['date']) && isset($_POST['time']) && isset($_POST['acc']) && isset($_POST['loan'])&& isset($_POST['name'])&& isset($_POST['amount'])&& isset($_POST['dpayment'])&& isset($_POST['deadline']))
{
$date =$_POST['date'];   
$time=$_POST['time'];   
$acc=$_POST['acc'];
    $loan=$_POST['loan'];
    $name=$_POST['name'];
    $amount=$_POST['amount'];
    $dpayment=$_POST['dpayment'];
	 $deadline =$_POST['deadline'];


    $con=mysql_connect("localhost", "root", "");
    mysql_select_db("bank");

    
    
    $query="insert into loan (date,time,account_num,loan_id,name,amount,still_paid,deadline) values ('".$date."','".$time."','".$acc."','".$loan."','".$name."','".$amount."','".$dpayment."','".$deadline."')" ;
    $result=mysql_query($query);
    if($result)
    {
        $response['success']=1;
        $response['message']='Loan Taken';
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