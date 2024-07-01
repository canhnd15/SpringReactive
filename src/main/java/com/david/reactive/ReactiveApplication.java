package com.david.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(PostRepository postRepository) {
//		return args -> {
//			LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//			for(int i=0; i<200; i++) {
//				Post post = Post.builder()
//						.title("title " + i)
//						.content("content " + i)
//						.createdAt(localDate)
//						.build();
//				postRepository.save(post).subscribe();
//			}
//		};
//	}

}
