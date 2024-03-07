const baseURL = 'https://api.pexels.com/v1/search?query=';
const apiKey = 'lU4I7mvQkqeXowAR4u6DaRkCmpCh65X3pyW9oWMRXtOiaA0Irvivt8jo'
const contenitore = document.getElementById('contenitore');
const load1 = document.getElementById('load1');
const load2 = document.getElementById('load2');

const searchText = document.getElementById('searchText');
const btnSearch = document.getElementById('btnSearch');

// load1.addEventListener('click', loadImages1());


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
    catch(error){
        console.log('Error:'+ error);

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
    catch(error){
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
    catch(error){
        console.log('Error:', error);

    }
}



function stampa() {
    contenitore.innerHTML=''
    for (let i=0; i<immagini.photos.length; i++) {
        let div = document.createElement('div');
        div.classList.add('col-md-4');
        div.innerHTML= `
        <div class="card mb-4 shadow-sm">
              <img src="${immagini.photos[i].src.original}" class="bd-placeholder-img card-img-top" />
              <div class="card-body">
                <h5 class="card-title"><a href="#dettagli.html" id="dettaglioImg">Visualizza Immagine</a></h5>
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
                    <button type="button" class="btn btn-sm btn-outline-secondary">
                      Edit
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




// {
//     "id": 1374064,
//     "width": 3024,
//     "height": 4032,
//     "url": "https://www.pexels.com/photo/woman-standing-on-the-cliff-1374064/",
//     "photographer": "julie aagaard",
//     "photographer_url": "https://www.pexels.com/@julieaagaard",
//     "photographer_id": 590997,
//     "avg_color": "#7F8074",
//     "src": {
//         "original": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg",
//         "large2x": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
//         "large": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
//         "medium": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&h=350",
//         "small": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&h=130",
//         "portrait": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=1200&w=800",
//         "landscape": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=627&w=1200",
//         "tiny": "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
//     },
//     "liked": false,
//     "alt": "Woman Standing on the Cliff"
// }