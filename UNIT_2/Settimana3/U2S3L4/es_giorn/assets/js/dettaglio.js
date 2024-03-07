let myId = localStorage.getItem('foto');
const baseURL = 'https://api.pexels.com/v1/photos/';
const contenitoreFoto = document.getElementById('contenitoreFoto');

window.addEventListener('load', init);

function init(){
    caricaImg();
}

async function caricaImg() {
    try {
        let response = await fetch((baseURL + myId), {
            headers: {
                "Authorization": 'lU4I7mvQkqeXowAR4u6DaRkCmpCh65X3pyW9oWMRXtOiaA0Irvivt8jo'
            }
        })
        immagine = await response.json();
        stampaImg();
        console.log(immagine);

    }
    catch(error){
        console.log('Error:'+ error);

    }
}


function stampaImg() {
    let img = document.createElement('img');
    img.classList.add('img-fluid');
    img.setAttribute('src', immagine.src.original);
    contenitoreFoto.appendChild(img)
};


