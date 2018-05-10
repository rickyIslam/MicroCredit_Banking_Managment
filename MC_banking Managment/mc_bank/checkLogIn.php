<?php
    $response=array();
    if(isset($_POST['password']))
    {
 
        $password=$_POST['password'];

		
        $query="select * from password_field where password='".$password."'";
        $con=mysql_connect("localhost", "root", "");
        mysql_select_db("bank");
        $result=mysql_query($query, $con);

        
        if(!empty($result))
        {
            if(mysql_num_rows($result)>0)
            {
                while($row=mysql_fetch_array($result))
                {
                    $password =$row['password'];
		   $response['message']="Welcome $password";
                }

                $response['success']=1;
				
                echo json_encode($response);
            }
            else {
                 $response['success']=0;
                 $response['message']='Wrong Email or Password';
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