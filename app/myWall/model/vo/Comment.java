package myWall.model.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity(dynamicUpdate = true)
@Table(name = "Comments")
@javax.persistence.Entity
@JsonAutoDetect
public class Comment {

    protected String id;
    protected String name;
    protected String text;
    protected String id_message;
    protected String date_time;

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

    @Column(name = "id_message", length = 32)
    public String getId_message() {
        return id_message;
    }

    public void setId_message(String id_message) {
        this.id_message = id_message;
    }

    @Column(name = "date_time", length = 32)
    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
