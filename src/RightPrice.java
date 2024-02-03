import java.util.Random;
import java.util.Scanner;

public class RightPrice implements Game{
    public static Random GENERATOR = new Random();
    public static String DIFFICULTY;
    private final Scanner inputChecker = new Scanner(System.in);
    private final int price;
    private int tries;
    private boolean rightPrice;

    public RightPrice() {
        this.price = GENERATOR.nextInt(1000) + 1;
        if (DIFFICULTY == "EASY") {
            this.tries = 15;
        }
        if (DIFFICULTY == "NORMAL") {
            this.tries = 10;
        }
        if (DIFFICULTY == "HARD") {
            this.tries = 6;
        }
    }

    @Override
    public void play() {
        while (this.tries > 0) {
            System.out.println("Tries left : " + this.tries);
            System.out.print("Enter a price : ");
            int inputPrice = inputChecker.nextInt(); //Check the INT input in the previous line.

            this.tries = this.tries - 1;
            if (isRightPrice(inputPrice) == true) {
                System.out.println("Congrats ! You got the RIGHT PRICE !");
                break;
            }
            if (this.tries == 0) {
                System.out.println("You lose... you can try again.");
            }
        }
        wantRetry();
        inputChecker.close();
    }

    @Override
    public void wantRetry() {
        System.out.println("Do you want retry ?");
        System.out.println("1 : YES // 2 : NO");
        int inputNumber = inputChecker.nextInt();
        if (inputNumber == 1) {
            RightPrice newGame = new RightPrice();
            newGame.play();
        }
        inputChecker.close();
    }

    private boolean isRightPrice(int number) {
        if (number == this.price) {
            this.rightPrice = true;
        }
        else {
            System.out.println((number != this.price) && (number > this.price) ? "LESS !" : "MORE !");
            this.rightPrice = false;
        }
        return this.rightPrice;
    }

}
