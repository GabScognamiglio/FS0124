//variabili global
const input = document.getElementById('input')
const button = document.getElementById('button')
const lista = document.getElementById('lista')
const valid = false


//controllo input valido

function disabilita() {
    button.setAttribute('disabled', 'true')
}

disabilita()

input.addEventListener('blur', function (e) {
    e.preventDefault();
    if (input.value !== '') {
        button.removeAttribute('disabled')
    }
    else {
        disabilita();
    }
})







//cosa succede al click del bottone
button.addEventListener('click', function (e) {
    e.preventDefault();

    let taskLista = document.createElement('li');
    taskLista.innerHTML = input.value + `<button class="elimina"><span class="material-symbols-outlined">
    delete
    </span></button>`;
    lista.appendChild(taskLista);
    input.value = '';
    taskLista.onclick = function () {
        this.classList.toggle('clicked')
    };

}
)

//eliminare un task creato
const elimina = document.getElementsByClassName('elimina')
for (i = 0; i < elimina.length; i++) {
    elimina[i].onclick= function(){
        taskLista.removeChild(li)
    }}
        
 