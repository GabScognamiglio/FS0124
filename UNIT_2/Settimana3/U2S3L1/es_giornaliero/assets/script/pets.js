const btn = document.getElementById('btn');
const listAnimali = document.getElementById('listaAnimali');
let nome = document.getElementById('nome');
let proprietario = document.getElementById('proprietario');
let specie = document.getElementById('specie');
let razza = document.getElementById('razza');
const errore = document.getElementById('errore');
errore.style.display='none'
let arrayAnimali =[]

class Pets {
    constructor(_petName, _ownerName, _species, _breed) {
        this.petName = _petName;
        this.ownerName = _ownerName;
        this.species = _species;
        this.breed = _breed;
    }

    stessoProprietario(animale2) {
        if(this.ownerName === animale2.ownerName) {
            return true;
        }

        else {
            return false;
        }
    }
}

let cane1= new Pets ('crash', 'gab', 'bo', 'boh')
let cane2= new Pets ('zumbats', 'mario', 'bo', 'boh')

console.log(cane1.stessoProprietario(cane2));

btn.addEventListener('click', function (e) {
    e.preventDefault();
    //se i primi due campi non sono riempiti--> STOP
    if (nome.value=='' || proprietario.value==''){
        errore.style.display='block'
        return;
    }
    else {
        errore.style.display='none'
    };
    //creo un'istanza della classe Pets dandogli i valori dell'input utente e lo pusho nell'array
    let nuovoAnimale = new Pets (nome.value, proprietario.value, specie.value, razza.value)
    arrayAnimali.push(nuovoAnimale);
    console.log(arrayAnimali);
    //creo il list item, lo riempio e lo appendo
    let newLi=document.createElement('li');
    newLi.innerText=`${nuovoAnimale.petName}, di ${nuovoAnimale.ownerName}`
    newLi.setAttribute('class', 'list-group-item my-3')
    listAnimali.appendChild(newLi);
    //svuoto i campi
    nome.value='';
    proprietario.value='';
    specie.value='';
    razza.value='';
})