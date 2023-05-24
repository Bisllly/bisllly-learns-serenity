package no.restaff.fresher.entity;

import no.restaff.fresher.actions.RandomStringGenerator;

public class BaseNominationObject {
    private Long id;
    private String name;
    private String templateCategory;
    private String templateSubscription;

    public BaseNominationObject(String templateCategory, String templateSubscription) {
        this.name = RandomStringGenerator.generateRandomString();
        this.templateCategory = templateCategory;
        this.templateSubscription = templateSubscription;
    }

    public String getName() {
        return name;
    }

    public String getTemplateCategory() {
        return templateCategory;
    }

    public String getTemplateSubscription() {
        return templateSubscription;
    }
}
