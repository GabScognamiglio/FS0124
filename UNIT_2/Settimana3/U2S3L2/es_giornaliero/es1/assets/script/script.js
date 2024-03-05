const nome = document.getElementById('nome');
const btnAdd = document.getElementById('btnAdd');
const btnDelete = document.getElementById('btnDelete');
const infoTesto = document.getElementById('infoTesto');
const errore = document.getElementById('errore');
errore.style.visibility = 'hidden';

window.onload = function () {
    infoTesto.innerText = localStorage.getItem('user')
    if (localStorage.length == 0) {
        infoTesto.innerText = 'No Data'
    }

};

btnAdd.addEventListener('click', function (e) {
    e.preventDefault();
    let user = nome.value;
    if (user !== '') {
        errore.style.visibility = 'hidden';
        localStorage.setItem('user', user);

    }
    else {

        infoTesto.innerText = 'No Data'
        errore.style.visibility = 'visible'
        return;
    }
    infoTesto.innerText = localStorage.getItem('user');
    nome.value = ''
})

btnDelete.addEventListener('click', function () {
    localStorage.clear();
    infoTesto.innerText = 'No Data';
})

