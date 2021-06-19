package myfirstspringproject.course;

import myfirstspringproject.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

// As course is a sub part of topic (each topic contain one or more course)
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){

        return courseService.getAllCourses(id);
    }

    //see we can name path variable as we want here we just focus on course id
    //so id of topic became topicId
    //We are only fetching course id
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){

        return courseService.getCourse(id);
    }
    // We are posting a course in course table which also has a Topic column(just like employee dept schema)
    // So in json we only serve the course data and we will fetch topic from path hence a setter is used
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        //we don't need to send id(look in service for whats happening there)
        courseService.updateCourse(course);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
