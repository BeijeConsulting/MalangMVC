<html>
   <head>
      <title>Gestionale Beije</title>
   </head>
   
   <body>
   

  
  <%
  
  Object a = request.getAttribute("utenti");
  out.print("<form action='associa' method='POST'>Utente : <select name='utente'>"+a+"</select><br><br>");          
  
  Object b = request.getAttribute("computer");
  out.print("Computer : <select name='computer'>"+b+"</select><br><br><input type='submit' value='Associa Utente->Computer'></form>");     



%>
${errore} ${successo}
    <hr>
    <center>
    <a href="aggiungiutente"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Crea Nuovo Utente"></a>
    <a href="aggiungicomputer"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Crea Nuovo Computer"></a>
    <a href="associacomputer"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Associa Un Computer a Un Utente"></a></center>
   
   </body>
</html>