package com.kafka.instagram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Post")
public class Post {
    @Id
    private String id;

    private String name;
    private Integer postId;
    private Integer noOfLikes;
    private List<Comment> comments;
    private Integer noOfShares;
    private Integer followers;

    // Other fields and methods...

    public void incrementLikeCount() {
        if (noOfLikes == null) {
            noOfLikes = 1;
        } else {
            noOfLikes++;
        }
    }

    public void incrementFollowCount() {
        if (followers == null) {
            followers = 1;
        } else {
            followers++;
        }
    }

    public void incrementShareCount() {
        if (noOfShares == null) {
            noOfShares = 1;
        } else {
            noOfShares++;
        }
    }

    // Add more methods for incrementing other counts if needed
}
