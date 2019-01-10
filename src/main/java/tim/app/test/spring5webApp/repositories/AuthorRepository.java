package tim.app.test.spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import tim.app.test.spring5webApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
