package com.tosh.controller;

import com.tosh.model.User;
import com.tosh.repository.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/users")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @Get("/hello")
    public String hello(){
        return "Hello";
    }

    @Get("/{id}")
    public Single<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Post("/")
    public HttpResponse<User> save(@Body @Valid UserSave userSave) {
       User user = userRepository.save(userSave.getName());

        return HttpResponse
                .created(user);
    }
}
