const timer = document.getElementById('timer');

function iniziaTimer() {
    let start = sessionStorage.getItem('start');  //cerco se esiste un session storage
    if (!start) {
      start = Date.now();
      sessionStorage.setItem('start', start); //se non c'è lo creo
    } 

    setInterval(function() {
      let tempoCorrente = Date.now();
      let tempoPassato = Math.floor((tempoCorrente - start) / 1000);
      timer.innerText = tempoPassato;
    }, 1000);
}

window.onload = iniziaTimer;
  