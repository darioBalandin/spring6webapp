package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author dario = new Author();
        dario.setFirstName("Dario");
        dario.setLastName("Perez");

        Book book1 = new Book();
        book1.setTitle("Book1");
        book1.setIsbn("1234");

        Author darioSaved = authorRepository.save(dario);
        Book bookSaved = bookRepository.save(book1);


        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book book2 = new Book();
        book2.setTitle("Book2");
        book2.setIsbn("123456565");

        Author rodSaved = authorRepository.save(rod);
        Book book2Saved = bookRepository.save(book2);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setZip("33701");

        Publisher publisherSaved = publisherRepository.save(publisher);

        darioSaved.getBooks().add(bookSaved);
        rodSaved.getBooks().add(book2Saved);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books for Publisher: " + publisher.getPublisherName());

    }
}

