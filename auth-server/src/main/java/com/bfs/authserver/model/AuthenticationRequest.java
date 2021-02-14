package com.bfs.authserver.model;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {

    private String username;
    private String password;
    private String redirect;
}
