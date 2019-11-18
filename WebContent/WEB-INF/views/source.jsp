<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// pageContext.setAttribute("name", "page");
// request.setAttribute("name", "req");
RequestDispatcher rd = request.getRequestDispatcher("/target");

// String name = (String)pageContext.getAttribute("name");
// out.println(name);

// 왜 error 나지.....
// System.out.println("source : " + request.getRequestedSessionID());

rd.forward(request, response);
%>

<%-- <c:set var="name" value="page" /> --%>
<%-- <c:set var="name" value="request" scope="request" /> --%>
<%-- <c:set var="name" value="session" scope="session"/> --%>
<%-- <c:set var="name" value="app" scope="application"/> --%>