package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private List<User> users = new ArrayList<>();

    @GetMapping("users")
    public List<User> getUsers() {
        return users;
    }

    // curl -X POST http://localhost:8080/users -H 'Content-Type: application/json' -d '{"name" : "Oleg", "age" : "56"}' - добавляет сообщение в список

    @PostMapping("users")
    public void addUser(@RequestBody User user) {
       users.add(user);
    }

    // curl -X GET http://localhost:8080/users/0 - выводит на экран пользователя по индексу
    @GetMapping("users/{index}")
    public User getUser(@PathVariable("index") Integer index) {
        return users.get(index);
    }
    // curl -X DELETE http://localhost:8080/users/0 - удаляет пользователя по индексу
    @DeleteMapping("users/{index}")
    public void deleteUser(@PathVariable("index") Integer index) {
        users.remove((int) index);
    }

    // curl -X PUT http://localhost:8080/users/0 -H 'Content-Type: application/json' -d '2' - обновляет возраст пользователя по индексу

    @PutMapping("users/{index}")
    public void updateUserAge(@PathVariable("index") Integer i, @RequestBody int age) {
        users.get(i).setAge(age);
    }
    // curl -X GET http://localhost:8080/users - выводит список пользователей
}

