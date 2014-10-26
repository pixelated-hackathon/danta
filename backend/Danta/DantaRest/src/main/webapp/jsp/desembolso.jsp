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
            <div class="jefeback">

                <div style="width: 600px;z-index: -1;position: absolute;left: 370px;top: 360px;color: white;font-size: 20px;">
                    
                    
                    <c:if test="${amount == null}">
                        <p>Para realizar un desembolso , digite el monto del desembolso a continuación y seguido presione el botón aceptar</p>
                        <form method="GET" >
                            <input id="amount" name="amount" type="text" />  
                            <input id="phone"  name="phone" type="hidden" value="${phone}"/>
                            <input id="btnAccept" type="submit" value="Aceptar">
                        </form>
                    </c:if>
                    <c:if test="${amount != null}">
                        <p>El pago al beneficiario se realizó con éxito</p>
                    </c:if>

                    <a href="<c:url value="/web/ExpedienteDigital/Consulta?phone=${phone}"/>">REGRESAR</a>

                </div>   
            </div>
        </div>

    </body>
</html>
