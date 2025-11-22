package org.example.models;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String username;
    private String email;
}