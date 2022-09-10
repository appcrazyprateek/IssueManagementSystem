package com.phonepe.isssuemagement.util;

/**
 * @author prathore
 * @date 10/09/22
 * @since 240
 */
public class IdGenerator {

    private static IdGenerator generator;
    private static long count = 0;
    private IdGenerator() {}

    public static IdGenerator getInstance() {
        if(generator == null) {
            generator = new IdGenerator();
        }
        return generator;
    }

    public String getIssueId() {
        count++;
        return "I" + count;
    }

}
