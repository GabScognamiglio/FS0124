# Todo

## Note per il prof

### L'unico known-bug è:
- ~ quando viene creato un nuovo To Do nell'apposita sezione, esso è correttamente visualizzato nei tasks, si può cambiare il suo stato (completed: true/false), ma non risulta assegnato all'utente selezionato nella select, anche se il todo risulta con l'userId scelto, forse perchè json-server produce di base un ID che non è solo numerico come gli altri (es: "8ee6"). ~ 
### BUG RISOLTO 
 trasfromando userId che arriva al nuovo oggetto in numero (Number(nuovoTodo.userId), vedi new-task.component.ts, riga 39), tutto funziona correttamente

#### Bug minore:
- nei component "Completed" e "incompleted" quando cambi lo stato di un task (completed:false/true) esso cambia colore, viene fatta la PATCH correttamente, ma risulterà nell'altro component solo al refresh, o al cambio vista.

### Possibili implementazioni future:

-Aggiungere una sezione/funzione per poter cancellare definitivamente le task, effettuando una chiamata http DELETE

### Author:

Gabriele Scognamiglio

