package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.repository.AuthorRepository;
import com.example.spring5webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }
    private void initData(){

        //Cristiano
        Author cristiano = new Author("Cristiano", "Borges Cardoso");
        Book book1 = new Book("How To Mine Crypto Currencies", "1234", "Nobody");
        cristiano.getBooks().add(book1);
        book1.getAuthors().add(cristiano);
        authorRepository.save(cristiano);
        bookRepository.save(book1);

        //Imelda
        Author imelda = new Author("Imelda", "Zuarth");
        Book book2 = new Book("How To Play Baraja", "171", "Nobody");
        imelda.getBooks().add(book2);
        book2.getAuthors().add(imelda);
        authorRepository.save(imelda);
        bookRepository.save(book2);
    }

}






