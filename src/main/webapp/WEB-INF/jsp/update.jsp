<html>
<head>
    <title>Create</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<form action="../update" method="POST">
<pre>
    <h2>Update student</h2>

    Id: <input  type="hidden" name="id" value ="${student.id}" />

	Name: <input type="text" name="name" value ="${student.name}"/>

	Email: <input type="text" name="email" value ="${student.email}" />

	Course: <input type="text" name="course" value = "${student.course}" />

	<input type="submit" value="Change" />
</pre>
</form>

</body>
</html>