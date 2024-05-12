package com.learn.School;

import com.learn.School.response.FullSchoolResponse;
import com.learn.School.response.Student;
import com.learn.School.response.StudentClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public FullSchoolResponse getSchoolWithStudents(Long schoolId) {
        School school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .schoolName("NOT_FOUND")
                        .build());
        log.info(school.toString());
        List<Student> students = studentClient.findAllBySchool(schoolId);
        return FullSchoolResponse.builder().schoolName(school.getSchoolName()).students(students).build();
    }
}
