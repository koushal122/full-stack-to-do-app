<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Document</title>
</head>
<body>
   <div class="container">
        <h1>Add New Todo</h1>
        <hr>
        <!-- here one form is coming form spring form tag library used above to easily pass param in form -->
         <form:form method="post" modelAttribute="todo">
            <div>
                <p>Name :</p>
                <form:input type="text" path="username"/>
                <p>Description :</p>
                <!-- here in place of name we have given path because then this 'description' will bind to description of todo class -->
                <form:input type="text" path="description"/>
                <form:errors path="description" cssClass="text-warning"/>
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="isDone"/>
                <hr>
                <input type="submit" class="btn btn-success"/>
            </div>
         </form:form>
   </div>
   <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
   <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>