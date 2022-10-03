<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib     prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display flight</title>
</head>
<body>
      <h2>display flight</h2>
     <table border="1" width="100%">
     <tr>
        <tr>
          <th>Airlines</th>
          <th>Departure City</th>
          <th>Arrival City</th>
          <th>Departure Time</th>
          <th> Select Flight</th>
        </tr> 
     
    <c:forEach items="${find}" var="find">
         <tr>
         <td>${find.flightNumber}</td> 
         <%--  <td>${find.operatingAirlines}</td>  --%>
          <td>${find.departureCity}</td>
           <td>${find.arrivalCity}</td>
        

         <td>${find.estimatedDepartureTime}</td>
         <td><a href="showCompleteReservation?flightId=${find.id}">Select</a></td>
       </tr>
     </c:forEach>
    </table>
      
</body>
</html>