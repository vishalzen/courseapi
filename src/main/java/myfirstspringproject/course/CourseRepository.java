package myfirstspringproject.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    //we don't have a function to filter Courses based on topic
    //But we can give hint to jpa by using a predefined format of func so that jpa will automatically implement it
    //Write names in camel case
    public List<Course> findByTopicId(String TopicId);

}
