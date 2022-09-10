package com.phonepe.isssuemagement.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public enum IssueType {
    PAYMENT_RELATED("Payment Related", "Payment Related"),
    MUTUAL_FUND_RELATED("Mutual Fund Related", "Mutual Fund Related"),
    GOLD_RELATED("Gold Related", "Gold Related"),
    INSURANCE_RELATED("Insurance Related", "Insurance Related");

    private String name;
    private String description;

    IssueType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static IssueType get(String name) {
        return Arrays.stream(IssueType.values())
                     .filter(e -> e.name.equals(name))
                     .findFirst().get();
    }
}
