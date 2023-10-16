<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>
<h1>
Welcome to login page ${name}
</h1>
<div class="container">

<h2>Your todo</h2>
 <table class="table">
 <thead>
 <tr>
 	<th>Id</th>
 	<th>Name</th>
 	<th>Description</th>
 	<th>Target Date</th>
 	<th>Done</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items = "${todo}" var ="todo">  
  <tr>
  <td>${todo.id}</td>
  <td>${todo.username}</td>
  <td>${todo.description}</td>
  <td>${todo.targetDate}</td>
  <td>${todo.done}</td>
  <td> <a href="delete-todo?id=${todo.id }" class="btn btn-warning">DELETE</a></td>
    <td> <a href="update-todo?id=${todo.id }" class="btn btn-success">UPDATE</a></td>
  </tr>
</c:forEach>  
 </tbody>
 </table>
 <a href="add-todo" class="btn btn-success">Add New Todo</a>
 </div>
<%@include file="common/footer.jspf" %>