package com.phonepe.isssuemagement.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonepe.isssuemagement.model.*;

import java.util.*;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class IssueManagementProxy {

    public static UserManager userManager;
    public static IssueManager issueManager;

    public IssueManagementProxy() {
         userManager = UserManager.getInstance();
         issueManager = IssueManager.getInstance();
    }

    public String createIssue(String transactionId, String issueTypeStr, String subject, String description, String email) {
        Issue issue = issueManager.createIssue(transactionId, issueTypeStr, subject, description, email);
        System.out.println("Issue "+issue.getId() +" created against transaction "+transactionId);
        return "Issue "+issue.getId() +" created against transaction "+transactionId;
    }

    public String addAgent(String email, String name, List<String> issuseTypeNames) {
        List<IssueType> issueTypes = new ArrayList<>()
;        for(String issuseTypeName : issuseTypeNames) {
            IssueType issueType = IssueType.get(issuseTypeName);
            if(Objects.nonNull(issueType))
              issueTypes.add(issueType);
        }
        User user = userManager.addAgent(name, email, issueTypes);
        System.out.println(user.getName() + " created");
        return user.getName() + " created";
    }

    public String assignIssue(String email, String name, String issueId) {
        IssueAssignmentStatus issueAssignmentStatus = userManager.assignIssue(name, email, issueId);
        System.out.println("Issue " + issueId + " assigned to " + name + " Status " + issueAssignmentStatus.toString());
        return "Issue " + issueId + " assigned to " + name + " Status " + issueAssignmentStatus.toString();
    }

    public String getIssue(String filtername, String filterValue) throws JsonProcessingException {
        Filter f = new Filter(FilterType.get(filtername), filterValue);
        List<Issue> issues = issueManager.getIssue(f);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(issues));
        return mapper.writeValueAsString(issues);
    }

    public String updateIssue(String issueId, String issueState, String auditDescription) {
        Issue issue = issueManager.updateIssue(issueId, IssueState.get(issueState), auditDescription);
        System.out.println(issueId + "status changed to " + issue.getIssueState().name());
        return issueId + "status changed to " + issue.getIssueState().name();
    }

    public String resolveIssue(String issueId, String description) {
        final Issue issue = issueManager.resolveIssue(issueId, description);
        System.out.println(issueId + "status changed to" + issue.getIssueState());
        return issueId + "status changed to " + issue.getIssueState();
    }

    public String viewAgentsWorkHistory() throws JsonProcessingException {
        Map<User, List<Issue>> userListMap = userManager.viewAgentsWorkHistory();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(userListMap));
        return mapper.writeValueAsString(userListMap);
    }
}
