package utils;

import java.util.Random;

public class RandomData {
    static String[] cities = {"Boston","Berlin","Paris","Rome"};
    static String[] states = {"NY","CA","TX","FL"};

    public static String randomName() { return "User" + new Random().nextInt(1000); }
    public static String randomAddress() { return "Street " + new Random().nextInt(100); }
    public static String randomCity() { return cities[new Random().nextInt(cities.length)]; }
    public static String randomState() { return states[new Random().nextInt(states.length)]; }
    public static String randomZip() { return String.valueOf(10000 + new Random().nextInt(90000)); }
    public static String randomCard() { return String.valueOf(4000000000000000L + new Random().nextInt(99999999)); }
    public static String randomMonth() { return String.valueOf(1 + new Random().nextInt(12)); }
    public static String randomYear() { return String.valueOf(2025 + new Random().nextInt(5)); }
    public static boolean randomRememberMe() { return new Random().nextBoolean(); }
}
