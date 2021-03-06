package edu.swarthmore.cs.cs71.shelved.model.server;

import edu.swarthmore.cs.cs71.shelved.model.api.Book;

import javax.persistence.*;
import java.util.Dictionary;
import java.util.List;

@Entity
@Table(name="book")
public class HibBook implements Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = HibAuthor.class)
    @JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private HibAuthor author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = HibGenre.class)
    @JoinTable(name = "book_genre", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    private HibGenre genre;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = HibTitle.class)
    @JoinTable(name = "book_title", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "title_id") })
    private HibTitle title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = HibISBN.class)
    @JoinTable(name = "book_isbn", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "isbn_id") })
    private HibISBN isbn;


    @Column(name="pages")
    private int pages;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = HibPublisher.class)
    @JoinTable(name = "book_publisher", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "publisher_id") })
    private HibPublisher publisher;

    @Column(name="imageUrl")
    private String imageUrl;

    public HibBook(){
    }

    @Override
    public void setAuthor(String author) {
        this.author = new HibAuthor(author);
    }

    @Override
    public void setGenre(String genre) {
        this.genre = new HibGenre(genre);
    }

    @Override
    public void setTitle(String title) {
        this.title = new HibTitle(title);
    }

    @Override
    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void setPublisher(String publisher) {
        this.publisher = new HibPublisher(publisher);
    }

    @Override
    public void setISBN(String isbn) {this.isbn = new HibISBN(isbn);}

    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public HibAuthor getAuthor() {
        return this.author;
    }


    public HibGenre getGenre() {
        return this.genre;
    }

    public HibTitle getTitle() {
        return this.title;
    }

    public HibISBN getISBN() {
        return this.isbn;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int getPages() {
        return this.pages;
    }

    public HibPublisher getPublisher() {
        return this.publisher;
    }

    // TODO: What's the type of this method getRecBooks()

    public List<HibBook> getRecBooks() {
        return null;
    }

    @Override
    public Dictionary<String, Double> getPrices() {
        return null;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
