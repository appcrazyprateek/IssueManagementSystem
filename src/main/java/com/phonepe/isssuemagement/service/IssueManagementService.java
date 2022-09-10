package com.phonepe.isssuemagement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.phonepe.isssuemagement.datastore.IssueManagementProxy;

import java.util.Arrays;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class IssueManagementService {

    public static void main(String[] args) throws JsonProcessingException {
        IssueManagementProxy proxy = new IssueManagementProxy();

        proxy.createIssue("T1",
                                 "Payment Related",
                                 "Payment Failed",
                                 "My payment failed but money is debited",
                                 "testUser1@test.com");

        proxy.createIssue("T2",
                                 "Mutual Fund Related",
                                 "Purchase Failed",
                                 "Unable to purchase Mutual Fund",
                                 "testUser2@test.com");


        proxy.createIssue("T3",
                                 "Payment Related",
                                 "Payment Failed",
                                 "My payment failed but money is debited",
                                 "testUser2@test.com");

        proxy.addAgent("agent1@test.com", "Agent 1", Arrays.asList("Payment Related", "Gold Related"));
        proxy.addAgent("agent2@test.com", "Agent 2", Arrays.asList("Payment Related"));



        proxy.assignIssue("agent1@test.com", "Agent 1", "I1");
        proxy.assignIssue("agent2@test.com", "Agent 2", "I2");
        proxy.assignIssue("agent1@test.com", "Agent 1", "I3");

        proxy.getIssue("email", "testUser2@test.com");
        proxy.getIssue("type", "Payment Related");

        proxy.updateIssue("I3", "In Progress", "Waiting for payment confirmation");
        proxy.resolveIssue("I3", "PaymentFailed debited amount will get reversed");

        proxy.viewAgentsWorkHistory();

    }
}
