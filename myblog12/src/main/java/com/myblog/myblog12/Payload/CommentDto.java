package com.myblog.myblog12.Payload;

import lombok.Data;

@Data
public class CommentDto {
    private long id;

    private String text;

    private String email;
}
