package com.example.springtest.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
}
