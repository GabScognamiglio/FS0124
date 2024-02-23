const header= document.getElementById('header');
const getStarted=document.getElementById('getStarted');
const listaM = document.querySelectorAll("g[stroke-linecap=butt]");

window.addEventListener('scroll', function() {
    if (window.scrollY > 430) {
      header.style.backgroundColor = 'white';
      getStarted.style.backgroundColor = '#538724';
    } else {
      header.style.backgroundColor = '#ffc017';
      getStarted.style.backgroundColor = '#191919';
    }
  });



function compariScompari() {
  let indiceLettera = Math.floor(Math.random() * listaM.length);
 if (listaM[indiceLettera].style.opacity==='0') {
  listaM[indiceLettera].style.opacity='1'
 }
 else {
  listaM[indiceLettera].style.opacity='0'
 }
}

setInterval(compariScompari, 40); 


