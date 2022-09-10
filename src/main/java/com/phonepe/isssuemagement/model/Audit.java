package com.phonepe.isssuemagement.model;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class Audit {
    private IssueState issueState;
    private String issueDescription;

    public Audit(IssueState issueState, String issueDescription) {
        this.issueState = issueState;
        this.issueDescription = issueDescription;
    }
}
