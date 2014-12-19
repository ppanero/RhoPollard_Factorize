package rho;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents the values calculator. It calculates the next value to use as base, and the
 * number of iterations to be used (length).
 */
public class ValuesCalculator extends Thread {

    //Atributes
    private BlockingQueue<Value> values;
    private Value base;
    private BigInteger N;

    //Constructor
    public ValuesCalculator(Value val, int numThreads, BigInteger N){
      this.values = new ArrayBlockingQueue<Value>(numThreads);
      this.values.add(val);
      this.N = N;
      this.base = val;
    }

    //Getters and Setters

    public Value getNextValue() throws InterruptedException {
        return values.take();
    }

    //Thread unimplemented methods
    public void run(){
        synchronized (this){
            this.base = new Value(this.base.getCalcLength()*2,
                                nextValue(this.base.getValue(), this.base.getCalcLength()*2, this.N));
        }
        try {
            this.values.put(this.base);
        } catch (InterruptedException e) {
            System.out.println("An unexpectederror ocurred while trying to claculate next base");
        }

    }

    //Private methods
    /**
     * Receives the inital value and the number of iterations till the next value to use.
     * @param initial - BigInteger initial value.
     * @param k - int number of iterations.
     * @param N - BigInteger number to factorize (base).
     * @return the next value as a BigInteger.
     */
    private  BigInteger nextValue(BigInteger initial, int k, BigInteger N){
        for(int i = 0; i < k; ++i){
            initial = Function.calc(initial, N);
        }
        return initial;
    }
}
