package com.intuit.jobsearch.common.util;

public enum UserType {
    IND("Individual"),
    COM("Commerical"),
    OFF("Official");

    public final String value;

    private UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
