package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}