package com.example.mike.fantasygame.DragonCastle.HeroList;

public class HeroOption {

    private int imageId;
    private String typeName;
    private String healthPoints;
    private String typeDescription;
    private String move1Description;
    private String move2Description;

    public HeroOption(int imageId, String typeName, String typeDescription, String healthPoints, String move1Description, String move2Description) {
        this.imageId = imageId;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
        this.healthPoints = healthPoints;
        this.move1Description = move1Description;
        this.move2Description = move2Description;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public String getHealthPoints() {
        return healthPoints;
    }

    public String getMove1Description() {
        return move1Description;
    }

    public String getMove2Description() {
        return move2Description;
    }
}
