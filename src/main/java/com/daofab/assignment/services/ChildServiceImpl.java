package com.daofab.assignment.services;

import com.daofab.assignment.dtos.ChildResponse;
import com.daofab.assignment.repositories.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public List<ChildResponse> getChildByParentId(int parentId) {
        return this.childRepository.findChildByParentId(parentId);

    }
}
