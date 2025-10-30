function product(name, price, category) {
    this.name = name;
    this.price = price;
    this.category = category;
}

var product1 = new product("Laptop", 50000, "Electronics");
var product2 = new product("Bottle", 200, "Kitchen");
var product3 = new product("Shirt", 2500, "Clothing");
var product4 = new product("Monitor", 20000, "Electronics");

var products = [product1, product2, product3, product4];

product.prototype.getDiscountedPrice = function(discountPercent) {
    var discount = (this.price * discountPercent) / 100;
    return this.price - discount;
};

console.log(product1.getDiscountedPrice(10));
console.log(product2.getDiscountedPrice(20));

// Using IIFE which waits for the DOM to be ready
(function () {
    document.addEventListener('DOMContentLoaded', function () {
        var app = document.getElementById('app');
        if (!app) {
            console.warn('No element with id="app" found.');
            return;
        }

        // Find costliest product using call()
        function getPrice() {
            return this.price;
        }

        var costliest = products[0];
        for (var i = 1; i < products.length; i++) {
            var currentPrice = getPrice.call(products[i]);
            var costliestPrice = getPrice.call(costliest);
            if (currentPrice > costliestPrice) {
                costliest = products[i];
            }
        }

        var info = document.createElement('h2');
        info.className = 'costliest-info';
        info.textContent = 'Price of costliest product is ' + costliest.price + ' (' + costliest.name + ')';
        app.insertBefore(info, app.firstChild);

        // Create product cards dynamically
        for (var i = 0; i < products.length; i++) {
            var p = products[i];

            var card = document.createElement('div');
            card.className = 'product-card';

            var nameEl = document.createElement('h3');
            nameEl.textContent = p.name;

            var priceEl = document.createElement('p');
            priceEl.textContent = 'Price: ' + p.price;

            var categoryEl = document.createElement('p');
            categoryEl.textContent = 'Category: ' + p.category;

            card.appendChild(nameEl);
            card.appendChild(priceEl);
            card.appendChild(categoryEl);

            // Highlight when mouse enters
            card.addEventListener('mouseenter', function () {
                this.style.backgroundColor = '#3095eeff';
                this.style.boxShadow = '0 0 10px rgba(0, 0, 0, 0.3)';
            });

            // Remove highlight when mouse leaves
            card.addEventListener('mouseleave', function () {
                this.style.backgroundColor = '';
                this.style.boxShadow = '';
            });

            app.appendChild(card);
        }
    });
})();