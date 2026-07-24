package com.programacion.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Post {

    private Integer id;
    private String title;
    private String body;


}