package rho;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Light on 10/07/14.
 */
public class rhoalgorithm {

    /**
     * static constants representing zero and one
     */
    private final static BigInteger NONE = new BigInteger("-1"); //negative one
    private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static BigInteger THREE  = new BigInteger("3");

    /**
     * private constructor so the class is static
     */
    private rhoalgorithm(){}

    /**
     * Receive a long integer and return the first factor found, if there are no
     * factor when the limit is reached, then its returns the number received.
     * @param N - long integer to factorize
     * @return long integer
     */
    public static BigInteger factorize(BigInteger N, BigInteger max){
        BigInteger divisor;

        if(N.compareTo(THREE) < 0 || N.mod(TWO).equals(ZERO)){
            return N.divide(TWO);
        }

        /*
            First iteration:
                1º- find a random number in range [2..N-1]
                2º- calculate X0 and X1
                3º- find gcd(X1-X0, N)
         */
        Integer rnd = new Random().nextInt();
        BigInteger x_zero = new BigInteger(rnd.toString()).mod(N).add(TWO);
        x_zero = func(x_zero,N);
        BigInteger x_i = func(x_zero,N);
        divisor = x_i.subtract(x_zero).gcd(N);

        if(divisor.equals(ONE) || divisor.equals(NONE)){
            return divisor;
        }

        BigInteger x_j = x_i;
        int bitsActual = 2;
        BigInteger k = ONE;

        for(BigInteger i = TWO; i.compareTo(max) < 0; i.add(ONE)){

            BigInteger j = TWO.pow(Integer.parseInt(i.subtract(ONE).toString())).subtract(ONE);
            if(i.bitLength() > bitsActual){
                //Integer iBits = Integer.parseInt(new Integer(i.bitLength()-2).toString());
                k =TWO.pow(i.bitLength()-2).subtract(ONE);
                x_j = nextValue(x_j, j.subtract(k), N);
                bitsActual = i.bitLength();
            }
            x_i = func(x_i,N);
            divisor  = x_i.subtract(x_j).gcd(N);
            if(!divisor.equals(ONE) && !divisor.equals(NONE) && !divisor.equals(N)){
                return divisor;
            }
        }

        return divisor;
    }

    /**
     * Receives the inital value and the number of iterations till the next value to use.
     * @param initial - BigInteger initial value.
     * @param k - int number of iterations.
     * @param N - BigInteger number to factorize (base).
     * @return the next value as a BigInteger.
     */
    private static BigInteger nextValue(BigInteger initial, BigInteger k, BigInteger N){
        for(BigInteger i = ZERO; i.compareTo(k) < 0; i.add(ONE)){
            initial = initial.multiply(initial).add(ONE).mod(N);
        }
        return initial;
    }

    /**
     * Calculates the value of the number in the funcion. In this case the function is x^2 + 1.
     * @param x - BigInteger, number to find the value.
     * @return the value of f(x).
     */
    private static BigInteger func(BigInteger x, BigInteger N){
        return x.multiply(x).add(ONE).mod(N);
    }

}
