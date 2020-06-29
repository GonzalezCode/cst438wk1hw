package cst438week1hw.cst438week1hw;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Post {
    //It should contain attributes title, rating, name of person who posted the rating, date and time of posting.
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min=3,max=25)
    private String title;
    @NotNull
    @Size(min=3,max=25)
    private String name;
    @NotNull
    @Size(min=1,max=5)
    private String rating;

    private String date;

    public Post(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = LocalDateTime.now().format(formatter);
    }

    public Post(String name, String title, String rating){
        super();
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.date = LocalDateTime.now().toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
