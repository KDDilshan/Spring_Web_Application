package com.kavindu.testing.mappers;

import com.kavindu.testing.domain.dto.AuthorDto;
import com.kavindu.testing.domain.entities.AuthorEntity;

public interface Mapper<A,B> {
    B mapTo(A a);
    A mapFrom(B b);
}
