<%-- 
    Document   : mastermindView
    Created on : 03.11.2013, 16:12:29
    Author     : tobi
--%>

<%@page import="java.util.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
    </head>
    <body bgcolor ="#0c1afc">
        <br>
        <center>
        <h1> Mastermind </h1>
        <%
            boolean gewonnen = false;
            boolean verloren = false;
            String text = "";
            if(!gewonnen && !verloren) {  
                out.print("Versuch " + "1" + " von 10:<br>");%>
                <form method="POST" action="SelectNumber.do">
                    <input type=text size="2" name="number1"/>
                    <input type=text size="2" name="number2"/>
                    <input type=text size="2" name="number3"/>
                    <input type=text size="2" name="number4"/>
                    <input type=submit value="Try"/>
                </form>    
        <%
            } 
            if(request.getAttribute("text") != null){
                gewonnen = (Boolean) request.getAttribute("gewonnen");
                verloren = (Boolean) request.getAttribute("verloren");
                text = (String) request.getAttribute("text");
            }
            out.print(text);
            if(gewonnen) {
                out.print("<br><br><h2>Sie haben gewonnen!</h2>");
            }
            else if(verloren) {
                out.print("<br><br><h2>Sie haben verloren!</h2>");
            }
        %>        
    </center>
</html>
