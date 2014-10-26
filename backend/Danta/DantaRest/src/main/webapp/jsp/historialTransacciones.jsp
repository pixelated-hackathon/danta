<%-- 
    Document   : expedienteDigitalConsulta
    Created on : Oct 25, 2014, 7:34:19 PM
    Author     : william
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expediente Digital - Historial de Transacciones</title>
        <link href="<c:url value="/resources/main/css/expedienteDigitalConsulta.css" />" rel="stylesheet">
    </head>
    <body>
        <div style="width: 700px;z-index: -1;position: absolute;left: 387px;top: 7PX;color: white;font-size: 20px;letter-spacing: 1px;">PRINCIPAL | CONSULTA </div>
        <div class="rightpane">  
            <div style="margin-top: 125px;margin-left: 5px;">VER EN EXPEDIENTE</div>
            <div style="margin-top: 50px;margin-left: 5px;"><a href="http://localhost:8080/web/ExpedienteDigital/HistorialTransacciones?phone=87040233">HISTORIAL TRANSACCIONAL</a></div>
            <div style="margin-top: 50px;margin-left: 5px;">ESTADO ACTUAL</div>
            <div style="margin-top: 50px;margin-left: 5px;"><a href="http://localhost:8080/web/ExpedienteDigital/Desembolso?phone=87040233">REALIZAR PAGO</a></div>
            <div style="margin-left: 15px;margin-top: 100px;">
                <img style="width: 100px;" src="<c:url value="/resources/main/source/logo.png" />"/>
            </div>
            <div style="margin-left: 50px;margin-top: 20px;width: 50px;">
                <img style="width: 50px;" src="<c:url value="/resources/main/source/back.png" />"/>
            </div>
            <div style="width: 10px;z-index: -1;position: absolute;left: 976px;top: 616px;">Atrás</div>
        </div>  
        
        <div class="content">
            <div style="width: 200px;z-index: -1;position: absolute;left: 370px;top: 56px;color: white;font-size: 35px;">Familia ${family.familyLastName}</div>
        </div>
        
    </body>
</html>
