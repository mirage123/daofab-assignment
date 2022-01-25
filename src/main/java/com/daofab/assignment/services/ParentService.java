package com.daofab.assignment.services;

import com.daofab.assignment.dtos.ParentResponse;
import com.daofab.assignment.serviceobjects.PageableData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author prabesh on 25/Jan/2022
 */
public interface ParentService {
    PageableData<ParentResponse> getParents(Pageable pageable);
}
