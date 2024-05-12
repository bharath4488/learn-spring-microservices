package com.learn.School.response;

import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
public class FullSchoolResponse {
    private String schoolName;
    private List<Student> students;
}
