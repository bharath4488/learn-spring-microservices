package com.learn.School.response;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    @CircuitBreaker(name = "findCommentsByPostIdCircuitBreaker", fallbackMethod = "findCommentsByPostIdFallback")
    List<Student> findAllBySchool(@PathVariable("school-id") Long schoolId);

    default List<Student> findCommentsByPostIdFallback(Exception exception) {
        System.out.println("\"circuit breaker default method\"");
        return Arrays.asList();
    }

}
