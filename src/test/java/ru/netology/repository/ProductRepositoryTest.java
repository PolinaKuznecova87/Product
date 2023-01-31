package ru.netology.repository;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

public class ProductRepositoryTest {

    Product product1 = new Product(11, "Физика", 250);
    Product product2 = new Product(12, "Нокия", 11_000);
    Product product3 = new Product(13, "Химия", 350);


    @Test
    public void addTest() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneBookAndOneSmartphone() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(14, "Биология", 350, "Жуков И.И.");
        Smartphone smartphone1 = new Smartphone(15, "Samsung", 15_000, "Китай");


        repo.add(book1);
        repo.add(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void removeBayIdTest() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(15, "Онегин", 350, "Пушкин А.С.");
        Book book2 = new Book(16, "Война и мир", 740, "Толстой Л.Н.");
        Book book3 = new Book(17, "Отцы и Дети", 350, "Тургенев И.С.");
        Smartphone smartphone1 = new Smartphone(18, "Samsung А-50", 16_000, "Китай");
        Smartphone smartphone2 = new Smartphone(19, "Apple iPhone ", 45_000, "США");
        Smartphone smartphone3 = new Smartphone(20, "Honor", 12_500, "Китай");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeByeId(16);
        repo.removeByeId(19);

        Product[] expected = {book1, book3, smartphone1, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


}

