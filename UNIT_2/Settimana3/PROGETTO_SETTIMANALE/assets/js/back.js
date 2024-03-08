const titolo = document.getElementById('titolo');
const save = document.getElementById('save');
const elimina = document.getElementById('elimina');
const nome = document.getElementById('nome');
const marca = document.getElementById('brand');
const prezzo = document.getElementById('prezzo');
const url = document.getElementById('url');
const descrizione = document.getElementById('descrizione');
const myKey = 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGNlMjJkN2IxMTAwMTkwZTZlMDQiLCJpYXQiOjE3MDk4OTEyNDEsImV4cCI6MTcxMTEwMDg0MX0.yMGLZ0AUI-8VOiWP4D785JUzrn4_zGLcZxQttST-duc';
const dataURL = "https://striveschool-api.herokuapp.com/api/product/";
const messaggio= document.getElementById('messaggio');
const params = new URLSearchParams(location.search)
const id = params.get('id')

console.log(id) //se null compare pagina di aggiunta, se true compare pagina di modifica

window.addEventListener('load', init);

function init() {
    if (id) {
        caricaProdotto();
    }
    else {
        caricaPagina();
    }
};

function goHome(){
    location.href='index.html'
}


async function caricaProdotto() {
    try {
        let response = await fetch((dataURL + id), {
            headers: {
                "Authorization": myKey
            }
        })
        data = await response.json();
        prodotto = data;
        console.log(prodotto);
        stampaProdotto();
    }
    catch (error) {
        console.log(error)
    }
}

function stampaProdotto() {
    titolo.innerText = 'Edit product';
    nome.value = prodotto.name;
    marca.value = prodotto.brand;
    prezzo.value = prodotto.price;
    url.value = prodotto.imageUrl;
    descrizione.value = prodotto.description;
}

function caricaPagina() {
    titolo.innerText = 'Add product'
    elimina.style.display = 'none'
}

save.addEventListener('click', postPut)

function postPut(){
    if (id){
        put();
    }
    else {
       post();
    }
}

async function post() {
    
    // if(nome.value==''|| marca.value=='' || prezzo.value=='' || url.value=='' || description.value==''){
    //     messaggio.innerText='Riempire tutti i campi!'
    // }
    messaggio.innerHTML=`Record Aggiunto! Verrai reindirizzato alla Home &nbsp; <div id="spinner" class="spinner-border text-primary" role="status">
    <span class="visually-hidden">Loading...</span>
</div>`;;

    const name = nome.value;
    const brand = marca.value;
    const price = parseInt(prezzo.value);
    const imageUrl = url.value;
    const description = descrizione.value;

    const nuovoOggetto = {name, brand, price, imageUrl, description};

    console.log(nuovoOggetto);  //esiste
    try {
        let nuovoRecord = await fetch(dataURL, {
            method: "POST",
            body: JSON.stringify(nuovoOggetto),
            headers: {
                "Authorization": myKey,
                "Content-Type": "application/json"
            }
        })

        console.log(prezzo.value)
        recordCreato = await nuovoRecord.json()
        console.log(recordCreato);
        setTimeout(() => {
            goHome();
          }, "2800");
    }
    catch (error) {
        console.log(error)
    }

}


async function put(){
    messaggio.innerHTML=`Record Modificato! Verrai reindirizzato alla Home &nbsp; <div id="spinner" class="spinner-border text-primary" role="status">
    <span class="visually-hidden">Loading...</span>
</div>`;;
    const name = nome.value;
    const brand = marca.value;
    const price = parseInt(prezzo.value);
    const imageUrl = url.value;
    const description = descrizione.value;

    const nuovoOggetto = {name, brand, price, imageUrl, description};

    console.log(nuovoOggetto);  //esiste

    try {
        let nuovoRecord = await fetch((dataURL+id), {
            method: "PUT",
            body: JSON.stringify(nuovoOggetto),
            headers: {
                "Authorization": myKey,
                "Content-Type": "application/json"
            }
        })
        recordCreato = await nuovoRecord.json()
        console.log(recordCreato);
        setTimeout(() => {
            goHome();
          }, "2800");

    }
    catch (error) {
        console.log(error)
    }
}


elimina.addEventListener('click', deleteRecord);

async function deleteRecord(){
    messaggio.innerHTML=`Record Eliminato! Verrai reindirizzato alla Home &nbsp; <div id="spinner" class="spinner-border text-primary" role="status">
    <span class="visually-hidden">Loading...</span>
</div>`;
    
    try {
        let cancellatoRecord = await fetch((dataURL+id), {
            method: "DELETE",
            headers: {
                "Authorization": myKey,
                "Content-Type": "application/json"
            }
        
        })
        setTimeout(() => {
            goHome();
          }, "2800");
    }
    catch (error) {
        console.log(error)
    };
    
}
