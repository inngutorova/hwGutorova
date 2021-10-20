package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private List<Topic> topics = new ArrayList<>();

    // curl -X GET http://localhost:8080/topics - Выдать список тем
    @GetMapping("topics")
    public List<Topic> getTopics() {
        return topics;
    }

    // curl -X GET http://localhost:8080/topics/number -  Выдать количество тем

    @GetMapping("topics/number")
    public int getTopicsNumber() {
        return topics.size();
    }

    // curl -X POST http://localhost:8080/topics -H 'Content-Type: text/plain' -d 'Cherry orchard' - Создать тему
    @PostMapping("topics")
    public void addTopic(@RequestBody String t) {
       topics.add(new Topic(t));
    }

    // curl -X GET http://localhost:8080/opics/0 -  Выдать определенную тему
    @GetMapping("topics/{index}")
    public Topic getTopic(@PathVariable("index") Integer i) {
        return topics.get(i);
    }

    // curl -X DELETE http://localhost:8080/topics/0 - Удалить тему
    @DeleteMapping("topics/{index}")
    public void deleteTopic(@PathVariable("index") Integer i) {
        topics.remove((int) i);
    }

    // curl -X DELETE http://localhost:8080/topics - Удалить все темы
    @DeleteMapping("topics")
    public void deleteTopics() {
        for (int i = 0; i < topics.size(); ++i) {
            topics.remove(i);
        }
    }

    // curl -X PUT http://localhost:8080/topics/0 -H 'Content-Type: text/plain' -d 'Naruto' - Обновить тему
    @PutMapping("topics/{index}")
    public void updateTopic(@PathVariable("index") Integer i, @RequestBody String n) {
        topics.get(i).setName(n);
    }


    // curl -X GET http://localhost:8080/topics/0/comments - Выдать список комментариев определенной темы
    @GetMapping("topics/{index}/comments")
    public List<Comment> getComments(@PathVariable("index") Integer i) {
        return topics.get(i).getComments();
    }

    // curl -X POST http://localhost:8080/topics/0/comments -H 'Content-Type: text/plain' -d 'Wow' - Создать комментарий в определенной теме
    @PostMapping("topics/{index}/comments")
    public void addComment(@PathVariable("index") Integer i, @RequestBody String t) {
        topics.get(i).getComments().add(new Comment(t));
    }

    // curl -X DELETE http://localhost:8080/topics/0/comments/0 - Удалить комментарий из определенной темы
    @DeleteMapping("topics/{index}/comments/{index2}")
    public void deleteComment(@PathVariable("index") Integer i, @PathVariable("index2") Integer c) {
        topics.get(i).getComments().remove(c);
    }

    // curl -X PUT http://localhost:8080/topics/0/comments/0-H 'Content-Type: text/plain' -d 'Cool' - Обновить комментарий в определенной теме
    @PutMapping("topics/{index}/comments/{index2}")
    public void updateTopic(@PathVariable("index") Integer i,@PathVariable("index2") Integer c, @RequestBody String t) {
        topics.get(i).getComments().get(c).setText(t);
    }


}

