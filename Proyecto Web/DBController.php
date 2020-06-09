<?php
class DBController
{
   
    private $host = "fdb26.awardspace.net";

    private $user = "3443139_pruebas";

    private $password = "abc123.@";

    private $database = "3443139_pruebas";

    private $conn;

    function __construct()
    {
        $this->conn = $this->connectDB();
    }

    function connectDB()
    {
        $conn = mysqli_connect($this->host, $this->user, $this->password, $this->database);
		$conn->set_charset('utf8');
        return $conn;
    }

    function runQuery($query)
    {
        $result = mysqli_query($this->conn, $query);
        while ($row = mysqli_fetch_array($result)) {
            $resultset[] = $row;
        }
        if (! empty($resultset))
            return $resultset;
    }
}
?>