package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@MappedSuperclass
public class User extends Base {
    private String name;
    private String family;
    private String username;
    private String password;
    private LocalDate age;
}
