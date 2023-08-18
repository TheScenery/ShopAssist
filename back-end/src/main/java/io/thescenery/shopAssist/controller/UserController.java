package io.thescenery.shopAssist.controller;

import io.thescenery.shopAssist.dao.UserDao;
import io.thescenery.shopAssist.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable int id) {
        return userDao.getUserById(id);
    }
}
