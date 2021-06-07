package com.toy.sy;

import com.toy.sy.validator.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;

    }

    @GetMapping("test")
    public void join() {
        System.out.println(userService.selectAll().toString());

    }

    @PostMapping("join")
    public ResponseEntity join(@Valid User user, BindingResult bindingResult) {
        System.out.println("join");
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        System.out.println("ok");
        userService.insertUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("update")
    public void update(User user) {
        System.out.println(user.toString());
        userService.updateUser(user);

    }

    @DeleteMapping("delete")
    public void delete(User user) {
        System.out.println(user.toString());
        userService.deleteUser(user);
    }


    @PutMapping("mybatis_update")
    public ResponseEntity mybatis_update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        userService.mybatis_update(user);
        return ResponseEntity.ok(user);
    }


}
