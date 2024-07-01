package com.david.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Mono<PostSdo> createNewPost(PostSdi sdi) {
        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Post post = Post.builder()
                .title(sdi.getTitle())
                .content(sdi.getContent())
                .createdAt(localDate)
                .build();

        return postRepository.save(post).map(p -> PostSdo.builder()
                .id(p.getId())
                .title(p.getTitle())
                .content(p.getContent())
                .createdAt(p.getCreatedAt())
                .build());
    }

    public Flux<PostSdo> getAllPostByTitle(String title) {
        return postRepository.findAllByTitle(title).delayElements(Duration.ofSeconds(1))
                .map(p -> PostSdo.builder()
                    .id(p.getId())
                    .title(p.getTitle())
                    .content(p.getContent())
                    .createdAt(p.getCreatedAt())
                    .build());
    }

    public Mono<PostSdo> getPostById(Long id) {
        return postRepository.findById(id).map(p ->
                PostSdo.builder()
                        .id(p.getId())
                        .title(p.getTitle())
                        .content(p.getContent())
                        .createdAt(p.getCreatedAt())
                        .build());
    }
}
