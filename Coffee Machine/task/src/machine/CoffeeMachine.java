package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner sc = new Scanner(System.in);

    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int coffeeAmount = 120;
    private static int cupsAmount = 9;
    private static int moneyAmount = 550;

    private static final int CUPS_FOR_COFFEE = 1;

    private static final int WATER_FOR_ESPRESSO = 250;
    private static final int MILK_FOR_ESPRESSO = 0;
    private static final int COFFEE_FOR_ESPRESSO = 16;
    private static final int MONEY_FOR_ESPRESSO = 4;

    private static final int WATER_FOR_LATTE = 350;
    private static final int MILK_FOR_LATTE = 75;
    private static final int COFFEE_FOR_LATTE = 20;
    private static final int MONEY_FOR_LATTE = 7;

    private static final int WATER_FOR_CAPPUCCINO = 200;
    private static final int MILK_FOR_CAPPUCCINO = 100;
    private static final int COFFEE_FOR_CAPPUCCINO = 12;
    private static final int MONEY_FOR_CAPPUCCINO = 6;

    public static void main(String[] args) {

        executeActionLoop();
    }

    private static void executeActionLoop() {

        switch (getUserInputAction()) {
            case 1:
                giveCoffeeToUser();
                executeActionLoop();
                break;
            case 2:
                fillTheMachine(getUserInputWater(), getUserInputMilk(), getUserInputCoffee(), getUserInputCups());
                executeActionLoop();
                break;
            case 3:
                giveMoney();
                executeActionLoop();
                break;
            case 4:
                printMachineStatus();
                executeActionLoop();
                break;
            case 5:
                break;
            default:
                System.out.println("Error: invalid input\n");
                executeActionLoop();
                break;
        }
    }

    private static void printMachineStatus() {
        System.out.println("\nThe coffee machine has:\n" + waterAmount + " of water\n" + milkAmount + " of milk\n" + coffeeAmount + " of coffee beans\n" + cupsAmount + " of disposable cups\n" + moneyAmount + " of money\n");
    }

    private static int getUserInputAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = sc.next();
        switch (action) {
            case "buy":
                return 1;
            case "fill":
                return 2;
            case "take":
                return 3;
            case "remaining":
                return 4;
            case "exit":
                return 5;
            default:
                return 0;
        }
    }

    private static void giveMoney() {

        System.out.println("I gave you $" + moneyAmount + "\n");
        moneyAmount -= moneyAmount;
    }

    private static void fillTheMachine(int water, int milk, int coffee, int cups) {

        waterAmount += water;
        milkAmount += milk;
        coffeeAmount += coffee;
        cupsAmount += cups;
    }

    private static int getUserInputWater() {
        System.out.println("Write how many ml of water do you want to add:");

        int water;
        try {
            water = sc.nextInt();
            return water;
        } catch (InputMismatchException e) {
            System.out.println("Error: invalid value of water");
            return 0;
        }
    }

    private static int getUserInputMilk() {
        System.out.println("Write how many ml of milk do you want to add:");

        int milk;
        try {
            milk = sc.nextInt();
            return milk;
        } catch (InputMismatchException e) {
            System.out.println("Error: invalid value of milk");
            return 0;
        }
    }

    private static int getUserInputCoffee() {
        System.out.println("Write how many grams of coffee beans do you want to add:");

        int coffee;
        try {
            coffee = sc.nextInt();
            return coffee;
        } catch (InputMismatchException e) {
            System.out.println("Error: invalid value of coffee beans");
            return 0;
        }
    }

    private static int getUserInputCups() {
        System.out.println("Write how many cups of coffee do you want to add:");

        int cups;
        try {
            cups = sc.nextInt();
            return cups;
        } catch (InputMismatchException e) {
            System.out.println("Error: invalid value of cups");
            return 0;
        }
    }

    private static int getUserInputProduct() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        switch (sc.next()) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "back":
                return 4;
            default:
                return 0;
        }
    }

    private static void giveCoffeeToUser() {
        switch (getUserInputProduct()) {
            case 1:
                makeOneCupOfEspresso(checkIngredientsForEspresso());
                break;
            case 2:
                makeOneCupOfLatte(checkIngredientsForLatte());
                break;
            case 3:
                makeOneCupOfCappuccino(checkIngredientsForCappuccino());
                break;
            case 4:
                break;
            case 0:
                System.out.println("\nError: Invalid input of product");
                break;
            default:
                System.out.println("\nOops, something went wrong :(");
        }
    }

    private static int checkIngredientsForEspresso() {

        if (waterAmount < WATER_FOR_ESPRESSO) {
            return 1;
        } else if (milkAmount < MILK_FOR_ESPRESSO) {
            return 2;
        } else if (coffeeAmount < COFFEE_FOR_ESPRESSO) {
            return 3;
        } else if (cupsAmount < 1) {
            return 4;
        }
        else {
            return 0;
        }
    }

    private static int checkIngredientsForLatte() {

        if (waterAmount < WATER_FOR_LATTE) {
            return 1;
        } else if (milkAmount < MILK_FOR_LATTE) {
            return 2;
        } else if (coffeeAmount < COFFEE_FOR_LATTE) {
            return 3;
        } else if (cupsAmount < 1) {
            return 4;
        }
        else {
            return 0;
        }
    }

    private static int checkIngredientsForCappuccino() {

        if (waterAmount < WATER_FOR_CAPPUCCINO) {
            return 1;
        } else if (milkAmount < MILK_FOR_CAPPUCCINO) {
            return 2;
        } else if (coffeeAmount < COFFEE_FOR_CAPPUCCINO) {
            return 3;
        } else if (cupsAmount < 1) {
            return 4;
        }
        else {
            return 0;
        }
    }

    private static void makeOneCupOfEspresso(int checkResult) {

        switch (checkResult) {

            case 1:
                System.out.println("Sorry, not enough water!\n");
                break;
            case 2:
                System.out.println("Sorry, not enough milk!\n");
                break;
            case 3:
                System.out.println("Sorry, not enough coffee beans!\n");
                break;
            case 4:
                System.out.println("Sorry, not enough disposable cups!\n");
                break;
            case 0:
                System.out.println("I have enough resources, making you a coffee!\n");
                waterAmount -= WATER_FOR_ESPRESSO;
                coffeeAmount -= COFFEE_FOR_ESPRESSO;
                cupsAmount -= CUPS_FOR_COFFEE;
                moneyAmount += MONEY_FOR_ESPRESSO;
                break;
            default:
                System.out.println("\nOops, something went wrong :(");
        }
    }

    private static void makeOneCupOfLatte (int checkResult) {

        switch (checkResult) {

            case 1:
                System.out.println("Sorry, not enough water!\n");
                break;
            case 2:
                System.out.println("Sorry, not enough milk!\n");
                break;
            case 3:
                System.out.println("Sorry, not enough coffee beans!\n");
                break;
            case 4:
                System.out.println("Sorry, not enough disposable cups!\n");
                break;
            case 0:
                System.out.println("I have enough resources, making you a coffee!\n");
                waterAmount -= WATER_FOR_LATTE;
                milkAmount -= MILK_FOR_LATTE;
                coffeeAmount -= COFFEE_FOR_LATTE;
                cupsAmount -= CUPS_FOR_COFFEE;
                moneyAmount += MONEY_FOR_LATTE;
                break;
            default:
                System.out.println("\nOops, something went wrong :(");
        }
    }

    private static void makeOneCupOfCappuccino (int checkResult) {

        switch (checkResult) {

            case 1:
                System.out.println("Sorry, not enough water!\n");
                break;
            case 2:
                System.out.println("Sorry, not enough milk!\n");
                break;
            case 3:
                System.out.println("Sorry, not enough coffee beans!\n");
                break;
            case 4:
                System.out.println("Sorry, not enough disposable cups!\n");
                break;
            case 0:
                System.out.println("I have enough resources, making you a coffee!\n");
                waterAmount -= WATER_FOR_CAPPUCCINO;
                milkAmount -= MILK_FOR_CAPPUCCINO;
                coffeeAmount -= COFFEE_FOR_CAPPUCCINO;
                cupsAmount -= CUPS_FOR_COFFEE;
                moneyAmount += MONEY_FOR_CAPPUCCINO;
                break;
            default:
                System.out.println("\nOops, something went wrong :(");
        }
    }

    /*private static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }*/

}