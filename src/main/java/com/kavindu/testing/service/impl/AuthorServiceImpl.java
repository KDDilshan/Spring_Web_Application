package com.kavindu.testing.service.impl;

import com.kavindu.testing.domain.dto.AuthorDto;
import com.kavindu.testing.domain.entities.AuthorEntity;
import com.kavindu.testing.mappers.impl.AuthorMapperImpl;
import com.kavindu.testing.respositories.AuthorRepository;
import com.kavindu.testing.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapperImpl authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapperImpl authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDto CreateAuthor(AuthorDto authorDto) {
        AuthorEntity authorEntity=authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthor=authorRepository.save(authorEntity);
        return authorMapper.mapTo(savedAuthor);
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
