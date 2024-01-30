package com.ldp.sender.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sender {

    private String message;
    private Integer price;
    private String news;
    private String analytics;
    private String alert;
}
