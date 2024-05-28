<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Head content -->
</head>
<body>
<div class="container">
    <h2>Search Results</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <!-- Add other columns as needed -->
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${employeeDTO.employeeId}</td>
                <td>${employeeDTO.employeeName}</td>
                <!-- Add other columns as needed -->
            </tr>
        </tbody>
    </table>
    <div class="text-center">
        <form action="congratulations" method="post">
            <button type="submit" class="btn btn-primary">Go to Congratulations Page</button>
        </form>
        <a href="fetchAllRecords" class="btn btn-primary">Fetch All Records</a> <!-- Add this link -->
    </div>
</div>
</body>
</html>
