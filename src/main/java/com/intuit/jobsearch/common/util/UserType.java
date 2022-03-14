package com.intuit.jobsearch.common.util;

public enum UserType {
    IND("Individual"),
    COM("Commerical"),
    GOV("Official");

    public final String label;

    private UserType(String label) {
        this.label = label;
    }

}
