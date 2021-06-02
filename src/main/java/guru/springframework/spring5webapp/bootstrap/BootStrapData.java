package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher p1 = new Publisher("Gene Sniegowski", "123 Main St", "Abywhere", "IL", "11111");
        publisherRepository.save(p1);

        Author a1 = new Author("Gene", "Sniegowski");
        Book b1 = new Book("My Book", "111111111");
        Book b2 = new Book("My Book2", "111111111");
        Book b3 = new Book("My Book3", "111111111");
        a1.getBooks().add(b1);
        b1.setPublisher(p1);
        b2.setPublisher(p1);
        b3.setPublisher(p1);
        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);

        publisherRepository.save(p1);

        p1.getBooks().add(b1);

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        publisherRepository.save(p1);
        authorRepository.save(a1);
        bookRepository.save(b1);

        publisherRepository.save(p1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number Of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
