package com.daofab.assignment.services;

import com.daofab.assignment.dtos.ParentResponse;
import com.daofab.assignment.repositories.ParentRepository;
import com.daofab.assignment.serviceobjects.PageableData;
import com.daofab.assignment.serviceobjects.PaginationInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author prabesh on 25/Jan/2022
 */

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public PageableData<ParentResponse> getParents(Pageable pageable) {
        final Page<ParentResponse> parentResponsePage = this.parentRepository.findParents(pageable);
        return new PageableData<>(preparePaginationInfo(parentResponsePage), parentResponsePage.getContent());
    }
    public PaginationInfo preparePaginationInfo(Page<ParentResponse> pageData) {
        return new PaginationInfo(pageData.getNumber() + 1, pageData.getSize(), pageData.getTotalElements(), pageData.getTotalPages());
    }
}
