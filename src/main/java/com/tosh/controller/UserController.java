package com.tosh.controller;

import com.tosh.model.User;
import com.tosh.repository.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/users")
public class UserController {

    protected final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Get("/hello")
    public String hello(){
        return "Hello";
    }

    @Get("/{id}")
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Post("/")
    public HttpResponse<User> save(@Body @Valid UserSave userSave) {
       User user = userRepository.save(userSave.getName());

        return HttpResponse
                .created(user);
    }
}
