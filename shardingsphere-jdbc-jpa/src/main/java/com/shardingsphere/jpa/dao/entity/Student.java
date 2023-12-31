package com.shardingsphere.jpa.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@Entity
@ToString
public class Student {

    @Id
    private Integer id;

    private Integer age;

    private String name;

}
