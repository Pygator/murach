package murach.test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // create the array
        double[] randomNumbers = new double[99];

        // assign random numbers to the array
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = Math.random() * 100;
        }

        // calculate and print the average value
        double sum = 0;
        for (double number : randomNumbers) {
            sum += number;
        }
        double average = sum / randomNumbers.length;
        System.out.println("Average: " + average);
        System.out.println();

        // sort the array and print the median value
        Arrays.sort(randomNumbers);
        System.out.println("Median:  " + randomNumbers[50]);
        System.out.println();

        // print every 9th value starting with the 9th value
        for (int i = 8; i < randomNumbers.length; i += 9) {
            int position = i+1;
            System.out.println("Position: " + position + "   " 
                    + randomNumbers[i]);
        }
        System.out.println();
    }
}