package com.daofab.assignment.controllers;

import com.daofab.assignment.dtos.ParentResponse;
import com.daofab.assignment.serviceobjects.PageableData;
import com.daofab.assignment.serviceobjects.RestResponse;
import com.daofab.assignment.services.ParentService;
import com.daofab.assignment.utils.FilterUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public RestResponse<List<ParentResponse>> getParents(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                                         @RequestParam(required = false, defaultValue = "2") int size,
                                                         @RequestParam(required = false, defaultValue = "asc") String sortByOrder){
        Pageable pageable = FilterUtils.sortAndPageData(currentPage, size, "id", sortByOrder);
        final PageableData<ParentResponse> parentResponsePageableData = this.parentService.getParents(pageable);
        return RestResponse.oKWithPaginatedPayload(parentResponsePageableData.getData(), parentResponsePageableData.getPaginationInfo(), "Fetched");
    }
}
