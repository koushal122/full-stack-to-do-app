<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Here we have added bootstrap to our project using web jars (means added dependency in pom.xml file) -->
    <!-- and here we are giving location for that boostrap files present in our external libraries section -->
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Document</title>
</head>
<body>
   <div class="container">
        <div>Welcome ${name}</div>
        <hr>
        <h1>Your Todos :- </h1>
        <table class="table">
               <thead>
                   <tr>
                         <th>ID</th>
                          <th>Name</th>
                          <th>Description</th>
                          <th>Target Date</th>
                          <th>Is done?</th>
                   </tr>
               </thead>
               <tbody>
                   <c:forEach items="${todos}" var="todo">
                       <tr>
                           <td>${todo.id}</td>
                           <td>${todo.username}</td>
                           <td>${todo.description}</td>
                           <td>${todo.targetDate}</td>
                           <td>${todo.isDone}</td>
                       </tr>
                   </c:forEach>
               </tbody>
         </table>
         <a href="/todo" class="btn btn-success">Add new Todo</a>
   </div>
   <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
   <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>