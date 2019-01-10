package tim.app.test.spring5webApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tim.app.test.spring5webApp.model.Author;
import tim.app.test.spring5webApp.model.Book;
import tim.app.test.spring5webApp.model.Publisher;
import tim.app.test.spring5webApp.repositories.AuthorRepository;
import tim.app.test.spring5webApp.repositories.BookRepository;
import tim.app.test.spring5webApp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authRep;
    private BookRepository bookRep;
    private PublisherRepository pubRep;

    public DevBootstrap(AuthorRepository authRep, BookRepository bookRep, PublisherRepository pubRep) {
        this.authRep = authRep;
        this.bookRep = bookRep;
        this.pubRep = pubRep;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        // publiser
        Publisher poo = new Publisher();
        poo.setName("The Publisher");
        pubRep.save(poo);

        // Eric
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "1234", poo);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        // Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE development without EJB", "223444", poo);
        rod.getBooks().add(noEJB);

        authRep.save(eric);
        authRep.save(rod);
        bookRep.save(ddd);
        bookRep.save(noEJB);
    }
}
