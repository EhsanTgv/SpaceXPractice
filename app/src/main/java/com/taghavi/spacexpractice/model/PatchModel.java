package com.taghavi.spacexpractice.model;

public class PatchModel {
    private final String small;
    private final String large;

    public PatchModel(String small, String large) {
        this.small = small;
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }
}
