<html>
<head>
    <title>Create</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<form action="create" method="POST">
<pre>
    <strong>Create Here | <a href="../read">Click for Read</a></strong>

	Name: <input type="text" name="name" />

	Email: <input type="text" name="email" />

	Course: <input type="text" name="course" />

	<input type="submit" value="Create" />
</pre>
</form>
<div style="color:${color}">${msg}</div>
</body>
</html>