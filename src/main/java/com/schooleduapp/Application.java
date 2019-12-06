package com.schooleduapp;

import com.schooleduapp.config.security.model.UserRole;
import com.schooleduapp.entity.*;
import com.schooleduapp.entity.type.*;
import com.schooleduapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner
{

    @Autowired
    private CityRespository cityRespository;

    @Autowired
    private CountryRespository countryRespository;

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private CourseRespository courseRespository;

    @Autowired
    private SchoolRespository schoolRespository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Country country = new Country();
        country.setName("Brazil");
        country.setCode("BRL");
        country.setContinentName("South America");
        countryRespository.save(country);

        City city = new City();
        city.setName("Sao Paulo");
        city.setCountry(country);
        cityRespository.save(city);

        City city2 = new City();
        city2.setName("Rio de Janeiro");
        city2.setCountry(country);
        cityRespository.save(city2);

        User user = new User();
        user.setName("Gustavo");
        user.setSurname("Rodrigues");
        user.setPassword("ab123");
        user.setCountry(country);
        user.setBirthdate(new Date());
        user.setEmail("gustavo.rodrigues@msn.com");
        user.setGender(Gender.MALE);
        user.setUserRole(UserRole.SYSTEM_ADMIN);
        userRespository.save(user);

        School school = new School();
        school.setName("Learn Yeahh School");
        school.setAddress("5th Avenue - City Centre");
        school.setCity(city);
        school.setUser(user);

        Course course = new Course();
        course.setName("General English");
        course.setType(CourseType.LANGUAGE);
        course.setLanguage(Language.ENGLISH);
        course.setPeriod(CoursePeriod.MORNING);
        course.setDuration(CourseDuration.SIX_MONTHS);
        course.setPrice(new BigDecimal("1000.00"));
        course.setStartFrom(new Date());
        course.setStatus(CourseStatus.OPEN);
        course.setSchool(school);

        Course courseSpanish = new Course();
        courseSpanish.setName("General Spanish");
        courseSpanish.setType(CourseType.LANGUAGE);
        courseSpanish.setLanguage(Language.SPANISH);
        courseSpanish.setPeriod(CoursePeriod.NIGHT);
        courseSpanish.setDuration(CourseDuration.ONE_MONTH);
        courseSpanish.setPrice(new BigDecimal("1000.00"));
        courseSpanish.setStartFrom(new Date());
        courseSpanish.setStatus(CourseStatus.CLOSED);
        courseSpanish.setSchool(school);

        school.addCourse(courseSpanish);

        schoolRespository.save(school);

        //courseRespository.save(course);

    }
}
