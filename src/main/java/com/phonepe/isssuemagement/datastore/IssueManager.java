package com.phonepe.isssuemagement.datastore;

import com.phonepe.isssuemagement.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class IssueManager {

    public static IssueManager issueManager;

    public static IssueManager getInstance() {
        if(issueManager == null) {
            issueManager = new IssueManager();
        }
        return issueManager;
    }

    private List<Issue> issues = new ArrayList<>();

    public Issue createIssue(String transactionId, String issueTypeStr, String subject, String description, String email) {
        IssueType issueType = IssueType.get(issueTypeStr);
        Issue issue = new Issue(transactionId, issueType, subject, description, email);
        issues.add(issue);
        return issue;
    }

    public List<Issue> getIssue(Filter filter) {
        List<Issue> result = new ArrayList<>();
        switch (filter.getFilterType()) {
            case EMAIL :
                result = getIssueByEmail(filter.getValue());
                break;
            case ISSUE_TYPE:
                result = getIssueByType(IssueType.get(filter.getValue()));
                break;
        }
        return result;
    }

    private List<Issue> getIssueByEmail(String email) {
        List<Issue> result = new ArrayList<>();
        for(Issue issue : issues) {
            if(issue.getCustomer().getEmail().equalsIgnoreCase(email)) {
                result.add(issue);
            }
        }
        return result;
    }

    private List<Issue> getIssueByType(IssueType issueType) {
        List<Issue> result = new ArrayList<>();
        for(Issue issue : issues) {
            if(issue.getIssueType().equals(issueType)) {
                result.add(issue);
            }
        }
        return result;
    }


    public Issue updateIssue(String issueId, IssueState issueState, String auditDescription) {
        Issue issue = issueById(issueId);
        issue.setIssueState(issueState);
        issue.addAudit(issueState, auditDescription);
        return issue;
    }

    public Issue resolveIssue(String issueId, String auditDescription) {
        Issue issue = issueById(issueId);
        issue.setIssueState(IssueState.RESOLVED);
        issue.addAudit(IssueState.RESOLVED, auditDescription);
        return issue;
    }

    public Issue issueById(String issueId) {
        for(Issue issue : issues) {
            if(issue.getId().equalsIgnoreCase(issueId)) {
                return issue;
            }
        }
        return null;
    }
}
