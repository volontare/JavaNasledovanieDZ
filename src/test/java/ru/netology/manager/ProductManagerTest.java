package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest{
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "Преступление и наказание", 150, "Ф.М. Достоевский");
    Product book2 = new Book(2, "Три товарища", 10, "Эрих Мария Ремарк");
    Product book3 = new Book(3, "Собачье сердце", 168, "Михаил Булгаков");
    Product book4 = new Book(4, "Три мушкетера", 161, "Александр Дюма");
    Product book5 = new Book(5, "Убить пересмешника", 266, "Харпер Ли");
    Product smartphone1 = new Smartphone(6, "Redmi note 8 pro", 16490, "Хiaomi");
    Product smartphone2 = new Smartphone(7, "30 Pro +", 54990, "Honor");
    Product smartphone3 = new Smartphone(8, "IPhone 12 mini", 69890, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] expected = new Product[]{book4};
        Product[] actual = manager.searchBy("Три мушкетера");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByName() {
        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("Собачье сердце");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("Honor");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy("IPhone 12 mini");

        assertArrayEquals(expected, actual);
    }
}
