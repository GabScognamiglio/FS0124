const cardContainer = document.getElementById('cardContainer');
const myKey = 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGNlMjJkN2IxMTAwMTkwZTZlMDQiLCJpYXQiOjE3MDk4OTEyNDEsImV4cCI6MTcxMTEwMDg0MX0.yMGLZ0AUI-8VOiWP4D785JUzrn4_zGLcZxQttST-duc';
const dataURL = "https://striveschool-api.herokuapp.com/api/product/";
prodotti = [];
const spinner = document.getElementById('spinner');

window.addEventListener('load', init);

function init() {
    loadProducts();
    
    
}

async function loadProducts() {
    try {
        let response = await fetch(dataURL, {
            headers: {
                "Authorization": myKey
            }
        })
        data = await response.json();
        prodotti = data;
        console.log(prodotti);
        printProducts();
    }
    catch (error) {
        console.log(error)
    }
}

function printProducts(){
    cardContainer.innerHTML = '';
    for (let i = 0; i < prodotti.length; i++) {
        let div = document.createElement('div');
        div.classList.add('col-lg-3');
        div.classList.add('col-sm-6');
        div.classList.add('col-md-4');
        div.classList.add('mt-4');
        div.innerHTML = `
        <div class="card shadow" >
                        <img src="${prodotti[i].imageUrl}" class="card-img-top img-fluid" alt="...">
                        <div class="card-body">
                          <p class="card-text">${prodotti[i].brand}</p>
                          <h5 class="card-title">${prodotti[i].name}</h5>
                          <p class="card-text">${prodotti[i].description}</p>
                          <p><a href="http://127.0.0.1:5500/back.html?id=${prodotti[i]._id}" class="btn btn-warning">Modifica</a></p>
                          <p><a href="http://127.0.0.1:5500/details.html?id=${prodotti[i]._id}" class="btn btn-secondary">Scopri di più</a></p>
                        </div>
                      </div>`
        cardContainer.appendChild(div);
        
    }
    spinner.style.display='none';
}

