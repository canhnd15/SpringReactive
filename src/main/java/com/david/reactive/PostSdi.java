package com.david.reactive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PostSdi {
    private String title;
    private String content;
}
