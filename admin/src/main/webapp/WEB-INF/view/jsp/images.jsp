<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IMAGES</title>
</head>
<body>
    <div>
        <form action="/images/add" method="POST" enctype="multipart/form-data">
            <input name="title" placeholder="title">
            <input type="file" name="data" value="Image" accept="image/*,image/jpeg,image/png"/>
            <input type="submit" value="add image">
        </form>
    </div>
    <div>
        <c:forEach items="${images}" var="image">
            <p>${image}</p>
        </c:forEach>
    </div>
</body>
</html>