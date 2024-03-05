const timer = document.getElementById('timer');
const messaggio = document.getElementById('messaggio');
messaggio.style.visibility='hidden';
window.onload = iniziaTimer;

function iniziaTimer() {
    let start = sessionStorage.getItem('start');  //cerco se esiste un session storage
    if (!start) {
        start = Date.now();  // al caricamento della pagina definisce in millisecondi il tempo trascorso dalle 00:00 del 1/1/1970
        sessionStorage.setItem('start', start); //se non c'è lo creo
    };

    setInterval(function () {
        let tempoAttuale = Date.now();
        let tempoTrascorso = Math.floor((tempoAttuale - start) / 1000);
        timer.innerHTML = `${tempoTrascorso} <span class="display-6 text-warning">secondi</span>`;
        if (tempoTrascorso>8) {
            messaggio.style.visibility='visible';
        }
    }, 1000);  //ogni secondo converte il tempo trascorso (tempo attuale-tempo di inizio) da millisecondi in secondi. Guarda giù

};

// più nello specifico, ogni secondo ottengo il tempo trascorso dalle 00:00 del 1/1/1970, al quale sottraggo la variabile start (il cui valore è lo stesso ma definito al momento del caricamento della pagina). Dividendo il tutto per 1000, ottengo la differenza in real time in secondi, ogni secondo, quindi un timer (o meglio ancora cronometro).