package workshop.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private List<String> authors = new ArrayList<String>();

    public Book() {

    }

    public Book(Long id, String title, List<String> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
