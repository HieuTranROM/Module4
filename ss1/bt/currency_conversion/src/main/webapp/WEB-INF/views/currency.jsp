<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 7/14/2024
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conversion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Money Conversion</h1>
    <form action="result" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">USD:</label>
            <input type="number" class="form-control" style="width: 300px" id="exampleInputEmail1" name="usd" aria-describedby="emailHelp" placeholder="USD">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Amount:</label>
            <input type="number" class="form-control" style="width: 300px" name="amount" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">Convert</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>