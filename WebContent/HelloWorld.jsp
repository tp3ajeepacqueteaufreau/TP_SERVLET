<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<select name="list" >
		<!-- Methode William -->
		<option<%if("France".equals(request.getParameter("list"))){out.print(" selected");}%>>France</option>
		
		
		<!-- Methode Sebastien -->
		<%		
		out.print("<option");
		if("Pologone".equals(request.getParameter("list"))){
			out.print(" selected");
		}
		out.println(">Pologone</option>");
		
		out.print("<option");
		if("Allemagne".equals(request.getParameter("list"))){
			out.print(" selected");
		}
		out.println(">Allemagne</option>");
		
		%>
		</select>
		<input type="submit" value="Valider !">
	</form>
	<br />
	<br />
	<br />
	<br />
	<%
		if(request.getParameter("list")!= null){
			out.print("Nombre de Gillet Jaune : ");
			int tmp = (new Random()).nextInt();
			out.println(String.valueOf((tmp<0)?tmp*(-1):tmp));
		}
	%>
	
</body>
</html>