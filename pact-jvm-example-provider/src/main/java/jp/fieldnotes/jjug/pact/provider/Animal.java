package jp.fieldnotes.jjug.pact.provider;

public class Animal {

    private Number id;

    private String name;

    public Animal(Number id,String name) {
        this.id = id;
        this.name = name;
    }

    public Number getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
