<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IMAGES</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
    <div>
        <form id="image_add_form" action="/images/add" method="POST" enctype="multipart/form-data">
            <input name="title" placeholder="title">
            <input type="file" name="file" value="Image" accept="image/*,image/jpeg,image/png"/>
            <button id="add">add image</button>
        </form>
    </div>
    <div>
        <c:forEach items="${images}" var="image">
            <p>${image}</p>
        </c:forEach>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#add").click(function (e) {
                e.preventDefault();
                var form = $('#image_add_form');
                var formInputs = $('#image_add_form input');
                var formData = new FormData();
                formInputs.each(function (item, input) {
                    if(input.type == 'file') {
                        formData.append(input.name, input.files[0]);
                    } else {
                        formData.append(input.name, input.value);
                    }
                });
                $.ajax({
                    type: "POST",
                    url: form.attr('action'),
                    data: formData,
                    encType: "multipart/form-data",
                    contentType:false,
                    cache: false,
                    processData : false,
                    success : function(data) {
                    },
                    error : function(err) {
                    }
                });
            });
        });
    </script>
</body>
</html>