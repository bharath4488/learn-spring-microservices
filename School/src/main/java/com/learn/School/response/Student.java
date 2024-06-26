package com.learn.School.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private String email;
}
