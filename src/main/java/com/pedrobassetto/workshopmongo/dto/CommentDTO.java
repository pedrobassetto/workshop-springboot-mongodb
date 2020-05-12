package com.pedrobassetto.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    private String id;
    private Date data;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String id, Date data, AuthorDTO author) {
        this.id = id;
        this.data = data;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
