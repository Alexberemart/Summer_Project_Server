package myWall.model.vo;

import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity(dynamicUpdate = true)
@Table(name = "Messages")
@javax.persistence.Entity
public class Message {

    protected String id;

    @Id
    @Column(name = "id", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
