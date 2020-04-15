package com.tosh.repository;

import com.tosh.model.User;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.spring.tx.annotation.Transactional;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Singleton
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final ApplicationConfiguration applicationConfiguration;

    public UserRepositoryImpl(@CurrentSession EntityManager entityManager, ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    @Transactional
    public User save(@NotBlank String name) {
        User user = new User(name);
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Single<User> findById(@NotNull Long id) {
        return Single.just(entityManager.find(User.class, id))
                .subscribeOn(Schedulers.io());
    }
}
