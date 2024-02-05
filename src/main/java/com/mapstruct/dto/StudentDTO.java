package com.mapstruct.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String fullName;
    private String totalSubject;
}
