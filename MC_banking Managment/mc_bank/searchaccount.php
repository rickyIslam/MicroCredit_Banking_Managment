<?php
    $response=array();
    if(isset($_GET['keyword']))
    {
        $keyword=$_GET['keyword'];
        
        $query="select * from info where acc ='".$keyword."'";
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
                    $book['acc']=$row['acc'];
                    $book['date']=$row['date'];
                    $book['name']=$row['name'];
                    $book['phone']=$row['phone'];
                    $book['nid']=$row['nid'];
		    $book['occupation']=$row['occupation'];
                    $book['address']=$row['address'];

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