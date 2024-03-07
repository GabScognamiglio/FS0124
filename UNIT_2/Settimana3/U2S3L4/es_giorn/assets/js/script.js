const baseURL = 'https://api.pexels.com/v1/search?query=';
const apiKey = 'lU4I7mvQkqeXowAR4u6DaRkCmpCh65X3pyW9oWMRXtOiaA0Irvivt8jo'
const contenitore = document.getElementById('contenitore');
const load1 = document.getElementById('load1');
const load2 = document.getElementById('load2');
let immagini = []
const searchText = document.getElementById('searchText');
const btnSearch = document.getElementById('btnSearch');


//pulsante Load Images
async function loadImages1() {
    try {
        let response = await fetch((baseURL + 'mountains'), {
            headers: {
                "Authorization": 'lU4I7mvQkqeXowAR4u6DaRkCmpCh65X3pyW9oWMRXtOiaA0Irvivt8jo'
            }
        })
        immagini = await response.json();
        stampa();
        console.log(immagini.photos);

    }
    catch (error) {
        console.log('Error:' + error);

    }
};

//pulsante Load Secondary Images
async function loadImages2() {
    try {
        let response = await fetch((baseURL + 'sunsets'), {
            headers: {
                "Authorization": 'lU4I7mvQkqeXowAR4u6DaRkCmpCh65X3pyW9oWMRXtOiaA0Irvivt8jo'
            }
        })
        immagini = await response.json();
        stampa();
        console.log(immagini.photos);

    }
    catch (error) {
        console.log('Error:', error);

    }
}

//pulsante Search
async function loadSearch() {
    try {
        let response = await fetch((baseURL + searchText.value), {
            headers: {
                "Authorization": 'lU4I7mvQkqeXowAR4u6DaRkCmpCh65X3pyW9oWMRXtOiaA0Irvivt8jo'
            }
        })
        immagini = await response.json();
        stampa();
        console.log(immagini.photos);

    }
    catch (error) {
        console.log('Error:', error);

    }
}



function stampa() {
    contenitore.innerHTML = ''
    for (let i = 0; i < immagini.photos.length; i++) {
        let div = document.createElement('div');
        div.classList.add('col-md-4');
        div.innerHTML = `
        <div class="card mb-4 shadow-sm" id="card${immagini.photos[i].id}">
              <img src="${immagini.photos[i].src.original}" class="bd-placeholder-img card-img-top" />
              <div class="card-body">
                <h5 class="card-title"><a href="#" id="dettaglioImg" onclick="dettaglioImg(${immagini.photos[i].id})">Visualizza Immagine</a></h5>
                <p class="card-text">
                  This is a wider card with supporting text below as a natural
                  lead-in to additional content. This content is a little bit
                  longer.
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#id${immagini.photos[i].id}">
                      View
                    </button>
                    <button type="button" class="btn btn-sm btn-outline-secondary" onclick="hide(card${immagini.photos[i].id})">
                      Hide
                    </button>
                    <div class="modal fade" id="id${immagini.photos[i].id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                            <img src="${immagini.photos[i].src.original}" class="img-fluid">
                            </div>
                            </div>
                        </div>
                        </div>
                  </div>
                  <small class="text-muted">${immagini.photos[i].id}</small>
                </div>
              </div>
            </div>
        `
        contenitore.appendChild(div);
    }
}

function dettaglioImg(id) {

    localStorage.setItem('foto', id);
    location.href = 'dettagli.html'
}


// da errore dicendo che card è null!!!

// function hide(id) {
//     let card = document.getElementById(id);
//     card.style.display = 'none';
// }

