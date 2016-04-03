package com.white.tech.matcher;

import java.lang.String;

public class MatchedPair {

    public static final long ONE_MILLION = 1000000;

    public int matchedPair(int[] P, int[] Q){

        validateInputs(P, Q);

        if (P.length < 2) { return 0;}

        int numberOfMatchedPairs = 0;
        int lowIndex = 0;
        int highIndex = P.length-1;

        if (P[lowIndex] == 0 && Q[lowIndex] == 0) {
            lowIndex++;
            while (lowIndex <= highIndex && P[lowIndex] == 0 && Q[lowIndex] == 0) {
                numberOfMatchedPairs += lowIndex;
                lowIndex++;
            }
        }

        while(lowIndex < highIndex){
            long rLow = rValue(P[lowIndex], Q[lowIndex]);
            long rHigh;

            if (rLow >= 2 * ONE_MILLION) {
                numberOfMatchedPairs += highIndex - lowIndex;
                highIndex--;
            } else if(rLow >= ONE_MILLION) {
                rLow = rValue(P[lowIndex], Q[lowIndex]);
                rHigh = rValue(P[highIndex], Q[highIndex]);
                if( rLow * rHigh >= (rLow + rHigh) * ONE_MILLION) {
                    numberOfMatchedPairs += highIndex - lowIndex;
                    highIndex--;
                }else{
                    lowIndex++;
                }
            } else{
                lowIndex++;
            }
        }

        return numberOfMatchedPairs;
    }

    private void validateInputs(int[] p, int[] q) {
        validate(p == null, "Table p cannot be null!");
        validate(q == null, "Table q cannot be null!");
        validate(p.length != q.length, "Tables are different sizes!");
        validate(p.length  > 100_000, "Table p is too large!");
        validate(q.length  > 100_000, "Table q is too large!");
    }

    private void validate(boolean condition, String message) {
       if (condition){
           throw new IllegalArgumentException(message);
       }
    }

    private long rValue(int a, int b) {
        return (long) a * ONE_MILLION + (long) b;
    }

}
