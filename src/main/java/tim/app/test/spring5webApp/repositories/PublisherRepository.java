package tim.app.test.spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import tim.app.test.spring5webApp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
