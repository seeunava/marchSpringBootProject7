<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Head content -->
</head>
<body>
<div class="container">
    <h2>Search Employee</h2>
    <form action="search" method="post">
        <div class="form-group">
            <label for="searchTerm">Enter Employee Name:</label>
            <input type="text" class="form-control" id="searchTerm" name="searchTerm" placeholder="Employee Name" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-search">Search</button>
        </div>
    </form>
    <div class="text-center">
        <a href="congratulations" class="btn btn-secondary">Back to Congratulations</a>
    </div>
</div>
</body>
</html>
