package org.example.formulaire.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cat {
    private final String name;
    private final LocalDate birthDate;
    private final CatRace catRace;
    private final FoodType foodType;
    private List<Cat> catList = new ArrayList<>();

    public Cat(String name, LocalDate birthDate, CatRace catRace, FoodType foodType) {
        this.name = name;
        this.birthDate = birthDate;
        this.catRace = catRace;
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public CatRace getCatRace() {
        return catRace;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public List<Cat> getCatList() {
        return catList;
    }
}
