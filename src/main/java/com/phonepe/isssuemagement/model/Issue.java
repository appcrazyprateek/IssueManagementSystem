package com.phonepe.isssuemagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phonepe.isssuemagement.util.IdGenerator;

import java.util.Stack;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class Issue {
    private String id;
    private IssueType issueType;
    private String transactionId;
    private String subject;
    private String description;
    private Customer customer;
    private IssueState issueState;
    @JsonIgnore
    private Stack<Audit> audits = new Stack<>();

    public Issue(String id, IssueType issueType, String transactionId, String subject, String description,
                 Customer customer, IssueState issueState, Stack<Audit> audits) {
        this.id = id;
        this.issueType = issueType;
        this.transactionId = transactionId;
        this.subject = subject;
        this.description = description;
        this.customer = customer;
        this.issueState = issueState;
        this.audits = audits;
    }

    public Issue(String transactionId, IssueType issueType, String subject, String description, String email) {
        this.id = IdGenerator.getInstance()
                             .getIssueId();
        this.issueType = issueType;
        this.transactionId = transactionId;
        this.subject = subject;
        this.description = description;
        this.customer = new Customer(email);
        this.issueState = IssueState.OPEN;
        addAudit(IssueState.OPEN, description);
    }

    public Stack<Audit> addAudit(IssueState issueState, String description) {
        this.audits.push(new Audit(issueState, description));
        return audits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IssueState getIssueState() {
        return issueState;
    }

    public void setIssueState(IssueState issueState) {
        this.issueState = issueState;
    }

    public Stack<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Stack<Audit> audits) {
        this.audits = audits;
    }

}
