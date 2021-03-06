package myWall.model.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity(dynamicUpdate = true)
@Table(name = "Messages")
@javax.persistence.Entity
@JsonAutoDetect
public class Message {

    protected String id;
    protected String name;
    protected String text;
    protected String date_time;
    protected Integer likes;
    protected Integer comments;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "text", length = 32)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "date_time", length = 32)
    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    @Column(name = "likes", length = 32)
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Column(name = "comments", length = 32)
    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }
}
