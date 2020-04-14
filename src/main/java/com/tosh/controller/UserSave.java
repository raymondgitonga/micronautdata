package com.tosh.controller;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
public class UserSave {

    @NotBlank
    private String name;

    public UserSave(@NotBlank String name) {
        this.name = name;
    }

    public UserSave() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
