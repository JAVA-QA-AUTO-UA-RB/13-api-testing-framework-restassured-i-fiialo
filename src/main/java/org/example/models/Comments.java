package org.example.models;

import lombok.Data;

@Data
public class Comments {
    private int id;
    private int postId;
    private String name;
    private String email;
    private String body;
}