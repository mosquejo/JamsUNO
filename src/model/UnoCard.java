package model;

import interfaces.Card;

public class UnoCard implements Card{
    
    private UnoCardColour colour;
    private UnoCardValue value;

    public UnoCard(UnoCardColour colour, UnoCardValue value) {
        if(colour == UnoCardColour.WILD || colour == UnoCardColour.WILD_FOUR){
            this.colour = colour;
            this.value = UnoCardValue.ONE;
        }
        else {
            this.colour = colour;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        if (this.colour == UnoCardColour.WILD || this.colour == UnoCardColour.WILD_FOUR)
            return colour.toString();
        else
            return colour.toString() + " " + value.toString();
    }

    public UnoCardColour getColour() {
        return colour;
    }

    public UnoCardValue getValue() {
        return value;
    }
    
    @Override
    public int getCardPoints() {
        if (this.colour == UnoCardColour.WILD || this.colour == UnoCardColour.WILD_FOUR)
            return this.colour.toPoints();
        else {
            return this.value.toPoints();
        }
    }
    
    public void setColour(UnoCardColour colour) {
        this.colour = colour;
    }

    public void setValue(UnoCardValue value) {
        this.value = value;
    }
    
}
