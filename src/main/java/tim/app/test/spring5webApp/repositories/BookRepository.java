package tim.app.test.spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import tim.app.test.spring5webApp.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
