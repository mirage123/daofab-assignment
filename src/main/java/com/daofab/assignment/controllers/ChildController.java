package com.daofab.assignment.controllers;

import com.daofab.assignment.dtos.ChildResponse;
import com.daofab.assignment.serviceobjects.RestResponse;
import com.daofab.assignment.services.ChildService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */

@RestController
@RequestMapping("/api/child")
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/{parentId}")
    public RestResponse<List<ChildResponse>> getChildByParentId(@PathVariable int parentId){
        return RestResponse.okWithPayload(this.childService.getChildByParentId(parentId), "Fetched");

    }
}
