package com.phonepe.isssuemagement.model;

import java.util.Arrays;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public enum FilterType {
    EMAIL("email"),
    ISSUE_TYPE("type");

    private String filter;
    private FilterType(String filter) {
        this.filter = filter;
    }

    public static FilterType get(String filter) {
        return Arrays.stream(FilterType.values())
                     .filter(e -> e.filter.equals(filter))
                     .findFirst().get();
    }
 }
