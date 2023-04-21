package com.multicampus.feedtypesns.controller;

import com.multicampus.feedtypesns.domain.Users.Users;
import com.multicampus.feedtypesns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(){
        return "users/createUser";
    }

    @PostMapping("/users/new")
    public String create(@RequestBody Users user, Model model){
        userService.reg(user);
        model.addAttribute("userId", user.getUserName());
        model.addAttribute("nickname", user.getNickname());

        return "redirect:/users/new";
    }
    //@RequestParam("userId") String userId, @RequestParam("nickname") String nickname


}
