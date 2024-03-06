const bookImage = document.getElementById('bookImage');
const bookTitle = document.getElementById('bookTitle');
const category = document.getElementById('category');
const price = document.getElementById('price');
const cardContainer = document.getElementById('cardContainer')

let books =[];

const loadBooks = async () => {
    const response = await fetch('https://striveschool-api.herokuapp.com/books')
    .then(response => {
        return response.json();
    })
    .then(data =>{
        books = data;
        // console.log(books)
        print();
    })
    .catch(err => {
        cardContainer.innerHTML='<h3 class="text-center">OPS! C\'è qualche poroblema nel caricamento dei libri</h3>'
    })

};

function print() {
    for(let i=0; i<books.length; i++){
        let div = document.createElement('div');
        div.setAttribute('class', 'col-md-6 col-lg-4 col-xl-3');
        div.setAttribute('id', books[i].asin);
        div.innerHTML=`<div class="card mt-3 bg-body-tertiary shadow" >
        <img src="${books[i].img}" class="card-img-top img-fluid" alt="---" id="bookImage">
        <div class="card-body ">
            <h5 class="card-title mb-3" id="bookTitle">${books[i].title}</h5>
            <span class="card-text bg-dark rounded-5 text-white p-1 w-25"><samp id="category">${books[i].category}</samp></span>
            <p class="card-text mt-3" id="price">${books[i].price} €</p>
        </div>
    </div> `
        cardContainer.appendChild(div);
    
    }

};



window.addEventListener('load', init());

function init() {
    loadBooks();
}

