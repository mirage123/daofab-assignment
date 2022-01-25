package com.daofab.assignment.dtos;

import com.daofab.assignment.entities.Parent;
import lombok.Data;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */
@Data
public class ParentJson {

    private List<Parent> data;
}
