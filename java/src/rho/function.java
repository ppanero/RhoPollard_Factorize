package rho;

import java.math.BigInteger;

/**
 * This class represents the function used to calculate the next value. In this case is X^2 + 1
 */
public class Function {

    /**
     * Calculates the value of the number in the function. In this case the Function is x^2 + 1.
     * @param x - BigInteger, number to find the value.
     * @param N - BigInteger base.
     * @return the value of f(x).
     */
    public static BigInteger calc(BigInteger x, BigInteger N){
        return x.multiply(x).add(RhoUtils.ONE).mod(N);
    }
}
