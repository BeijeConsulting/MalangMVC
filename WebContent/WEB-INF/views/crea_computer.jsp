<html>
   <head>
      <title>Gestionale Beije</title>
   </head>
   
   <body>
   
      <body>
   <form action="aggiungicomputer" method="POST">
   <input type="text" name="modello" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Modello"><br>
   <input type="text" name="marca" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Marca"><br>
   <input type="text" name="cpu" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="CPU"><br>
   <input type="text" name="ram" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="RAM"><br>
   <input type="text" name="hd" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="HD"><br>
   <input type="text" name="sn" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Serial Number"><br>
   <input type="text" name="note" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Note"><br>
   <input type="text" name="so" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" placeholder="Sistema Operativo"><br>
   
   
   <input type="submit" name="invio" style="margin:5px;padding:5px; border-radius:5px; border:1px solid red;" value="Crea Computer!">
   </form>
   ${errore} ${successo}
   
   
    <hr>
    <center>
    <a href="aggiungiutente"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Crea Nuovo Utente"></a>
    <a href="aggiungicomputer"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Crea Nuovo Computer"></a>
    <a href="associacomputer"><input type="button" style="margin:5px;padding:5px; border-radius:5px; border:1px solid black;" value="Associa Un Computer a Un Utente"></a></center>
   
    </body>
</html>