package com.phonepe.isssuemagement.model;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
@Getter
public class Filter {

    private FilterType filterType;
    private String value;

    public Filter(FilterType filterType, String value) {
        this.filterType = filterType;
        this.value = value;
    }
}
