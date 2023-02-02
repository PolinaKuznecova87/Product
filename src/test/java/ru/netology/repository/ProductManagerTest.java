package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Product(11, "Физика", 250);
    Product product2 = new Product(12, "Нокия", 11_000);
    Product product3 = new Product(13, "Химия", 350);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

    }

    @Test
    public void shouldAllProdгct() {
        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchByText() {


        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Химия");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySomeBookByText() {
        Book book1 = new Book(14, "Онегин", 450, "Пушкин А.С.");
        Book book2 = new Book(15, "Азбука", 600, "Жуков И.И.");
        Book book3 = new Book(16, "Азбука", 250, "Иванов И.И.");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);


        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("Азбука");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySmartphoneByText() {
        Smartphone smartphone1 = new Smartphone(17, "Samsung", 15_000, "Китай");
        Smartphone smartphone2 = new Smartphone(18, "Apple iPhone", 45_000, "США");
        Smartphone smartphone3 = new Smartphone(19, "Honor", 16_000, "Китай");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);

    }

}







