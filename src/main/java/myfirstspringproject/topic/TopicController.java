package myfirstspringproject.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
//    to declare the TopicService object
    @Autowired
    public TopicService topicService;

    @RequestMapping("/")
    public String Hello(){
        return "Hi there";
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){

        return topicService.getAllTopics();
    }


//    To pick the string from search bar path ex: topic/spring we tokenize it
//    in order to put the fetched string from path to below function we use path variable
//    if fetched string name is not same we use @PathVariable("name")
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){

        return topicService.getTopic(id);
    }

//    By default mapping is GET so to specify a mapping we use below way(RequestMethod)
//    To pick the json payload and send that to below function we use request body
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic); //send it to the service
    }

//    put requires a id and what changes to be made
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

//    Instead of writing RequestMapping then method we can simply use specific annotation
    @DeleteMapping(value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
