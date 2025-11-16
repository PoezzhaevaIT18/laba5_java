public class MeowCounter {
    // Метод принимает массив мяукающих объектов и вызывает мяуканье у каждого
    public static void makeAllMeow(Meowable[] meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}
