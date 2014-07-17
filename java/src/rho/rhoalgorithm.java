package rho;

import java.math.BigInteger;

/**
 * Created by Light on 10/07/14.
 */
public class Rhoalgorithm extends Thread{

    //Attributes
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

        if(N.compareTo(RhoUtils.THREE) < 0 || N.mod(RhoUtils.TWO).equals(RhoUtils.ZERO)){
            return N.divide(RhoUtils.TWO);
        }

        BigInteger x_j = x_i;
        int iters = 0;
        while(iters < currentLength){
            x_i = Function.calc(x_i, N);
            divisor  = x_i.subtract(x_j).gcd(N);
            if(!divisor.equals(RhoUtils.ONE) && !divisor.equals(RhoUtils.NONE) && !divisor.equals(N)){
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
