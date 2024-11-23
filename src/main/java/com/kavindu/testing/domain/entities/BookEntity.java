package com.kavindu.testing.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id_seq")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name="author_id",insertable=false,updatable=false)
    private AuthorEntity author;

    @Column(name = "author_id")
    private Long authorId;
}
