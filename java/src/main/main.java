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
        Scanner number = new Scanner(System.in);
        System.out.println("One posible factor is: " + rhoalgorithm.factorize(number.nextBigInteger(), new BigInteger("100000")).toString());
    }
}
