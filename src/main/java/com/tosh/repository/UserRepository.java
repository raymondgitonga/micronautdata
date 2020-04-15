package com.tosh.repository;

import com.tosh.model.User;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface UserRepository{

    User save(@NotBlank String name);
    Single<User> findById(@NotNull Long id);
}
