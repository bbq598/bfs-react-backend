package com.bfs.auth.domain;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Test {
    private String username;
    private String age;
}
