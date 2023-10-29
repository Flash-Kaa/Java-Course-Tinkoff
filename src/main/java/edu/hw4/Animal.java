package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    private final static int FISH_PAWS_COUNT = 0;
    private final static int BIRD_PAWS_COUNT = 2;
    private final static int DOG_AND_CAT_PAWS_COUNT = 4;
    private final static int SPIDERS_PAWS_COUNT = 8;

    public int paws() {
        return switch (type) {
            case CAT, DOG -> DOG_AND_CAT_PAWS_COUNT;
            case BIRD -> BIRD_PAWS_COUNT;
            case FISH -> FISH_PAWS_COUNT;
            case SPIDER -> SPIDERS_PAWS_COUNT;
        };
    }

    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Sex {
        M, F
    }
}
