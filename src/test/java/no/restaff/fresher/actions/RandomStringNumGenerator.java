package no.restaff.fresher.actions;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomStringNumGenerator {
    public static String generateRandomStringNum() {
        int randomNumber = RandomGenerator.getDefault().nextInt(1,6);
        return String.valueOf(randomNumber);
    }
}
