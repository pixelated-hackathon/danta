<%-- 
    Document   : expedienteDigitalConsulta
    Created on : Oct 25, 2014, 7:34:19 PM
    Author     : william
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expediente Digital - Consulta</title>
        <link href="<c:url value="/resources/main/css/expedienteDigitalConsulta.css" />" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Roboto'>
        <link rel="stylesheet" type="text/css" href='http://fonts.googleapis.com/css?family=Droid+Sans'>
    </head>
    <body>
        <div style="width: 700px;z-index: -1;position: absolute;left: 387px;top: 7PX;color: darkgrey;font-size: 17px; font-family:sans-serif ;letter-spacing: 3px;">PRINCIPAL |  CONSULTA </div>
        <div class="rightpane"  style="font-family: Roboto">  
            <div style="margin-top: 125px;margin-left: 5px;">VER EN EXPEDIENTE</div>
            <div style="margin-top: 50px;margin-left: 5px;"><a href="http://localhost:8080/web/ExpedienteDigital/HistorialTransacciones?phone=87040233">HISTORIAL TRANSACCIONAL</a></div>
            <div style="margin-top: 50px;margin-left: 5px;"><a href="http://localhost:8080/web/ExpedienteDigital/SaludFinanciera?phone=87040233">SALUD FINANCIERA</a></div>
            <div style="margin-top: 50px;margin-left: 5px;"><a href="http://localhost:8080/web/ExpedienteDigital/Desembolso?phone=87040233">DESEMBOLSO</a></div>
            <div style="margin-left: 15px;margin-top: 100px;">
                <img style="width: 100px;" src="<c:url value="/resources/main/source/logo.png" />"/>
            </div>
            <div style="margin-left: 50px;margin-top: 10px;width: 50px;">
                <img style="width: 50px;" src="<c:url value="/resources/main/source/back.png" />"/>
            </div>
            <div style="width: 10px;z-index: 1;position: absolute;left: 976px;top: 616px;"><a href="http://localhost:8080/web/ExpedienteDigital/Consulta?phone=87040233">VOLVER</a></div>
        </div>  
        
         <div class="content">
            <div style="width: 250px;z-index: -1;position: absolute;left: 370px;top: 56px;color: white;font-size: 35px;font-family: Roboto;">Familia ${family.familyLastName}</div>
            
            <div style="width: 400px;z-index: -1;position: absolute;left: 370px;top: 130px;color: white;font-size: 20px; font-family: sans-serif">HISTORIAL DE TRANSACCIONES</div>
            
            <div class="CSSTableGenerator" style="width: 525px;z-index: 1;position: absolute;left: 360px;top: 160px;">
            <table style="font-size: 15px;">
                <tr >
                    <td>Fecha Realizada</td>
                    <td>Comercio</td>
                    <td>Descripcion</td>
                    <td>Monto</td>
                 </tr>
                 
                    <c:forEach items="${transactions}" var="transaction">
                        <tr>
                            <td style="font-size: 15px;"><fmt:formatDate value="${transaction.createDate}" pattern="yy-MMM-dd : HH:mm"/></td>
                            <td style="font-size: 15px;"><c:out value="${transaction.commerceDescription}"/></td>
                            <td style="font-size: 15px;"><c:out value="${transaction.description}"/></td>
                            <td style="font-size: 15px;"><c:out value="${transaction.amount}"/></td>
                        </tr>
                    </c:forEach>
                 </div>
            </table>
        </div>
        
    </body>
</html>
