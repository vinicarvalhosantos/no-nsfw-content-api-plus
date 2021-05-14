package com.vinicius.santos.nonsfwcontentapiplus.controller.v2;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.User;
import com.vinicius.santos.nonsfwcontentapiplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public @ResponseBody
    ResponseEntity createUser(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

}
