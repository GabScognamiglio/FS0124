const btn = document.getElementById('btn');
const listAnimali = document.getElementById('listaAnimali');


let nome = document.getElementById('nome');
let proprietario = document.getElementById('proprietario');
let specie = document.getElementById('specie');
let razza = document.getElementById('razza');

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
    // e.preventDefault();

    if (nome.value=='' || proprietario.value==''){
        return;
    };

    let nuovoAnimale = new Pets (nome.value, proprietario.value, specie.value, razza.value)
    arrayAnimali.push(nuovoAnimale);
    console.log(arrayAnimali);

    let newLi=document.createElement('li');
    newLi.innerText=`${nuovoAnimale.petName}, di ${nuovoAnimale.ownerName}`
    newLi.setAttribute('class', 'list-group-item')
    listAnimali.appendChild(newLi);

    nome.value='';
    proprietario.value='';
    specie.value='';
    razza.value='';
})