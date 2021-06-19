package myfirstspringproject.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String id){
       // Notice that it will fetch course with the whole topic data(ie id,name,des) its associated to
       //We can prevent this by lazy load(Read about it)
       List<Course> courses = new ArrayList<>();
       courseRepository.findByTopicId(id).forEach(courses::add);
       return courses;
    }



    public Course getCourse(String id){

       return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course){

       courseRepository.save(course);
    }

    public void updateCourse(Course course){

       courseRepository.save(course);
    }


    public void deleteCourse(String id) {

        courseRepository.deleteById(id);
    }
}
