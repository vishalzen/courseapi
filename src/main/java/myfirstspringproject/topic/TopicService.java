package myfirstspringproject.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  annotate this as service to make it singleton
@Service
public class TopicService {
    //to get(inject) TopicRepository instance in current class
    @Autowired
    private TopicRepository topicRepository;
    /*
//  Arrays.asList make the list immutable hence we cant directly add data to list
// To make it mutable we use new ArrayList
   private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")));
   */

   public List<Topic> getAllTopics(){
       // SO topicRepository.findAll returns add iterable(table pointer) we need to
       // convert that to our list of topic we use foreach and add it to List
       List<Topic> topics = new ArrayList<>();
       topicRepository.findAll().forEach(topics::add);
       return topics;
   }


//   To get a individual id we filter all items in list topics and get the very first match
   public Topic getTopic(String id){
       /* a lambda expression(below is old way with no DB)
          return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
       */
       //return the found topic or NULL
       return topicRepository.findById(id).orElse(null);
   }

   public void addTopic(Topic topic){
       // topics.add(topic); //Add a new topic to list
       topicRepository.save(topic);

   }

   public void updateTopic(String id, Topic topic){
       /*for(int i = 0 ; i < topics.size() ; i++){
           Topic t = topics.get(i);
           if(t.getId().equals(id)){
               topics.set(i, topic);
               return;
           }
       }*/

       //So to update we don't need a diff func save find the topic and also updates it
       // It does by going to the row which has that topic & if its present there it updated it
       //We don't need id for it so we can remove id argument
       topicRepository.save(topic);
   }


    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
