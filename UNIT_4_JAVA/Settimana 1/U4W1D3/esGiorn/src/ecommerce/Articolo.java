package ecommerce;

public class Articolo {
    private String productCode;
    private String description;
    private int price;
    private int stock;

    public Articolo(String productCode, String description, int price, int stock) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void stampaArticolo() {
        System.out.println("Codice prodotto: " + this.productCode);
        System.out.println("Descrizione prodotto: " + this.description);
        System.out.println("Prezzo: €" + this.price);
        System.out.println("Disponibilità in magazzino: " + this.stock);
    }
}


