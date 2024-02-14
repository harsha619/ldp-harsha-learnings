package com.kafka.instagram.service;

import com.kafka.instagram.entity.Comment;
import com.kafka.instagram.entity.Post;

public interface IPostService {
    void followEvent(Post postRequest);

    void likeEvent(Post postRequest);

    void shareEvent(Post postRequest);

    void addCommentToPost(String id, Comment comment);

}
