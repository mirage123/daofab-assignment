package com.daofab.assignment.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class FilterUtils {

    private FilterUtils() {
    }

    public static Pageable sortAndPageData(int page, int size, String sortBy, String sortByOrder) {
        page = page <= 1 ? 0 : page - 1;
        size = size <= 0 ? 2 : size;

        Sort.Direction sortOrder = sortByOrder.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        Sort.Order sort = new Sort.Order(sortOrder, sortBy);

        return PageRequest.of(page, size, Sort.by(sort));
    }

}
