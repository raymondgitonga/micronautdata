package com.tosh.repository;

import com.tosh.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserRepository{

    User save(@NotBlank String name);
    Optional<User>findById(@NotNull Long id);
}
