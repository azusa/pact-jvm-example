package jp.fieldnotes.jjug.pact.provider;

import jp.fieldnotes.jjug.pact.provider.domain.AnimalsEntity;

import java.util.ArrayList;
import java.util.List;

public class Animals {

    private List<Animal> animals = new ArrayList<>();

    public Animals(List<AnimalsEntity> animals) {
        for (AnimalsEntity animal : animals){
            this.animals.add(new Animal(animal.getId(), animal.getName()));
        }
    }

    public List<Animal> getAnimals(){
        return this.animals;
    }


}


