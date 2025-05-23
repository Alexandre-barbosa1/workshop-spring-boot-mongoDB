package com.alexandrebarbosa.workshopmongo.domain;

import com.alexandrebarbosa.workshopmongo.dto.AuthorDTO;
import com.alexandrebarbosa.workshopmongo.dto.CommentDTO;
import com.alexandrebarbosa.workshopmongo.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Document

public class Post implements Serializable {
    private static final long serialVersionUID = 1L;


    String body;
    Date date;
    @Id
    String id;
    String title;
    AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();


    public Post(){

    }
    public Post( Date date, String id, String title,String body, AuthorDTO author) {
        this.body = body;
        this.date = date;
        this.id = id;
        this.title = title;
        this.author = author;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
