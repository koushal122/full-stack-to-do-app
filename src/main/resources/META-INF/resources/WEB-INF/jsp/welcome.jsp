<%@ include file="common/header.jspf"%>
<div class="container">
    <div class="d-flex justify-content-between mt-2">
        <span>Welcome ${name}</span>
        <a href="/logout" class="btn btn-warning">Logout</a>
    </div>
    <hr>
    <h1>Your Todos :- </h1>
    <table class="table">
           <thead>
               <tr>
                      <th>Title</th>
                      <th>Description</th>
                      <th>Target Date</th>
                      <th>Is done?</th>
                      <th></th>
                      <th></th>
               </tr>
           </thead>
           <tbody>
               <c:forEach items="${todos}" var="todo">
                   <tr>
                       <td>${todo.title}</td>
                       <td>${todo.description}</td>
                       <td>${todo.targetDate}</td>
                       <td>${todo.isDone}</td>
                       <td><a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                       <td><a href="/delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
                   </tr>
               </c:forEach>
           </tbody>
     </table>
     <a href="/todo" class="btn btn-success">Add new Todo</a>
</div>
<%@ include file="common/footer.jspf"%>