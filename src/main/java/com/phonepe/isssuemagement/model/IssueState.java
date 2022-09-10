package com.phonepe.isssuemagement.model;

import java.util.Arrays;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public enum IssueState {
    OPEN("Open"),
    ASSIGNED("Assigned"),
    IN_PROGRESS("In Progress"),
    RESOLVED("Resolved");

    private String state;
    IssueState(String state) {
        this.state = state;
    }

    public static IssueState get(String state) {
        return Arrays.stream(IssueState.values())
                     .filter(e -> e.state.equals(state))
                     .findFirst().get();
    }
}
