# IssueManagementSystem

https://app.codesignal.com/live-interview/ceJvtdccQu3NT9GZ9

Console Output : 

Issue I1 created against transaction T1
Issue I2 created against transaction T2
Issue I3 created against transaction T3
Agent 1 created
Agent 2 created
Issue I1 assigned to Agent 1 Status ASSIGNED
Issue I2 assigned to Agent 2 Status ASSIGNED
Issue I3 assigned to Agent 1 Status WAITLIST
[{"id":"I2","issueType":"MUTUAL_FUND_RELATED","transactionId":"T2","subject":"Purchase Failed","description":"Unable to purchase Mutual Fund","customer":{"id":0,"name":null,"email":"testUser2@test.com"},"issueState":"OPEN"},{"id":"I3","issueType":"PAYMENT_RELATED","transactionId":"T3","subject":"Payment Failed","description":"My payment failed but money is debited","customer":{"id":0,"name":null,"email":"testUser2@test.com"},"issueState":"OPEN"}]
[{"id":"I1","issueType":"PAYMENT_RELATED","transactionId":"T1","subject":"Payment Failed","description":"My payment failed but money is debited","customer":{"id":0,"name":null,"email":"testUser1@test.com"},"issueState":"OPEN"},{"id":"I3","issueType":"PAYMENT_RELATED","transactionId":"T3","subject":"Payment Failed","description":"My payment failed but money is debited","customer":{"id":0,"name":null,"email":"testUser2@test.com"},"issueState":"OPEN"}]
I3status changed to IN_PROGRESS
I3status changed toRESOLVED
{"User{name='Agent 2', email='agent2@test.com'}":[{"id":"I2","issueType":"MUTUAL_FUND_RELATED","transactionId":"T2","subject":"Purchase Failed","description":"Unable to purchase Mutual Fund","customer":{"id":0,"name":null,"email":"testUser2@test.com"},"issueState":"OPEN"}],"User{name='Agent 1', email='agent1@test.com'}":[{"id":"I1","issueType":"PAYMENT_RELATED","transactionId":"T1","subject":"Payment Failed","description":"My payment failed but money is debited","customer":{"id":0,"name":null,"email":"testUser1@test.com"},"issueState":"OPEN"},{"id":"I3","issueType":"PAYMENT_RELATED","transactionId":"T3","subject":"Payment Failed","description":"My payment failed but money is debited","customer":{"id":0,"name":null,"email":"testUser2@test.com"},"issueState":"RESOLVED"}]}
