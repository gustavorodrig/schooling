package com.schooling.service;

import com.schooling.entity.School;
import com.schooling.repository.SchoolRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService
{
    private final SchoolRespository schoolRespository;

    public List<School> findAll() {
        return schoolRespository.findAll();
    }

    public Optional<School> findById(Long id) {
        return schoolRespository.findById(id);
    }

    public School save(School school) {
        return schoolRespository.save(school);
    }

    public void deleteById(Long id) {
        schoolRespository.deleteById(id);
    }
}
