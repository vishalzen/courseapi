package myfirstspringproject.topic;

import org.springframework.data.repository.CrudRepository;
// So CrudRepository interface comes with basic function of DB mapping
// We Just have to extend that, also we use < > to declare generic type(type of data we gonna use)
public interface TopicRepository extends CrudRepository<Topic, String> {
}
