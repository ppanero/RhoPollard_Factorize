package rho;

import java.math.BigInteger;

/**
 * Created by Light on 16/07/14.
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
