package com.kavindu.testing.respositories;

import com.kavindu.testing.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    List<AuthorEntity> findByNameContaining(String name);
}
