package com.schooleduapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schooleduapp.config.security.model.UserRole;
import com.schooleduapp.entity.audit.Auditable;
import com.schooleduapp.entity.type.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "countryCode", nullable = true)
    private Country country;

    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
