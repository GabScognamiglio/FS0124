# Todo

## Note per il prof

L'unico known-bug è:
- ~ quando viene creato un nuovo To Do nell'apposita sezione, esso è correttamente visualizzato nei tasks, si può cambiare il suo stato (completed: true/false), ma non risulta assegnato all'utente selezionato nella select, anche se il todo risulta con l'userId scelto, forse perchè json-server produce di base un ID che non è solo numerico come gli altri (es: "8ee6"). ~

Bug minore:
- nei component "Completed" e "incompleted" quando cambi lo stato di un task (completed:false/true) esso cambia colore, viene fatta la PATCH correttamente, ma risulterà nell'altro component solo al refresh, o al cambio vista.

### Author

-Gabriele Scognamiglio

