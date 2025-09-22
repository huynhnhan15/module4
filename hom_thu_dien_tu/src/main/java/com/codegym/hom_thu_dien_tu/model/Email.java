package com.codegym.hom_thu_dien_tu.model;

import javax.enterprise.inject.Model;

@Model
public class Email {
    private String language;
    private int pageSize;
    private boolean spamsFilter;
    private String signature;

    public Email() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public Email(String language, int pageSize, String signature, boolean spamsFilter) {
        this.language = language;
        this.pageSize = pageSize;
        this.signature = signature;
        this.spamsFilter = spamsFilter;
    }
}
