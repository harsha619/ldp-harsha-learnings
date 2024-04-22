package com.kafka.instagram.service.Impl;

import com.kafka.instagram.entity.Comment;
import com.kafka.instagram.entity.Post;
import com.kafka.instagram.repository.PostRepository;
import com.kafka.instagram.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import static com.kafka.instagram.constant.AppConstants.USER_ACTIVITY_TOPIC;

@Service
public class InstagramProducers implements IPostService {

//    @Autowired
////    @Qualifier("followEventKafkaTemplate")
//    private KafkaTemplate<String, Post> followEventKafkaTemplate;
//
//    @Autowired
//    @Qualifier("likeEventKafkaTemplate")
//    private KafkaTemplate<String, Post> likeEventKafkaTemplate;
//
//    @Autowired
//    @Qualifier("commentEventKafkaTemplate")
//    private KafkaTemplate<String, Post> commentEventKafkaTemplate;
//
//    @Autowired
//    @Qualifier("messageEventKafkaTemplate")
//    private KafkaTemplate<String, Post> messageEventKafkaTemplate;
//
//    @Autowired
//    @Qualifier("aggregatedNotificationsKafkaTemplate")
//    private KafkaTemplate<String, Post> aggregatedNotificationsKafkaTemplate;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private KafkaTemplate<String, Post> kafkaTemplate;

    public void followEvent(Post postRequest) {
        Optional<Post> optionalPost = postRepository.findById(postRequest.getId());
        Message<Post> userMessage = MessageBuilder
                .withPayload(postRequest)
                .setHeader(KafkaHeaders.TOPIC, USER_ACTIVITY_TOPIC)

                .setHeader(KafkaHeaders.PARTITION, 0)
                .build();
        kafkaTemplate.send(userMessage);
        System.out.println("service");
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.incrementFollowCount();
            postRepository.save(post);
        } else {
            // Handle the case where the post with the given ID is not found
            // throw new PostNotFoundException("Post with ID " + postId + " not found");
        }
    }

    public void likeEvent(Post postRequest) {
        Optional<Post> optionalPost = postRepository.findById(postRequest.getId());
        Message<Post> userMessage = MessageBuilder
                .withPayload(postRequest)
                .setHeader(KafkaHeaders.TOPIC, USER_ACTIVITY_TOPIC)
                .setHeader(KafkaHeaders.PARTITION, 1)
                .build();
        System.out.println("like");
        kafkaTemplate.send(userMessage);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Increment the like count
            post.incrementLikeCount();
            postRepository.save(post);
            kafkaTemplate.send(userMessage);
        } else {
            // Handle the case where the post with the given ID is not found
            // throw new PostNotFoundException("Post with ID " + postId + " not found");
        }
    }

    public void shareEvent(Post postRequest) {
        Optional<Post> optionalPost = postRepository.findById(postRequest.getId());
        Message<Post> userMessage = MessageBuilder
                .withPayload(postRequest)
                .setHeader(KafkaHeaders.TOPIC, USER_ACTIVITY_TOPIC)
                .setHeader(KafkaHeaders.PARTITION, 2)
                .build();
        System.out.println("into share");
        kafkaTemplate.send(userMessage);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.incrementShareCount();
            postRepository.save(post);
        } else {
            // Handle the case where the post with the given ID is not found
            // throw new PostNotFoundException("Post with ID " + postId + " not found");
        }
    }

    public void addCommentToPost(String postId, Comment comment) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            if (post.getComments() == null) {
                post.setComments(new ArrayList<>());
            }
            post.getComments().add(comment);

            postRepository.save(post);
            Message<Post> userMessage = MessageBuilder
                    .withPayload(post)
                    .setHeader(KafkaHeaders.TOPIC, USER_ACTIVITY_TOPIC)
                    .setHeader(KafkaHeaders.PARTITION, 3)
                    .build();
            kafkaTemplate.send(userMessage);
        } else {
            // Handle the case where the post with the given ID is not found
            // throw new PostNotFoundException("Post with ID " + postId + " not found");
        }
    }
}
