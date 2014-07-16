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
        Scanner input = new Scanner(System.in);
        BigInteger nToFactorize = input.nextBigInteger();
        System.out.println("One posible factor is: " + rhoalgorithm.factorize(nToFactorize, 400000).toString());

    }
}
