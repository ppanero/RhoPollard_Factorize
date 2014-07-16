package rho;

import java.math.BigInteger;

/**
 * Created by Light on 10/07/14.
 */
public class Rhoalgorithm extends Thread{

    //Attributes
    private final static BigInteger NONE = new BigInteger("-1"); //negative one
    private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static BigInteger THREE  = new BigInteger("3");
    private BigInteger N;
    private Value currentVal;

    /**
     * private constructor so the class is static
     */
    public Rhoalgorithm(BigInteger N, Value val){
        this.N = N;
        this.currentVal = val;
    }

    /**
     * Receive a long integer and return the first factor found, if there are no
     * factor when the limit is reached, then its returns the number received.
     * @return long integer
     */
    private BigInteger factorize(){
        BigInteger divisor, x_i = this.currentVal.getValue();
        int currentLength = this.currentVal.getCalcLength();

        if(N.compareTo(THREE) < 0 || N.mod(TWO).equals(ZERO)){
            return N.divide(TWO);
        }

        BigInteger x_j = x_i;
        int iters = 0;
        while(iters < currentLength){
            x_i = Function.calc(x_i, N);
            divisor  = x_i.subtract(x_j).gcd(N);
            if(!divisor.equals(ONE) && !divisor.equals(NONE) && !divisor.equals(N)){
                return divisor;
            }
            iters += 1;
        }

        return null;
    }

    //Thread unimplemented methods
    public void run(){
        this.factorize();
    }



}
