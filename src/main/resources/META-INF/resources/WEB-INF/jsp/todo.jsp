<%@ include file="common/header.jspf"%>
<div class="container">
    <h1>Add New Todo</h1>
    <hr>
    <!-- here one form is coming form spring form tag library used above to easily pass param in form -->
     <form:form method="post" modelAttribute="todo">
        <div>
            <p>Tittle :</p>
            <form:input type="text" path="title"/>
            <p>Description :</p>
            <!-- here in place of name we have given path because then this 'description' will bind to description of todo class -->
            <form:input type="text" path="description"/>
            <form:errors path="description" cssClass="text-warning"/>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="isDone"/>
            <p>Target Date :</p>
            <form:input type="date" path="targetDate"/>
            <hr>
            <input type="submit" class="btn btn-success"/>
        </div>
     </form:form>
</div>
<%@ include file="common/footer.jspf"%>