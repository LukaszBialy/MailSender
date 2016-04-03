package com.white.tech.matcher;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatchedPairTest {

    private MatchedPair toBeTested = new MatchedPair();

    @Test
    public void shouldReturnZeroWhenEmpty() throws Exception {
        int P[] = {};
        int Q[] = {};

        assertThat(toBeTested.matchedPair(P,Q), is(0));
    }

    @Test
    public void shouldReturnZeroWhenOnlyOneValue() throws Exception {
        int P[] = {1};
        int Q[] = {1};

        assertThat(toBeTested.matchedPair(P,Q), is(0));
    }

    @Test
    public void shouldCountLeadingZeros() throws Exception {
        int P[] = {0,0,0};
        int Q[] = {0,0,0};

        assertThat(toBeTested.matchedPair(P,Q), is(3));
    }

    @Test
    public void shouldCountExampleValues() throws Exception {
        int P[] = {1,1,2,2,3,4};
        int Q[] = {0,500_000,0,50_000,40_000,700_00};

        assertThat(toBeTested.matchedPair(P, Q), is(8));
    }

    @Test
    public void shouldCountMatchedPairs() throws Exception {
        int P[] = {0,0,0,1,1,2,2,3,4};
        int Q[] = {0,0,0,0,500_000,0,50_000,40_000,700_00};

        assertThat(toBeTested.matchedPair(P, Q), is(11));
    }

    @Test
    public void shouldCountMatchedPairsWithInputLessThenOne() throws Exception {
        int P[] = {0,0,0};
        int Q[] = {0,500_000,0};

        assertThat(toBeTested.matchedPair(P, Q), is(0));
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenQNull() throws Exception {
        int P[] = {0,0,0};

        toBeTested.matchedPair(P, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPNull() throws Exception {
        int Q[] = {0,500_000,0};

        toBeTested.matchedPair(null, Q);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDifferentSizes() throws Exception {
        int P[] = {0,0,0,2};
        int Q[] = {0,500_000,0};

        toBeTested.matchedPair(P, Q);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenArrayToLarge() throws Exception {
        int P[] = new int[100_001];
//        for (int i = 0; i < P.length; i++) {
//            P[i] = 1;
//        }

        toBeTested.matchedPair(P, P);
    }




}