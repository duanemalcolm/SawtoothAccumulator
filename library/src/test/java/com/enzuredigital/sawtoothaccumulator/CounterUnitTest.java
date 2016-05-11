package com.enzuredigital.sawtoothaccumulator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CounterUnitTest {

    @Test
    public void test_init() throws Exception {
        Counter counter = new Counter(5);
        assertEquals(counter.getValue(), 0);
    }

    @Test
    public void test_1wave() throws Exception {
        Counter counter = new Counter(5);

        int[] values = {0, 1, 2, 3, 4, 5};
        int[] expected = {0, 1, 2, 3, 4, 5};
        int N = values.length;
        for (int i = 0; i < N; i++) {
            counter.nextValue(values[i]);
            assertEquals(expected[i], counter.getValue());
        }
    }

    @Test
    public void test_2waves() throws Exception {
        Counter counter = new Counter(5);

        int[] values = {1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int N = values.length;
        for (int i = 0; i < N; i++) {
            counter.nextValue(values[i]);
            assertEquals(expected[i], counter.getValue());
        }
    }

    @Test
    public void test_2waves_with_skips() throws Exception {
        Counter counter = new Counter(5);

        int[] values = {1, 3, 4, 5, 0, 1, 4, 5};
        int[] expected = {1, 3, 4, 5, 6, 7, 10, 11};
        int N = values.length;
        for (int i = 0; i < N; i++) {
            counter.nextValue(values[i]);
            assertEquals(expected[i], counter.getValue());
        }
    }

    @Test
    public void test_out_of_order() throws Exception {
        Counter counter = new Counter(5);

        int[] values = {1, 2, 3, 4, 5, 0, 1, 3, 2, 4, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 9, 8, 10, 11};
        int N = values.length;
        for (int i = 0; i < N; i++) {
            counter.nextValue(values[i]);
            assertEquals(expected[i], counter.getValue());
        }
    }
}