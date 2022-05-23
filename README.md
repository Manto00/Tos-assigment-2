![example workflow](https://github.com/Manto00/Tos-assigment-2/actions/workflows/build.yml/badge.svg)
![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)
# Assignment-elettronica-2
Questa repo è destinata al secondo assignment del corso di metodi e tecnologie per lo sviluppo software

## Annotazioni e convenzioni
Di seguito sono presenti chiarimenti sulle scelte implementative per soddisfare i requisiti

### User
Abbiamo assunto che l'id non ci fosse fornito, ma fosse compito del programma di crearlo, quindi usiamo una variabile statica che viene incrementata con l'invocazione del costruttore.

Siccome alcuni test vanno a valutare l'id e non siamo certi di quale id venga assegnato a runtime, abbiamo implementato una funzione, chiamata setId, che fa il set dell'id per determinare la variabile attesa. Tale funzione viene usata esclusivamente all'interno dei Test.

### Requisito 4
Se vengono ordinati più di 10 mouse e vengono ordinati tanti mouse quante tastiere, il comportamento che ci attendiamo dal programma e che abbiamo implementato è che venga regalato il mouse più economico (per l'omaggio dei 10 mouse) e poi venga regalato il mouse o la tastiera più economica, escludendo il mouse regalato in precedenza.

### Requisiti 5 e 7
Si decide di applicare lo sconto o commissione, a seconda del caso, dopo aver valutato il prezzo modificato dagli sconti
 
### Requisito 8
Innanzitutto, abbiamo dovuto aggiungere alla classe Conto (che implenta l'interfaccia Bill), un campo che indica l'ora in cui è stato fatto, senza tenere conto del giorno, e una flag che indica se esso è in omaggio.
Abbiamo aggiornato la funzione getOrderPrice in modo tale da restituire 0 come prezzo se la flag è attiva.

Abbiamo creato la classe Acquisti che contiene al suo interno una lista di Conti, che rappresenta tutte le ordinazioni fatte in una giornata.

Supponiamo che ci sia un sistema che inserisca gli acquisti effettuati durante la giornata dentro ad Acquisti e ad un certo momento della giornata chiami la funzione per distribuire gli omaggi.

