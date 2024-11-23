package com.kavindu.testing.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_id_seq")
    private Long id;

    private String Name;

    private Integer Age;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<BookEntity> books;

}