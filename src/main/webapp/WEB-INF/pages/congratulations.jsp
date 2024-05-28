<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Congratulations</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azpdJjpo+UL94ABrWfFZbRVsH/JzJbAA9DH8oh4h/xY+8m2CkXCs8oA/" crossorigin="anonymous">
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        table {
            background-color: #fff;
        }
        th, td {
            padding: 10px;
        }
        .btn {
            margin-right: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Congratulations!!!!</h2>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Salary</th>
                    <th>Email address</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${employeeDTO.employeeId}</td>
                    <td>${employeeDTO.employeeName}</td>
                    <td>${employeeDTO.salary}</td>
                    <td>${employeeDTO.emailId}</td>
                    <td>${employeeDTO.password}</td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="text-center">
        <a href="fetchAllRecords" class="btn btn-primary">Find All Records</a>
        <a href="logout" class="btn btn-danger">Logout</a>
        <a href="search" class="btn btn-success">Search</a>
    </div>
</div>

</body>
</html>
