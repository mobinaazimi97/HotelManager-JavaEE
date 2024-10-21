package com.mftplus.jee03practice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString

@MappedSuperclass
public class Base {
    @Version
    @JsonIgnore
    private Long versionId;
    @JsonIgnore
    private boolean editing = false;
    @JsonIgnore
    private boolean deleted = false;
}
