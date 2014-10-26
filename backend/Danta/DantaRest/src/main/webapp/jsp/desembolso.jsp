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
        <title>Expediente Digital - Desembolso</title>
        <link href="<c:url value="/resources/main/css/expedienteDigitalDesembolso.css" />" rel="stylesheet">
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
            <div style="width: 250px;z-index: -1;position: absolute;left: 370px;top: 56px;color: white;font-size: 35px;font-family: Roboto">Familia ${family.familyLastName}</div>
            <div class="jefeback">

                <div style="width: 500px;z-index: -1;position: absolute;left: 370px;top: 100px;color: white;font-size: 20px;font-family: sans-serif;">
                    
                    
                    <c:if test="${amount == null}">
                        <p>Para realizar un desembolso , digite el monto del desembolso a continuación y seguido presione el botón aceptar</p>
                        <form method="GET" >
                            <input id="amount" name="amount" type="text" style="width: 250px;height: 25px;font-size: 15px;" />  
                            <input id="phone"  name="phone" type="hidden" value="${phone}"/>
                            <input id="btnAccept" style="width: 70px;font-size: 100px;" type="submit" value="Aceptar">
                        </form>
                    </c:if>
                    <c:if test="${amount != null}">
                        <p>El pago al beneficiario se realizó con éxito</p>
                    </c:if>

                </div>   
            </div>
        </div>

    </body>
</html>
