package com.taghavi.spacexpractice.model;

public class LaunchModel {
    private final LinksModel links;
    private final String name;
    private final Boolean success;
    private final int flight_number;

    public LaunchModel(LinksModel links, String name, Boolean success, int flight_number) {
        this.links = links;
        this.name = name;
        this.success = success;
        this.flight_number = flight_number;
    }

    public LinksModel getLinks() {
        return links;
    }

    public String getName() {
        return name;
    }

    public Boolean getSuccess() {
        return success;
    }

    public int getFlight_number() {
        return flight_number;
    }
}
