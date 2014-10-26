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
        <div class="rightpane" style="font-family: Roboto">
            <div style="margin-top: 125px;margin-left: 5px;"></div>
            <div style="margin-top: 50px;margin-left: 30px;"><a href="../ExpedienteDigital/HistorialTransacciones?phone=87040233">Historial transaccional</a></div>
            <div style="margin-top: 50px;margin-left: 75px;"><a href="../ExpedienteDigital/SaludFinanciera?phone=87040233">Salud financiera</a></div>
            <div style="margin-top: 50px;margin-left: 100px;"><a href="../ExpedienteDigital/Desembolso?phone=87040233">Desembolso</a></div>
            <div style="margin-left: 15px;margin-top: 100px;">
                <img style="width: 100px;" src="<c:url value="/resources/main/source/logo.png" />"/>
            </div>
            <div style="margin-left: 50px;margin-top: 10px;width: 50px;">
                <img style="width: 50px;" src="<c:url value="/resources/main/source/back.png" />"/>
            </div>
            <div style="width: 10px;z-index: 1;position: absolute;left: 976px;top: 525px;"><a href="../ExpedienteDigital/Consulta?phone=87040233">Volver</a></div>
        </div>  
        
        <div class="content">
            <div style="width: 250px;z-index: -1;position: absolute;left: 370px;top: 56px;color: white;font-size: 35px;font-family: Roboto">Familia ${family.familyLastName}</div>
            <div class="jefeback">
                <img class="jefebackimg" src="<c:url value="/resources/main/source/jefeback.png" />"/>
                <img style="width: 150px;z-index: -1;position: absolute;left: 356px;top: 92px;" src="<c:url value="/resources/main/source/familia.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 500px;top: 109px;color: white;font-size: 15px;line-height: 9px;">
                    <p>${hold.firstName} ${hold.lastName} (Jefe de familia)</p>
                    <p>Ced. ${hold.idCard}</p>
                    <p>Nacimiento: <fmt:formatDate value="${hold.birthday}" pattern="dd-MM-yyyy"/></p>
                    <p>Ocupacion: ${hold.occupationDescription}</p>
                </div>
                <div style="width: 200px;z-index: -1;position: absolute;left: 370px;top: 259px;color: white;font-size: 20px;font-family: sans-serif;">Dependientes</div>
            </div>
            
            <div class="memberback">
                <img class="memberbackimg" src="<c:url value="/resources/main/source/memberback.png" />"/>
                <img style="width: 150px;z-index: -1;position: absolute;left: 332px;top: 256px;" src="<c:url value="/resources/main/source/miembro1.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 469px;top: 296px;color: white;font-size: 10px;line-height: 9px;">
                    <p>${members[0].firstName} ${members[0].lastName}</p>
                    <p>Ced. ${members[0].idCard}</p>
                    <p>Nacimiento: <fmt:formatDate value="${members[0].birthday}" pattern="dd-MM-yyyy"/></p>
                    <p>Ocupacion ${members[0].occupationDescription}</p>
                </div>
            </div>
            
            <div class="memberback2">
                <img class="memberback3img" src="<c:url value="/resources/main/source/memberback.png" />"/>
                <img style="width: 130px;z-index: -1;position: absolute;left: 343px;top: 373px;" src="<c:url value="/resources/main/source/miembro2.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 469px;top: 410px;color: white;font-size: 10px;line-height: 9px;">
                    <p>${members[1].firstName} ${members[1].lastName}</p>
                    <p>Ced. ${members[1].idCard}</p>
                    <p>Nacimiento: <fmt:formatDate value="${members[1].birthday}" pattern="dd-MM-yyyy"/></p>
                    <p>Ocupacion: ${members[1].occupationDescription}</p>
                </div>
            </div>
            
            <div class="memberback3">
                <img class="memberback3img" src="<c:url value="/resources/main/source/memberback.png" />"/>
                <img style="width: 130px;z-index: -1;position: absolute;left: 347px;top: 485px;" src="<c:url value="/resources/main/source/miembro3.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 469px;top: 524px;color: white;font-size: 10px;line-height: 9px;">
                    <p>${members[2].firstName} ${members[2].lastName}</p>
                    <p>CED. ${members[2].idCard}</p>
                    <p>NACIMIENTO <fmt:formatDate value="${members[2].birthday}" pattern="dd-MM-yyyy"/></p>
                    <p>OCUPACION: ${members[2].occupationDescription}</p>
                </div>
            </div>
        </div>
        
    </body>
</html>
