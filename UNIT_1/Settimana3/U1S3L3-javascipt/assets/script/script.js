//variabili global
const input = document.getElementById('input')
const button = document.getElementById('button')
const lista = document.getElementById('lista')
const valid = false


//cosa succede al click del bottone
button.addEventListener('click', function (e) {
    e.preventDefault();

    let taskLista = document.createElement('li');
    taskLista.innerHTML = input.value + `<button class="elimina"><span class="material-symbols-outlined">
    delete
    </span></button>`;
    lista.appendChild(taskLista);
    //input.value = '';
    taskLista.onclick = function () {
        this.classList.toggle('clicked')
    };

}
)

//eliminare un task creato

 