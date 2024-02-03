public class Main {

    public static void main(String[] args) {

        RightPrice.DIFFICULTY = "EASY"; // You can change the difficulty as you want (EASY/NORMAL/HARD)
        RightPrice rpGame = new RightPrice();
        Calculus calcGame = new Calculus();

        rpGame.play();
        //calcGame.play();
    }
}
