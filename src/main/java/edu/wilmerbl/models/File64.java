package edu.wilmerbl.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;
@Entity
public class File64 {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "title", length = 256)
    private String title;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "description")
    private String description;

    public File64(UUID id, String title, Date creationDate, String description) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

