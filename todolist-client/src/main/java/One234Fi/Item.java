package One234Fi;

/**
 * Item class provides a definition for parsing items from Json
 *
 */

public class Item {
    private Integer id;
    private String title;
    private String body;

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "title: " + this.title + "\nbody: " + this.body;
    }
}
