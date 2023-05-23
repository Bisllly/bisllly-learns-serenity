package no.restaff.fresher.actions;

import java.util.UUID;

public class RandomStringGenerator {
    public static String generateRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
