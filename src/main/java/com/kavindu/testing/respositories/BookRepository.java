package com.kavindu.testing.respositories;

import com.kavindu.testing.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
