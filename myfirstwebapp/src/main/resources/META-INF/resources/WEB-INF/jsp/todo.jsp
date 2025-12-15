<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="/webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Todo Page</title>
</head>
<body>
    <div class="container">
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>    
                <form:input type="text" path="description" required="required" />
                <form:errors path="description" cssClass="text-warning" />
            </fieldset>
            <fieldset class="mb-3">
                <form:label path="targetDate">Target Date</form:label>    
                <form:input type="text" path="targetDate" required="required" />
                <form:errors path="targetDate" id="targetDate" />
            </fieldset>

            <form:input type="hidden" path="id" />
            <form:input type="hidden" path="done" />
            <input type="submit" class="btn btn-success" />
        </form:form>
    </div>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

    <script>
    $(function () {
        $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true
        });
    });
    </script>
</body>
</html>