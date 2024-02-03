import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Calculus implements Game {
    public static Random GENERATOR = new Random();
    private final Scanner inputChecker = new Scanner(System.in);
    private int number1;
    private int number2;

    public Calculus() {
        this.number1 = GENERATOR.nextInt(10) + 1;
        this.number2 = GENERATOR.nextInt(10) + 1;
    }

    @Override
    public void play() {
        int score = 0;
        int total = 0;

        for (int turn = 0; turn < 5; turn++) {
            this.number1 = GENERATOR.nextInt(10) + 1;
            this.number2 = GENERATOR.nextInt(10) + 1;
            total++;

            if (randomSelect().equals("Sum")) {
                System.out.println(this.number1 + " + " + this.number2 + " ?");
                int inputResult = inputChecker.nextInt();
                if (sumTest(inputResult)) {
                    score++;
                }
            }

            else if (randomSelect().equals("Subtract")) {
                System.out.println(this.number1 + " - " + this.number2 + " ?");
                int inputResult = inputChecker.nextInt();
                if (subtractTest(inputResult)) {
                    score++;
                }
            }

            else {
                System.out.println(this.number1 + " x " + this.number2 + " ?");
                int inputResult = inputChecker.nextInt();
                if (scaleTest(inputResult)) {
                    score++;
                }
            }
        }
        System.out.println("You got " + score + "/" + total);
        wantRetry();
        inputChecker.close();
    }

    @Override
    public void wantRetry() {
        System.out.println("Do you want retry ?");
        System.out.println("1 : YES // 2 : NO");
        int inputNumber = inputChecker.nextInt();
        if (inputNumber == 1) {
            Calculus newGame = new Calculus();
            newGame.play();
        }
        inputChecker.close();
    }

    private String randomSelect() {
        int selector = GENERATOR.nextInt(3);
        List<String> selectionList = new ArrayList<>(List.of("Sum","Subtract","Scale"));
        if (selectionList.get(selector).equals("Sum")) {
            return "Sum";
        }
        else if (selectionList.get(selector).equals("Subtract")) {
            return "Subtract";
        }
        return "Scale";
    }

    private int sum(int number1, int number2) {
        return number1 + number2;
    }

    private int subtract(int number1, int number2) {
        return number1 - number2;
    }

    private int scale(int number1, int number2) {
        return number1 * number2;
    }

    private boolean sumTest(int result) {
        if (result == sum(this.number1, this.number2)) {
            System.out.println("Nice !");
            return true;
        }
        System.out.println("You're wrong.");
        return false;
    }

    private boolean subtractTest(int result) {
        if (result == subtract(this.number1, this.number2)) {
            System.out.println("Nice !");
            return true;
        }
        System.out.println("You're wrong.");
        return false;
    }

    private boolean scaleTest(int result) {
        if (result == scale(this.number1, this.number2)) {
            System.out.println("Nice !");
            return true;
        }
        System.out.println("You're wrong.");
        return false;
    }
}
