//package com.kafka.instagram.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.kafka.instagram.entity.Post;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class PostDeSerializer implements Deserializer<Post> {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        // No additional configuration needed
//    }
//
//    @Override
//    public Post deserialize(String topic, byte[] data) {
//        try {
//            return objectMapper.readValue(data, Post.class);
//        } catch (IOException e) {
//            throw new RuntimeException("Error deserializing Post", e);
//        }
//    }
//
//    @Override
//    public void close() {
//        // No resources to close
//    }
//}
