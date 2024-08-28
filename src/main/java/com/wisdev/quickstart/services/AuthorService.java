package com.wisdev.quickstart.services;

import com.wisdev.quickstart.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorEntity createAuthor(AuthorEntity authorEntity);

    List findAll();

    Optional<AuthorEntity> findOne(Long id);
}
