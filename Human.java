public class Human {
    private int totalMeowCount = 0;

    public void makeMeow(Cat cat) {
        cat.meow();
        totalMeowCount++;
    }

    public int getTotalMeowCount() {
        return totalMeowCount;
    }
}
