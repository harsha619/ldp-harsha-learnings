package com.kafka.instagram.controller;

import com.kafka.instagram.entity.Comment;
import com.kafka.instagram.entity.Post;
import com.kafka.instagram.service.Impl.InstagramProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instagram")
public class InstagramController {

    private final InstagramProducers instagramProducers;

    @Autowired
    public InstagramController(InstagramProducers instagramProducers) {
        this.instagramProducers = instagramProducers;
    }

    @PostMapping("/follow")
    public void followEvent(@RequestBody Post post) {
        instagramProducers.followEvent(post);
        System.out.println("ito contr");
    }

    @PostMapping("/like")
    public void likeEvent(@RequestBody Post post) {
        instagramProducers.likeEvent(post);
    }

    @PostMapping("/comment/{id}")
    public void commentEvent(@PathVariable String id, @RequestBody Comment comment) {
        instagramProducers.addCommentToPost(id, comment);
    }

    @PostMapping("/share")
    public void shareEvent(@RequestBody Post post) {
        instagramProducers.shareEvent(post);
    }
}
