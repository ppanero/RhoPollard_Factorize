package main;

import rho.rhoalgorithm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Light on 10/07/14.
 */
public class main {
    public static void main(String [] args)
    {
        //ask for a number to factorize
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Type the number to factorize: ");
            BigInteger nToFactorize = input.nextBigInteger();
            System.out.println("One posible factor is: " + rhoalgorithm.factorize(nToFactorize, 100000000).toString());
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
