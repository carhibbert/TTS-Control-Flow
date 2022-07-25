import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class AsciiChars {

    // Print numbers 1-9 
    public static void printNumbers(){
    
        for (int i =1; i<=9; i++){
            System.out.print(i);
        }
        System.out.println();
    }

    // Print all lowercase letters in alphabetical order
    public static void printLowerCase() {
    
        for (char i = 'a'; i<='z'; i++){
            System.out.print(i);
        }
        System.out.println();
    }

    // Print all uppercase letters in alphabetical order
    public static void printUpperCase(){
        for(char i = 'A'; i<='Z'; i++){
            System.out.print(i);
        }
        System.out.println();
    }

    // Class to check if user input is "yes" or "y"
    public static boolean checkInput(String value){
        return value.equals("yes") || value.equals("y") || value.equals("Yes");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        AsciiChars.printNumbers();
        AsciiChars.printUpperCase();
        AsciiChars.printLowerCase();

        // Populate an arrayList of questions to ask the user

        ArrayList<String> questions = new ArrayList<String>();
            questions.add("Do you have a red car? (yes,no)");           //0
            questions.add("What is the name of your favorite pet?");    //1
            questions.add("What is the age of your favorite pet?");     //2
            questions.add("What is your lucky number?");                //3
            questions.add("Enter a random number between 1 and 50.");   //4
            questions.add("What is the two digit model year of your car?");     //5
        
        // Create an arrayList to store the anwers to above questions

        ArrayList<String> answers = new ArrayList<String>();


        // Ask the user for their name
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello "+ name + ". Do you wish to continue with the interactive portion?");
        String answer = scanner.nextLine();
        
        // If yes or y, continue -
        if(checkInput(answer)){

            boolean playAgain = false;

            do{
            // Cycle through the questions ArrayList and ask each question
            for(int i= 0; i<questions.size(); i++){
                System.out.println(questions.get(i));
                answers.add(scanner.nextLine());
            }
        

        // Generate random numbers 
        Random num = new Random();
        int randomNum1 = num.nextInt(100) +1; 
        int randomNum2 = num.nextInt(100) +1;

        // Magic ball = lucky number multiplied by random number
        int magicBall = Integer.valueOf(answers.get(3))*randomNum1;
        
        //If value of magicBall is greater than 75, Subtract 75 and set value to magicBall
        while( magicBall > 75) {
            magicBall = magicBall-75;
        }

        int[] lotteryNums = new int[5];
        // Index 0 = 3rd letter of pet name
        lotteryNums[0] = (int) answers.get(1).charAt(2);
        while( lotteryNums[0] > 65 || lotteryNums[0] < 1) {
            if(lotteryNums[0] >65){
            lotteryNums[0] = lotteryNums[0] - 65;
            }
            else { lotteryNums[0] += 65; }
        }
        // Index 1 = User random number - randomNum2
        lotteryNums[1] = Integer.valueOf(answers.get(4)) - randomNum2;
        while( lotteryNums[1] > 65 || lotteryNums[1] < 1) {
            if(lotteryNums[1] >65){
            lotteryNums[1] = lotteryNums[1] - 65;
            }
            else { lotteryNums[1] += 65; }
        }
        // Index 2 = Pet age + car year
        lotteryNums[2] = Integer.valueOf(answers.get(2)) + Integer.valueOf(answers.get(5));
        while( lotteryNums[2] > 65 || lotteryNums[2] < 1) {
            if(lotteryNums[2] >65){
            lotteryNums[2] = lotteryNums[2] - 65;
            }
            else { lotteryNums[2] += 65; }
        }
        // Index 3 = Lucky number + car year
        lotteryNums[3] = Integer.valueOf(answers.get(3)) + Integer.valueOf(answers.get(5));
        while( lotteryNums[3] > 65 || lotteryNums[3] < 1) {
            if(lotteryNums[3] >65){
            lotteryNums[3] = lotteryNums[3] - 65;
            }
            else { lotteryNums[3] += 65; }
        }
        lotteryNums[4] = 3 * randomNum1;
        while( lotteryNums[4] > 65 || lotteryNums[4] < 1) {
            if(lotteryNums[4] >65){
            lotteryNums[4] = lotteryNums[4] - 65;
            }
            else { lotteryNums[4] += 65; }
        }
        
        // Sort lottery numbers 
        java.util.Arrays.sort(lotteryNums);
        System.out.printf("Lottery numbers: %d, %d, %d, %d, %d Magic ball: %d\n", lotteryNums[0], lotteryNums[1], lotteryNums[2], lotteryNums[3], lotteryNums[4], magicBall);

        System.out.println("Would you like to play again?");
        answer = scanner.nextLine();
        playAgain = checkInput(answer);

        } while(playAgain);
        System.out.println("Thank you for playing!");

        }

        else{
            System.out.println("Please return later to complete the survey.");
        }

    }
    
}
