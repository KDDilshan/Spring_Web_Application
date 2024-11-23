package com.kavindu.testing.service.impl;

import com.kavindu.testing.domain.dto.AuthorDto;
import com.kavindu.testing.respositories.AuthorRepository;
import com.kavindu.testing.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto CreateAuthor(AuthorDto authorDto) {
        return null;
    }

    @Override
    public List<AuthorDto> GetAllAuthors() {
        return List.of();
    }

    @Override
    public AuthorDto GetAuthorById(Long id) {
        return null;
    }
}
