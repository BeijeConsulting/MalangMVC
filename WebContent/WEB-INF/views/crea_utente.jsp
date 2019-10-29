<html>
   <head>
      <title>Crea Utente</title>
   </head>
   
   <body>
   <form action="aggiungiutente" method="POST">
   <input type="text" name="nome" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Nome..."><br>
   <input type="text" name="cognome" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Cognome..."><br>
   <input type="text" name="email" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Email..."><br>
   <input type="submit" name="invio" style="margin:5px;padding:5px; border-radius:5px; border:1px solid red;" value="Crea Utente!">
   </form>
   ${errore} ${successo}
   
   
   <hr>
   <center>
    <a href="aggiungiutente"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Crea Nuovo Utente"></a>
    <a href="aggiungicomputer"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Crea Nuovo Computer"></a>
    <a href="associacomputer"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Associa Un Computer a Un Utente"></a></center>

   </body>
</html>