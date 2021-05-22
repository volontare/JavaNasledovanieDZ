package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "Ночной дозор", 250, "Сергей Лукьяненко");
    Product book2 = new Book(2, "Три товарища", 10, "Эрих Мария Ремарк");
    Product book3 = new Book(3, "Собачье сердце", 168, "Михаил Булгаков");
    Product book4 = new Book(4, "Иван Васильевич", 118, "Михаил Булгаков");
    Product book5 = new Book(5, "Три мушкетера", 161, "Александр Дюма");
    Product book6 = new Book(6, "Убить пересмешника", 266, "Харпер Ли");
    Product book7 = new Book(7, "Зойкина квартира", 312, "Михаил Булгаков");
    Product book8 = new Book(8, "Ночной дозор", 402, "Сара Уотерс");
    Product smartphone1 = new Smartphone(9, "Redmi note 8 pro", 16490, "Хiaomi");
    Product smartphone2 = new Smartphone(12, "IPhone 11", 53990, "Apple");
    Product smartphone3 = new Smartphone(10, "30 Pro +", 54990, "Honor");
    Product smartphone4 = new Smartphone(11, "IPhone 12 mini", 69890, "Apple");
    Product smartphone5 = new Smartphone(12, "IPhone 12", 76490, "Apple");
    Product smartphone6 = new Smartphone(13, "IPhone 12", 75400, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        manager.add(smartphone6);
    }

    @Test
    void shouldSearchBookByAuthorIfOneBook() {
        Product[] expected = new Product[]{book6};
        Product[] actual = manager.searchBy("Харпер Ли");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthorIfManyBooks() {
        Product[] expected = new Product[]{book3, book4, book7};
        Product[] actual = manager.searchBy("Михаил Булгаков");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthorIfNoBooks() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Михаил Лермонтов");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNameIfOneBook() {
        Product[] expected = new Product[]{book5};
        Product[] actual = manager.searchBy("Три мушкетера");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNameIfManyBooks() {
        Product[] expected = new Product[]{book1, book8};
        Product[] actual = manager.searchBy("Ночной дозор");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNameIfNoBooks() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Война и мир");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturerIfOneSmartphone() {
        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy("Honor");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturerIfManySmartphones() {
        Product[] expected = new Product[]{smartphone2, smartphone4, smartphone5, smartphone6};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturerIfNoSmartphones() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sumsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[]{smartphone4};
        Product[] actual = manager.searchBy("IPhone 12 mini");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNameIfManySmartphones() {
        Product[] expected = new Product[]{smartphone5, smartphone6};
        Product[] actual = manager.searchBy("IPhone 12");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNameIfNoSmartphones() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Huawei");

        assertArrayEquals(expected, actual);
    }
}