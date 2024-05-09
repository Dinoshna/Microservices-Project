package com.web.sample.poc.dm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="EMP_INFO")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String role;
    private String domain;
    private String skillSet;
    private String education;
}
