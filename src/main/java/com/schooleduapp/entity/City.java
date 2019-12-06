package com.schooleduapp.entity;

import com.schooleduapp.entity.audit.Auditable;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class City extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_code", foreignKey = @ForeignKey(name = "FK_COUNTRY_CITY"))
    private Country country;
}
