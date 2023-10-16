
<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>
<div class="container">
<pre>${errorlogin}</pre>

<form:form method="post" modelAttribute="todo">
	<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" required="required"/>
 		<form:errors path="description"/>
	</fieldset>
<fieldset class="mb-3 ">
		<form:label path="targetDate">Target Date</form:label>
		<form:input type="text" path="targetDate" required="required"/>
 		<form:errors path="description"/>
	</fieldset>
 <br>
		<form:input type="hidden" path="id"/><br>
		<form:input type="hidden" path="done" /><br>
	<input class="btn btn-secondary"  type="submit">
</form:form>
</div>


<%@include file="common/footer.jspf" %>
<script type="text/javascript">
$('#targetDate').datepicker({
	format: 'dd/mm/yyyy'
 
	});
</script>