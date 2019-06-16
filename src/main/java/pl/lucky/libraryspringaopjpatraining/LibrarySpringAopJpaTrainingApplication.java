package pl.lucky.libraryspringaopjpatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.lucky.libraryspringaopjpatraining.model.Book;
import pl.lucky.libraryspringaopjpatraining.service.BookRepository;
import pl.lucky.libraryspringaopjpatraining.service.GenericRepository;

@SpringBootApplication
public class LibrarySpringAopJpaTrainingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =  SpringApplication.run(LibrarySpringAopJpaTrainingApplication.class, args);

        BookRepository repo = ctx.getBean(BookRepository.class);
        repo.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
        repo.add(new Book("2345678901234", "Druga", "Drugi autor"));
        repo.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
        try {
        repo.add(new Book(null, "Trzecia", "Trzeci autor"));
        }catch (Exception ex){
            ex.getMessage();
        }
        Book book = repo.get("1234567890123");

        System.out.println(book);

        ctx.close();

    }

}
