import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Il vero esercizio inizia intorno a riga 100, prima è solo preparazione

        Product p1 = new Product(1, "The Magic Book", "Books", 10.99);
        Product p2 = new Product(2, "Adventure Chronicles", "Books", 15.99);
        Product p3 = new Product(3, "Enchanted Tales", "Books", 200.49);
        Product p4 = new Product(4, "Superhero Action Figure", "Boys", 8.99);
        Product p5 = new Product(5, "Galactic Laser Gun", "Boys", 12.49);
        Product p6 = new Product(6, "Mystical Wand", "Boys", 18.99);
        Product p7 = new Product(7, "Baby's First Rattle", "Baby", 5.99);
        Product p8 = new Product(8, "Soft Plush Teddy Bear", "Baby", 9.49);
        Product p9 = new Product(9, "Colorful Stacking Blocks", "Baby", 14.99);
        Product p10 = new Product(10, "Ancient Spellbook", "Books", 25.99);
        Product p11 = new Product(11, "Space Explorer Helmet", "Boys", 16.99);
        Product p12 = new Product(12, "Cuddly Baby Blanket", "Baby", 11.99);
        Product p13 = new Product(13, "Epic Fantasy Saga", "Books", 102.99);
        Product p14 = new Product(14, "Robo-Bot Action Figure", "Boys", 14.99);
        Product p15 = new Product(15, "Giggling Baby Doll", "Baby", 9.99);
        Product p16 = new Product(16, "Legendary Quest Tome", "Books", 18.99);
        Product p17 = new Product(17, "Stealth Ninja Sword", "Boys", 10.99);
        Product p18 = new Product(18, "Magical Musical Mobile", "Baby", 12.49);

        List<Product> allProducts = new ArrayList<>();
        allProducts.add(p1);
        allProducts.add(p2);
        allProducts.add(p3);
        allProducts.add(p4);
        allProducts.add(p5);
        allProducts.add(p6);
        allProducts.add(p7);
        allProducts.add(p8);
        allProducts.add(p9);
        allProducts.add(p10);
        allProducts.add(p11);
        allProducts.add(p12);
        allProducts.add(p13);
        allProducts.add(p14);
        allProducts.add(p15);
        allProducts.add(p16);
        allProducts.add(p17);
        allProducts.add(p18);

        List<Product> productList1 = new ArrayList<>();
        productList1.add(p1);
        productList1.add(p2);
        productList1.add(p3);
        productList1.add(p13);
        productList1.add(p17);

        List<Product> productList2 = new ArrayList<>();
        productList2.add(p4);
        productList2.add(p5);
        productList2.add(p6);
        productList1.add(p14);
        productList1.add(p18);

        List<Product> productList3 = new ArrayList<>();
        productList3.add(p7);
        productList3.add(p8);
        productList3.add(p9);
        productList1.add(p15);

        List<Product> productList4 = new ArrayList<>();
        productList4.add(p10);
        productList4.add(p11);
        productList4.add(p12);
        productList1.add(p16);

        Customer c1 = new Customer(1, "Giuseppe", 1);
        Customer c2 = new Customer(2, "Maria", 2);
        Customer c3 = new Customer(3, "Antonio", 3);
        Customer c4 = new Customer(4, "Francesca", 2);
        Customer c5 = new Customer(5, "Luca", 1);
//        Customer c6 = new Customer(6, "Anna", 3);
//        Customer c7 = new Customer(7, "Giovanni", 2);
//        Customer c8 = new Customer(8, "Sofia", 1);
//        Customer c9 = new Customer(9, "Matteo", 3);
//        Customer c10 = new Customer(10, "Laura", 2);

        List<Order> allOrders = new ArrayList<>();
        allOrders.add(new Order(1, "a", LocalDate.of(2021, 7, 14), productList1, c1));
        allOrders.add(new Order(2, "b", LocalDate.of(2021, 3, 1), productList2, c2));
        allOrders.add(new Order(3, "a", LocalDate.of(2021, 2, 16), productList3, c4));
        allOrders.add(new Order(4, "c", LocalDate.of(2021, 10, 21), productList4, c3));
        allOrders.add(new Order(5, "b", LocalDate.of(2021, 7, 31), productList2, c5));




        //**ESERCIZIO 1**
        System.out.println("**ESERCIZIO 1**");
        System.out.println();

        List<Product> libri100 = allProducts.stream().filter(b -> b.getCategory() == "Books").filter(b -> b.getPrice() > 100).toList();
        libri100.forEach(System.out::println);
        System.out.println();

        //**ESERCIZIO 2**
        System.out.println("**ESERCIZIO 2**");
        System.out.println();

        List<Order> ordersBaby= allOrders.stream().filter(o-> o.getProducts().stream().anyMatch(p-> p.getCategory()=="Baby")).toList();
        ordersBaby.forEach(System.out::println);
        System.out.println();

        //**ESERCIZIO 3**
        System.out.println("**ESERCIZIO 3**");
        System.out.println();

        List<Product> boysProd10 = allProducts.stream()
                .filter(p->p.getCategory()=="Boys")
                .map(p->{
                    double prezzoScontato10= p.getPrice()*0.9;
                    return new Product(p.getId(),p.getName(),p.getCategory(), prezzoScontato10);
                })
                .toList();
        boysProd10.forEach(System.out::println);

        //**ESERCIZIO 4**
        System.out.println("**ESERCIZIO 4**");
        System.out.println();

       List<Order> ordTier2Date = allOrders.stream()
               .filter(o->o.getCustomer().getTier()==2)
               .filter(o->o.getOrderDate().isAfter(LocalDate.of(2021,2,1)))
               .filter(o->o.getOrderDate().isBefore(LocalDate.of(2021,4,1)))
               .toList();

       ordTier2Date.forEach(System.out::println);



    }


}