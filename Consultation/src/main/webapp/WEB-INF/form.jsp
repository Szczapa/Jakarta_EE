<%@ page import="org.example.consultation.entity.Doctor" %><%--


  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 16/07/2024
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="doctorList" type="java.util.ArrayList<org.example.consultation.entity.Doctor>" scope="request"/>
<jsp:useBean id="mode" type="java.lang.String" scope="request"/>
<jsp:useBean id="patient" type="org.example.consultation.entity.Patient" scope="request"/>
<html>
<head>
    <title>Gestion Patient</title>
    <%@include file="import.html" %>
</head>
<body>
<%@include file="header.jsp" %>
<% if (mode.equals("DETAIL")) {%>
<div class="container">
    <img> src="<%=patient.getImgName()%>" alt="<%=patient.getImgName()%>" class="img-fluid"> </>
</div>
<%}%>
<form method="post"
      action="<%= mode.equals("EDIT") ? "edit?id=" + patient.getPatientId() : mode.toLowerCase() %>"
      class="container">
    <div class="form-group mb-3">
        <label for="firstName">Nom</label>
        <input type="text" class="form-control" id="firstName" name="firstName"
               placeholder="Prenom" <% if(!mode.equals("ADD")){%> value="<%=patient.getFirstName()%>"<%}%>
            <% if (mode.equals("DETAIL")) {%> disabled <%}%>
        >
    </div>
    <div class="form-group mb-3">

        <label for="lastName">Nom</label>
        <input type="text" class="form-control" id="lastName" name="lastName"
               placeholder="nom" <% if(!mode.equals("ADD")){%> value="<%=patient.getLastName()%>"<%}%>
            <% if(mode.equals("DETAIL")){%> readonly <%}%>
        >
    </div>


    <div class="form-group mb-3">
        <label for="birthDate">Date de naissance</label>
        <input type="date" class="form-control" id="birthDate" name="birthDate"
               placeholder="Date de naissance" <% if(!mode.equals("ADD")){%>
               value="<%=patient.getBirthDate()%>"<%}%>
            <% if(mode.equals("DETAIL")){%> readonly <%}%>
        >

    </div>

    <div class="form-group mb-3">
        <label for="doctorId">Liste des médecins</label>
        <select id="doctorId" name="doctorId" class="form-select" <% if (mode.equals("DETAIL")) {%> disabled <%}%>>
            <% if (!mode.equals("ADD")) {%>
            <option value="<%=patient.getDoctor().getDoctorId()%>"><%= patient.getDoctor().getLastName() %> <%}%>
            </option>
            <% for (int i = 0; i < doctorList.size(); i++) { %>
            <option value="<%= doctorList.get(i).getDoctorId() %>"><%= doctorList.get(i).getLastName() %>
            </option>
            <% } %>
        </select>
    </div>

    <% if (!mode.equals("DETAIL")) {%>
    <div class="form-groupe mb-3">
        <input type="file" name="image" <% if (mode.equals("EDIT")) {%>value="<%=patient.getImgName()%><%}%>">
    </div>
    <%}%>

    <% if (!mode.equals("DETAIL")) {%>
    <div class="form-group mb-3">
        <button type="submit" class="btn btn-dark">Envoyer</button>
    </div>
    <%}%>
</form>
<%@include file="footer.jsp" %>
</body>
</html>
