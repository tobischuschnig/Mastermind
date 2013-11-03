<%-- 
    Document   : MastermindView
    Created on : 03.11.2013, 16:12:29
    Author     : tobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
    </head>
    <body bgcolor ="#0c1afc">
        <h1>Mastermind</h1>
        <%
            boolean gewonnen = false;
            boolean verloren = false;
            String text = "";
            if(!gewonnen && !verloren) {   %>
                <form method="POST" action="SelectNumber.do">
                    <input type=text size="2" name="number1"/>
                    <input type=text size="2" name="number2"/>
                    <input type=text size="2" name="number3"/>
                    <input type=text size="2" name="number4"/>
                    <input type=submit value="Try"/>
                </form>    
          <%} 
            out.print(text);
            if(gewonnen) {
                out.print("<br><br><h2>Sie haben gewonnen!</h2>");
            }
            else if(verloren) {
                out.print("<br><br><h2>Sie haben verloren!</h2>");
            }
                
    </body>
</html>
