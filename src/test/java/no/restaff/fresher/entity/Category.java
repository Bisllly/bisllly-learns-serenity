package no.restaff.fresher.entity;

public class Category {
    private long id;
    private String name;
    public Category() {
    }
    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
