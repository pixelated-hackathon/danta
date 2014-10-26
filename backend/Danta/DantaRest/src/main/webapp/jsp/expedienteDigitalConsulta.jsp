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
        <title>Expediente Digital - Consulta</title>
        <link href="<c:url value="/resources/main/css/expedienteDigitalConsulta.css" />" rel="stylesheet">
    </head>
    <body>
        <div style="width: 700px;z-index: -1;position: absolute;left: 387px;top: 7PX;color: white;font-size: 20px;letter-spacing: 1px;">PRINCIPAL | CONSULTA </div>
        <div class="rightpane">  
            <div style="margin-top: 125px;margin-left: 5px;">VER EN EXPEDIENTE</div>
            <div style="margin-top: 50px;margin-left: 5px;">HISTORIAL TRANSACCIONAL</div>
            <div style="margin-top: 50px;margin-left: 5px;">ESTADO ACTUAL</div>
            <div style="margin-top: 50px;margin-left: 5px;">REALIZAR PAGO</div>
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
                <img class="jefebackimg" src="<c:url value="/resources/main/source/jefeback.png" />"/>
                <img style="width: 150px;z-index: -1;position: absolute;left: 356px;top: 92px;" src="<c:url value="/resources/main/source/familia.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 500px;top: 109px;color: white;font-size: 15px;line-height: 9px;">
                    <p>${hold.firstName} ${hold.lastName} (JEFE DE FAMILIA)</p>
                    <p>CED. ${hold.idCard}</p>
                    <p>EDAD: ${hold.birthday} AÑOS</p>
                    <p>OCUPACION: ${hold.occupationDescription}</p>
                </div>
                <div style="width: 200px;z-index: -1;position: absolute;left: 370px;top: 259px;color: white;font-size: 20px;">DEPENDIENTES:</div>
            </div>
            
            <div class="memberback">
                <img class="memberbackimg" src="<c:url value="/resources/main/source/memberback.png" />"/>
                <img style="width: 150px;z-index: -1;position: absolute;left: 332px;top: 256px;" src="<c:url value="/resources/main/source/miembro1.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 469px;top: 296px;color: white;font-size: 10px;line-height: 9px;">
                    <p>${members[0].firstName} ${members[0].lastName}</p>
                    <p>CED. ${members[0].idCard}</p>
                    <p>EDAD: ${members[0].birthday} AÑOS</p>
                    <p>OCUPACION: ${members[0].occupationDescription}</p>
                </div>
            </div>
            
            <div class="memberback2">
                <img class="memberback3img" src="<c:url value="/resources/main/source/memberback.png" />"/>
                <img style="width: 130px;z-index: -1;position: absolute;left: 343px;top: 373px;" src="<c:url value="/resources/main/source/miembro2.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 469px;top: 410px;color: white;font-size: 10px;line-height: 9px;">
                    <p>${members[1].firstName} ${members[1].lastName}</p>
                    <p>CED. ${members[1].idCard}</p>
                    <p>EDAD: ${members[1].birthday} AÑOS</p>
                    <p>OCUPACION: ${members[1].occupationDescription}</p>
                </div>
            </div>
            
            <div class="memberback3">
                <img class="memberback3img" src="<c:url value="/resources/main/source/memberback.png" />"/>
                <img style="width: 130px;z-index: -1;position: absolute;left: 347px;top: 485px;" src="<c:url value="/resources/main/source/miembro3.png" />"/>
                <div style="width: 250px;z-index: -1;position: absolute;left: 469px;top: 524px;color: white;font-size: 10px;line-height: 9px;">
                    <p>${members[2].firstName} ${members[2].lastName}</p>
                    <p>CED. ${members[2].idCard}</p>
                    <p>EDAD: ${members[2].birthday} AÑOS</p>
                    <p>OCUPACION: ${members[2].occupationDescription}</p>
                </div>
            </div>
        </div>
        
    </body>
</html>
