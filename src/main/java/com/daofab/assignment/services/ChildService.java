package com.daofab.assignment.services;

import com.daofab.assignment.dtos.ChildResponse;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */
public interface ChildService {
    List<ChildResponse> getChildByParentId(int parentId);
}
