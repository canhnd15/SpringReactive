package com.david.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/")
    public Mono<PostSdo> createNewPost(@RequestBody PostSdi sdi) {
        return postService.createNewPost(sdi);
    }

    @GetMapping("/{id}")
    public Mono<PostSdo> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PostSdo> getAllPostByTitle(@RequestParam String title) {
        return postService.getAllPostByTitle(title);
    }
}
