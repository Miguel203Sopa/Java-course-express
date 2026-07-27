<?php
 function connect() {
 return new
PDO('mysql:host=localhost;dbname=autocompletedb;charset=utf8', 'root',
'', array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION)
 );
 }
 $pdo = connect();
 $result_array = array();
 $sql = "SELECT * FROM country
 ORDER BY country_id ASC";
 $query = $pdo->prepare($sql);
 $query->execute();
 $list = $query->fetchAll();
 foreach ($list as $rs){

 array_push($result_array, $rs);

 }
 header('Content-type: application/json');
 echo json_encode($result_array);
?>
