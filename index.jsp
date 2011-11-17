<%-- 
    Document   : index
    Created on : 6 Νοε 2011, 2:30:30 μμ
    Author     : Aristeidis Lianas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <title>
	    Currency converter
	  </title>
	  </head>
      <body>
          
          <div id=sign_up style= " height:100%; width:100%; margin-left:auto; margin-right:auto; position:absolute; top:0%; right:0%; background:cornflowerblue;">
                <form name="LoginForm" action="isotimiaservlet" method="get" style= " width:70%; height:50%; top:15%; position:fixed; top:15%; left:15%; background-color:cyan; " >
                  
                  
                    <center> <h1> Exchange rates </h1> </center> <br/>
                    <center> <h2>Daily Updated by the European Central Bank</h2> </center> <br/>
                    <center> <p> Επιμέλεια: Αριστείδης Λιάνας</p> </center>
                        <br/><br/><br/>
                        
                  
                  &nbsp; Currency 1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
                  <select name="Currency1">
                    <option value="EURO">EURO</option>
                    <option value="AUD">AUD</option>  
                    <option value="RUB">RUB</option>
                    <option value="JPY">JPY</option>
                    <option value="USD">USD</option>
                    <option value="NOK">NOK</option>
                    <option value="NZD">NZD</option>
                    <option value="TRY">TRY</option>
                    <option value="BRL">BRL</option>
                  </select>
                  <br/>
                     
                  &nbsp; Currency 2 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
                  <select name="Currency2">
                    <option value="EURO">EURO</option>
                    <option value="AUD">AUD</option>  
                    <option value="RUB">RUB</option>
                    <option value="JPY">JPY</option>
                    <option value="USD">USD</option>
                    <option value="NOK">NOK</option>
                    <option value="NZD">NZD</option>
                    <option value="TRY">TRY</option>
                    <option value="BRL">BRL</option>
                  </select>
                  <br/>
                  
                  &nbsp; Amount To Calculate &nbsp:<input type="text" name="amount" value="" /><br>
                  
                  &nbsp; Result (From 1 to 2) &nbsp&nbsp: <%= request.getParameter("answer")%> <br>
                                    
                  &nbsp; <input type="Submit" value="Exchange" onclick="isotimiaservlet" />
                  
                  </form>
                  </div>
                  <form name="reportform" action="report" method="get" style= " width:70%; height:50%; top:15%; position:relative; top:15%; left:15%; background-color:cyan; " >
                  &nbsp; <input type="Submit" value="Report" onclick="report" />
                  </form>
                  <form name="srcform" action="Source" method="get" style= " width:70%; height:50%; top:15%; position:relative; top:15%; left:15%; background-color:cyan; " >
                  &nbsp; <input type="Submit" value="Source" onclick="Source" />
                  </form>
      </body>
</html>
