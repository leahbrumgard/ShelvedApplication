package edu.swarthmore.cs.cs71.shelved.model.server;

import edu.swarthmore.cs.cs71.shelved.model.api.Author;

import javax.persistence.*;

@Entity
@Table(name="author")
public class HibAuthor implements Author {
    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fullName")
    private String fullName;

    @Column(name="lastName")
    private String lastName;

    public HibAuthor() {
    }

    public HibAuthor(String authorName) {
        this.fullName = authorName;
        this.lastName = authorName.substring(authorName.lastIndexOf(" ") +1);
    }


    public int getId() {
        return id;
    }

    @Override
    public String getAuthorName() {
        return this.fullName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}
