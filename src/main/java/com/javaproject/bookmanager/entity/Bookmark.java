package com.javaproject.bookmanager.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "bookmark")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "url")
    String url;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key linking to Users table
    private Users user;

    //Define constructor
    public Bookmark(){

    }

    public Bookmark( String title, String url){
        this.title = title;
        this.url = url;
    }

    //Getter and Setter
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    //Define toString()
    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
