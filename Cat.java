interface Meowable {
    void meow();
}

public class Cat implements Meowable {
    private String name;
    private int meowCount;

    public Cat(String name) {
        this.name = name;
        this.meowCount = 0;
    }

    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
