package com.schooling;

import com.schooling.entity.*;
import com.schooling.repository.CityRespository;
import com.schooling.repository.CountryRespository;
import com.schooling.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    }
}
