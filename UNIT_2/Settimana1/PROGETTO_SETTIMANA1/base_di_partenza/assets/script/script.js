const header= document.getElementById('header');
const getStarted=document.getElementById('getStarted');

window.addEventListener('scroll', function() {
    if (window.scrollY > 50) {
      header.style.backgroundColor = 'white';
    } else {
      header.style.backgroundColor = '#ffc017';
    }
  });