package com.phonepe.isssuemagement.model;

import lombok.Getter;

import java.util.List;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
@Getter
public class Agent extends User {
    private List<IssueType> issueTypes;

    public Agent(String name, String email, List<IssueType> issueTypes) {
        this.name = name;
        this.email = email;
        this.issueTypes = issueTypes;
    }
}
