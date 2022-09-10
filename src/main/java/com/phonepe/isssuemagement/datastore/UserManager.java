package com.phonepe.isssuemagement.datastore;

import com.phonepe.isssuemagement.model.*;

import java.util.*;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class UserManager {

    public static UserManager userManager;

    public static UserManager getInstance() {
        if(userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }
    
    private List<User> agents = new ArrayList<>();
    private Map<User,List<Issue>> agentToIssueMapping = new HashMap<>();

    public User addAgent(String name, String email, List<IssueType> issueTypes) {
        User agent =  new Agent(name, email, issueTypes);
        agents.add(agent);
        return agent;
    }

    public Map<User,List<Issue>> viewAgentsWorkHistory () {
        return agentToIssueMapping;
    }

    public IssueAssignmentStatus assignIssue(String name, String email, String issueId) {
        User user = getUser(email);
        if(Objects.isNull(user))
            return IssueAssignmentStatus.REJECTED;

        IssueAssignmentStatus status =  null;
        Issue issue = IssueManager.getInstance().issueById(issueId);
        List<Issue> issues = agentToIssueMapping.get(user);
        if(Objects.isNull(issues)) {
            issues = new ArrayList<>();
            status = IssueAssignmentStatus.ASSIGNED;
        } else {
            status = IssueAssignmentStatus.WAITLIST;
        }
        issues.add(issue);
        agentToIssueMapping.put(user, issues);
        return status;
    }

    private User getUser(String email) {
        for(User agent : agents) {
            if(agent.getEmail().equals(email))
                return agent;
        }
        return null;
    }
}
