package com.example.springtest.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
}
