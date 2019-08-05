package model;

public enum UnoCardColour {

    RED, YELLOW, GREEN, BLUE, WILD, WILD_FOUR;

    @Override
    public String toString() {

        switch (this) {
            case RED:
                return "Red";
            case YELLOW:
                return "Yellow";
            case GREEN:
                return "Green";
            case BLUE:
                return "Blue";
            case WILD:
                return "Wild";
            case WILD_FOUR:
                return "Wild Four";
        }
        return null;
    }

    public int toPoints() {
        switch (this) {
            case WILD:
                return 50;
            case WILD_FOUR:
                return 50;
        }
        return 0;
    }
}
