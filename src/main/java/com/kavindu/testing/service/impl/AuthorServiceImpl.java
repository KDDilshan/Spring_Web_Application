package com.kavindu.testing.service.impl;

import com.kavindu.testing.domain.dto.AuthorDto;
import com.kavindu.testing.domain.entities.AuthorEntity;
import com.kavindu.testing.mappers.Mapper;
import com.kavindu.testing.mappers.impl.AuthorMapperImpl;
import com.kavindu.testing.respositories.AuthorRepository;
import com.kavindu.testing.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, Mapper<AuthorEntity,AuthorDto> authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDto CreateAuthor(AuthorDto authorDto) {
        if(authorDto==null){
            throw new IllegalArgumentException("authorDto cannot be null");
        }
        AuthorEntity authorEntity=authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthor=authorRepository.save(authorEntity);
        return authorMapper.mapTo(savedAuthor);
    }

    @Override
    public List<AuthorDto> GetAllAuthors() {
        List<AuthorEntity> authorEntityList=authorRepository.findAll();
        return authorEntityList.stream()
                .map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto GetAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::mapTo)
                .orElseThrow(()-> new RuntimeException(("Author with id not found :"+id)));
    }
}
