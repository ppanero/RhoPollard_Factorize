package main;

import rho.RhoUtils;
import rho.Rhoalgorithm;
import rho.Value;
import rho.ValuesCalculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Light on 10/07/14.
 */
public class Main {
    public static void main(String [] args)
    {
        //ask for a number to factorize
        try {
            BigInteger nToFactorize, factor = null;
            Scanner input;
            ValuesCalculator calculator;
            List<Rhoalgorithm> factoringThreads;
            int numThreads;

            do {
                input = new Scanner(System.in);

                do {
                    System.out.print("Number of Threads to use (min 1): ");
                    numThreads = input.nextInt();
                }while(numThreads < 0);

                System.out.print("Type the number to factorize: ");
                nToFactorize = input.nextBigInteger();
                if(nToFactorize.compareTo(RhoUtils.ZERO) > 0) {
                    //Threads
                    Integer rnd = new Random().nextInt(); //Base number
                    BigInteger init = new BigInteger(rnd.toString()).mod(nToFactorize).add(RhoUtils.TWO); //convert to BigInteger
                    calculator = new ValuesCalculator(new Value(2,init),numThreads,nToFactorize);
                    // loop creating rhoalgorithm threads
                    factoringThreads =  new ArrayList<Rhoalgorithm>(numThreads);
                    // start threads
                    calculator.start();
                    for(Rhoalgorithm alg : factoringThreads){
                        alg.start();
                    }
                    //TODO: use future and callable
                    System.out.println("One posible factor is: " + factor.toString());
                }
            }while(nToFactorize.equals(RhoUtils.ZERO));
        }
        catch(java.util.InputMismatchException e){
            System.out.println("Input mismatch exception. Input must be a positive integer");
        }
        catch(java.util.NoSuchElementException e){
            System.out.println("No such element exception");
        }
        catch(IllegalStateException e){
            System.out.println("Illegal state exception occured");
        }
        catch(Exception e){
            System.out.println("An unhandled exception occured...Sorry :(");
        }

    }
}
