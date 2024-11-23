package com.kavindu.testing.service;

import com.kavindu.testing.domain.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto CreateAuthor(AuthorDto authorDto);
    List<AuthorDto> GetAllAuthors();
    AuthorDto GetAuthorById(Long id);
}
