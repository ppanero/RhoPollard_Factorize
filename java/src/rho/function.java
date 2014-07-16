package rho;

import java.math.BigInteger;

/**
 * This class represents the Function. In this case is X^2 + 1
 */
public class Function {


    private final static BigInteger ONE  = new BigInteger("1");
    /**
     * Calculates the value of the number in the funcion. In this case the Function is x^2 + 1.
     * @param x - BigInteger, number to find the value.
     * @param N - BigInteger base.
     * @return the value of f(x).
     */
    public static BigInteger calc(BigInteger x, BigInteger N){
        return x.multiply(x).add(ONE).mod(N);
    }
}
