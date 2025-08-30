package com.social.media.controllers;



import com.social.media.models.SocialUser;
import com.social.media.services.SocialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SocialController {

    @Autowired
    private SocialServices socialServices;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUser() {
        return new ResponseEntity<>(socialServices.getAllUser(), HttpStatus.OK);
    }


    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
        return new ResponseEntity<>(socialServices.saveUser(socialUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/social/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        socialServices.deleteUser(userId);
        return new ResponseEntity<>("User deleted Successfully", HttpStatus.OK);
    }

}
