package no.restaff.fresher.entity;

import no.restaff.fresher.actions.RandomStringGenerator;

public class Category {
    private long id;
    private String name;
    private String updatedName;

    public Category() {
        this.name = RandomStringGenerator.generateRandomString();
        this.updatedName = RandomStringGenerator.generateRandomString();
    }

    public Category(String name, String updatedName) {
        this.name = name;
        this.updatedName = updatedName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getUpdatedName() {
        return updatedName;
    }
}
