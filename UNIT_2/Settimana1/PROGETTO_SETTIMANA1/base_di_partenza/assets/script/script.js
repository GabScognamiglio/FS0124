const header= document.getElementById('header');
const getStarted=document.getElementById('getStarted');

window.addEventListener('scroll', function() {
    if (window.scrollY > 450) {
      header.style.backgroundColor = 'white';
      getStarted.style.backgroundColor = '#538724';
    } else {
      header.style.backgroundColor = '#ffc017';
      getStarted.style.backgroundColor = '#191919';
    }
  });