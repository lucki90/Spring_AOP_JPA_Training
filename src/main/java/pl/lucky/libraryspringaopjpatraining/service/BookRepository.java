package pl.lucky.libraryspringaopjpatraining.service;

import org.springframework.stereotype.Component;
import pl.lucky.libraryspringaopjpatraining.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookRepository implements GenericRepository<String, Book>{

    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        System.out.println("CREATING LIST");
    }

    @Override
    public Book get(String isbn) {
        System.out.println("START GET");
        if (isbn==null || (isbn.length()!=13)){
            throw new IllegalArgumentException("Wrong isbn !");
        }
        randomPause(300);
        System.out.println("END GET");
        return books.stream()
                .filter(b -> isbn.equals(b.getIsbn()))
                .findFirst()
                .get();
    }

    @Override
    public void add(Book book) {
        System.out.println("START ADD");
        if(book == null || book.getIsbn() == null || book.getTitle() == null || book.getAuthor() == null) {
            throw new IllegalArgumentException("Book cannot have null fields");
        }
        randomPause(1000);
        books.add(book);
        System.out.println("END ADD");
    }

    private void randomPause(int maxTime){

        try {
            Thread.sleep(new Random().nextInt(maxTime));
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
