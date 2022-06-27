package com.rajkumar.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Vote extends Auditable {

    @Id
    @GeneratedValue
    private Long id;
    private int vote;

}
