package com.mapstruct.mapper;

import com.mapstruct.dto.StudentDTO;
import com.mapstruct.dto.StudentDTO1;
import com.mapstruct.entity.Student;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AbstractModelMapper {
    @Mapping(target = "fullName", expression = "java(setFullName(student.getFirstName(), student.getLastName()))")
    // @Mapping(target = "totalSubject", qualifiedByName = "totalSubjectStr")
    public abstract StudentDTO toDTO(Student student);

    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    public abstract StudentDTO toDTO1(Student student);

    @Named("Test")
    public abstract StudentDTO1 toDTO2(Student student);

    @IterableMapping(qualifiedByName = "Test")
    public abstract List<StudentDTO1> toListDTO1(List<Student> studentList);

    String setFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Named("totalSubjectStr")
    String totalSubjectStr(int totalSubject) {
        return String.valueOf(totalSubject);
    }
}
