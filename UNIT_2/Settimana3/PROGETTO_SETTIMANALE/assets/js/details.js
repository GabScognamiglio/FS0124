const cardContainer = document.getElementById('cardContainer');
const myKey = 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGNlMjJkN2IxMTAwMTkwZTZlMDQiLCJpYXQiOjE3MDk4OTEyNDEsImV4cCI6MTcxMTEwMDg0MX0.yMGLZ0AUI-8VOiWP4D785JUzrn4_zGLcZxQttST-duc';
const dataURL = "https://striveschool-api.herokuapp.com/api/product/";
const productImg = document.getElementById('productImg');
const productDetails = document.getElementById('productDetails');



const params = new URLSearchParams(location.search)
const id = params.get('id')


window.addEventListener('load', init);

function init() {
    loadDetails();
    console.log(id)
}

async function loadDetails() {
    try {
        let response = await fetch((dataURL + id), {
            headers: {
                "Authorization": myKey
            }
        })
        data = await response.json();
        prodotto = data;
        console.log(prodotto);
        printDetails();
    }
    catch (error) {
        console.log(error)
    }
}

function printDetails() {
    let img = document.createElement('img');
    img.classList.add('img-fluid');
    img.setAttribute('src', prodotto.imageUrl);
    productImg.appendChild(img);

    productDetails.innerHTML=`
                    <p>${prodotto.brand}</p>
                    <h3 class="fs-2 my-3">${prodotto.name}</h3>
                    <p><span><samp class="badge bg-dark text-warning fs-6">${prodotto.price}€</samp></span></p>
                    <p>${prodotto.description}</p>`

}