package com.david.reactive;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostSdo {
    private Long id;
    private String title;
    private String content;
    private LocalDate createdAt;
}
