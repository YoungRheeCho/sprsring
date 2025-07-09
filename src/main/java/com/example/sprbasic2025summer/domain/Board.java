package com.example.sprbasic2025summer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter String title;
    @Setter String content;
    @Setter String author;

    protected Board() {}
    private Board(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static Board of(String title, String content, String author){
        return new Board(title, content, author);
    }

}
