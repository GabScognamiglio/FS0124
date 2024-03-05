const nome = document.getElementById('nome');
const btnAdd = document.getElementById('btnAdd');
const btnDelete = document.getElementById('btnDelete');
const infoTesto = document.getElementById('infoTesto');

window.onload = function() {
    infoTesto.innerText = localStorage.getItem('user')
    if (localStorage.length==0){
        infoTesto.innerText='No Data'
    }

};

btnAdd.addEventListener('click', function () {
    let user = nome.value;
    if (user !== '') {
        localStorage.setItem('user', user);
       
    }
    else {
        return;
    }
    infoTesto.innerText = localStorage.getItem('user');
})

btnDelete.addEventListener('click', function(){
    localStorage.clear();
    infoTesto.innerText='No Data';
})

