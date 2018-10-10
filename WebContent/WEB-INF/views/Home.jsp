<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create SSO</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="CSS/app.css" rel="stylesheet" />

</head>
<body>
<form action="../Home.jsp" method="get">
    <div class="container page_header">
        <div class="row ">
            <div class="col-sm-4">
                <a href="Home.jsp" class="usflogo"><img class="img-responsive" src="Images/usfLogo.jpg" alt="USF Logo" /></a>
            </div>
            <div class="col-sm-6">
                <label class="page_header_text">SSO Request System</label>
            </div>
            <div class="col-sm-2 page_header_logout">
                <button type="button" style="width:120px;" class="btn btn-default "><span class="glyphicon glyphicon-log-out"></span> NetID Logout</button>
            </div>
        </div>
        </div>
        <br />
        <br />

        <div class="panel panel-default">
            <div style="align-items: center;display: flex;justify-content: center;" class="panel-heading">
                <label for="CreateNewSSO"> Create New SSO </label>
            </div>
            <div class="panel-content">
                <div class="form-group">
                    <br />
                    <label for="PurposeToCreateSSO">Briefly describe the purpose for this SSO Request </label>
                    <textarea class="form-control" rows="5"></textarea>
                </div>
                <div class="form-group">
                    <br />
                    <label for="SSODetails">Please enter the URL to be added to the SSO </label>
                    <div class="input-group col-sm-12">
                        
                            <span class="input-group-addon">Prod URL </span>
                            <input id="msg" type="text" class="form-control" name="msg" placeholder="Prod URL">
                        
                            <span class="input-group-addon">Date of Deployment </span>
                            <input id="msg" type="text" class="form-control" name="msg" placeholder="Date of Deployment">
                        
                    </div>
                    <br />
                    <div class="input-group col-sm-12">

                        <span class="input-group-addon">Test URL </span>
                        <input id="msg" type="text" class="form-control" name="msg" placeholder="Test URL">

                        <span class="input-group-addon">Date of Deployment </span>
                        <input id="msg" type="text" class="form-control" name="msg" placeholder="Date of Deployment">

                    </div>
                </div>
            </div>
        </div>
        <div>
<%--    <c:forEach var="contact" items="${listSSO}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.address}</td>
                    <td>${contact.mobile}</td>
                    <td>
                        <a href="/SSO/editContact?id=${contact.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/SSO/deleteContact?id=${contact.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach> --%>
 </div>
 </form>
</body>

</html> 
