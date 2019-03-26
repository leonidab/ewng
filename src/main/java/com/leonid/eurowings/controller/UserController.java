package com.leonid.eurowings.controller;

import com.leonid.eurowings.entities.User;
import com.leonid.eurowings.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a controller that describes the REST endpoints of our API
 *
 * @author Leonid Abrahams
 */

@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    // return all users in the table
    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // return a single user
    @GetMapping("singleuser/{userId}")
    public List<User> getOneUser(@PathVariable Long userId) {
        return userDAO.getUserByUserid(userId);
    }

    // save a new user
    @PostMapping("/saveuser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userDAO.save(user);
        return new ResponseEntity<>("User with ID: " + user.getUserid() + " and username " + user.getUsername() + " saved!", HttpStatus.OK);
    }

    // delete user from db
    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userDAO.deleteUserByUserid(userId);
        return new ResponseEntity<>("User with ID: " + userId + " deleted!", HttpStatus.OK);
    }

    // get only users that subscribed after a certain date
    @GetMapping("/getfromdate/{date}")
    public List<User> getUsersFromDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<User> list = userDAO.findAll();
        return list.stream().filter(o -> o.getSubscriptiondate().isAfter(localDate)).collect(Collectors.toList());
    }

    // get only users that subscribed before a certain date
    @GetMapping("/getbeforedate/{date}")
    public List<User> getUsersBeforeDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<User> list = userDAO.findAll();
        return list.stream().filter(o -> o.getSubscriptiondate().isBefore(localDate)).collect(Collectors.toList());
    }
}
