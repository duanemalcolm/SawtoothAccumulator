package com.enzuredigital.sawtoothaccumulator;

/***
 * This class will take values from a sawtooth wave and accumulate them such that you get a
 * continuous ramp.
 *
 * This currently only works with integer values.
 */

public class Counter {

    private int amplitude;
    private int deltaLimit;
    private long counter = 0;
    private long lastValue = 0;

    public Counter(int amplitude) {
        this.amplitude = amplitude;
        deltaLimit = -amplitude / 2;
    }

    public void nextValue(int value) {
        long delta = value - lastValue;
        if (delta < deltaLimit) {
            delta += amplitude + 1;
        }
        counter += delta;
        lastValue = value;
    }

    public long getValue() {
        return counter;
    }

}
