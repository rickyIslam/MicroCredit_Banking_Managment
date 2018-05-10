<?php
    $response=array();
    if(isset($_GET['keyword']))
    {
        $keyword=$_GET['keyword'];
        
        $query="select * from loan where account_num ='".$keyword."'";
        $con=mysql_connect("localhost", "root", "");
        mysql_select_db("bank");
        $result=mysql_query($query, $con);

        
        if(!empty($result))
        {
            if(mysql_num_rows($result)>0)
            {
                $response['info']=array();

                while($row=mysql_fetch_array($result))
                {
                    $book =array();
                    $book['date']=$row['date'];
                    $book['time']=$row['time'];
                    $book['account_num']=$row['account_num'];
                    $book['loan_id']=$row['loan_id'];
                    $book['name']=$row['name'];
		    $book['amount']=$row['amount'];
                    $book['still_paid']=$row['still_paid'];
			$book['deadline']=$row['deadline'];

                    array_push($response['info'], $book);
                }

                $response['success']=1;

                echo json_encode($response);
            }
            else {
                 $response['success']=0;
                 $response['message']='No match found';
                 echo json_encode($response);
            }
        }
    }
    else
    {
        $response['success']=0;
        $response['message']='Required field(s) missing';
        echo json_encode($response);
    }

?>