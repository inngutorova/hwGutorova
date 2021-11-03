package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private List<Topic> topics = new ArrayList<>();
    private List<User> users = new ArrayList<>();

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

    // curl -X POST http://localhost:8080/topics/0/0/comments -H 'Content-Type: text/plain' -d 'Wow' - Создать комментарий в определенной теме
    @PostMapping("themes/{index}/{indUser}/comments")
    public void addComment(@PathVariable("index") Integer i, @PathVariable("indUser") Integer ind, @RequestBody String text) {
        users.get(ind).getComments().add(new Comment(text));
        topics.get(i).getComments().add(new Comment(text));
    }

    // curl -X DELETE http://localhost:8080/topics/0/0/comments/0 - Удалить комментарий из определенной темы
    @DeleteMapping("themes/{index}/{indUser}/comments/{indexCom}")
    public void deleteComment(@PathVariable("index") Integer index, @PathVariable("indUser") Integer ind, @PathVariable("indexCom") Integer indexCom) {
        users.get(ind).getComments().remove(indexCom);
        topics.get(index).getComments().remove(indexCom);
    }

    // curl -X PUT http://localhost:8080/topics/0/0/comments/0-H 'Content-Type: text/plain' -d 'Cool' - Обновить комментарий в определенной теме
    @PutMapping("themes/{index}/{indUser}/comments/{indexCom}")
    public void updateComment(@PathVariable("index") Integer i, @PathVariable("indUser") Integer ind,@PathVariable("indexCom") Integer indexCom, @RequestBody String text) {
        users.get(ind).getComments().get(indexCom).setText(text);
        topics.get(i).getComments().get(indexCom).setText(text);
    }



    // curl -X POST http://localhost:8080/users -H 'Content-Type:application/json' -d '{"name" : "Inna Gutorova", "age" : "17"}'
    @PostMapping("users")
    public void addUser(@RequestBody User user) {
        users.add(new User(user.name, user.age));
    }

    // curl -X DELETE http://localhost:8080/users/0
    @DeleteMapping("users/{index}")
    public void deleteUser(@PathVariable("index") Integer index) {
        users.remove((int) index);
    }

    // curl -X GET http://localhost:8080/users/0
    @GetMapping("users/{index}")
    public User getUser(@PathVariable("index") Integer index) {
        return users.get(index);
    }

    // curl -X GET http://localhost:8080/users
    @GetMapping("users")
    public List<User> getUsers() {
        return users;
    }

    // curl -X PUT http://localhost:8080/users/0 -H 'Content-Type: application/json' -d '13' - Обновить комментарий определенного пользователя в определенной теме
    @PutMapping("users/{index}")
    public void updateUserAge(@PathVariable("index") Integer i, @RequestBody int age) {
        users.get(i).setAge(age);
    }

    // curl -X GET http://localhost:8080/users/0/comments
    @GetMapping("users/{index}/comments")
    public List<Comment> getUserComments(@PathVariable("index") Integer i) {
        return users.get(i).getComments();
    }

    // curl -X PUT http://localhost:8080/themes/0/0/comments/0 -H 'Content-Type: text/plain' -d 'Wow'
    @PutMapping("users/{index}/{ind}/comments/{indexCom}")
    public void updateUserComment(@PathVariable("index") Integer i, @PathVariable("ind") Integer ind, @PathVariable("indexCom") Integer indexCom, @RequestBody String text) {
        users.get(i).getComments().get(indexCom).setText(text);
        topics.get(ind).getComments().get(indexCom).setText(text);
    }
}

