package com.taghavi.spacexpractice.model;

public class LaunchModel {
    private final LinksModel links;
    private final String name;

    public LaunchModel(LinksModel links, String name) {
        this.links = links;
        this.name = name;
    }

    public LinksModel getLinks() {
        return links;
    }

    public String getName() {
        return name;
    }
}
