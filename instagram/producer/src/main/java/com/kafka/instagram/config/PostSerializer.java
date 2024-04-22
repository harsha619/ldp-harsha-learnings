//package com.kafka.instagram.config;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.kafka.instagram.entity.Post;
//import org.apache.kafka.common.serialization.Serializer;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//public class PostSerializer implements Serializer<Post> {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        // No additional configuration needed
//    }
//
//    @Override
//    public byte[] serialize(String topic, Post post) {
//        if (post == null) {
//            return null;
//        }
//        // Implement your serialization logic here
//        try {
//            return objectMapper.writeValueAsString(post).getBytes(StandardCharsets.UTF_8);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void close() {
//        // No resources to release
//    }
//}
