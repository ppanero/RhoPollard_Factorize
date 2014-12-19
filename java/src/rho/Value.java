package rho;

import java.math.BigInteger;

/**
 * This class represents a value. It contains the value itself and the necessary length to reach it.
 */
public class Value {

    //Attributes
    private int calcLength;
    private BigInteger value;

    //Constructor
    public Value(int length, BigInteger val){
        this.setCalcLength(length);
        this.setValue(val);
    }

    //Getters and Setters
    public BigInteger getValue() {
        return value;
    }
    public void setValue(BigInteger value) {
        this.value = value;
    }
    public int getCalcLength() {
        return calcLength;
    }
    public void setCalcLength(int calcLength) {
        this.calcLength = calcLength;
    }
}
