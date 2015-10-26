package workshop.control;

import java.util.ArrayList;
import java.util.List;

public class BookOverview {

    private String title;
    private List<String> authorNames = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(List<String> authorNames) {
        this.authorNames = authorNames;
    }
}
