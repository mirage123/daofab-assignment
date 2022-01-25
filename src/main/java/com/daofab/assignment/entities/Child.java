package com.daofab.assignment.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author prabesh on 25/Jan/2022
 */

@Entity
@Data
public class Child {

    @Id
    private Integer id;
    private Integer parentId;
    private Integer paidAmount;
}
