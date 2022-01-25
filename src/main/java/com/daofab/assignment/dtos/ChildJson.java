package com.daofab.assignment.dtos;

import com.daofab.assignment.entities.Child;
import lombok.Data;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */
@Data
public class ChildJson {
    private List<Child> data;
}
