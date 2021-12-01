package com.duckelekuuk.aoc2021;

import java.util.stream.Collectors;

public class DayOnePartOne extends AbstractChallenge {

    public static void main(String[] args) {
        DayOnePartOne dayOnePartOne = new DayOnePartOne();
        dayOnePartOne.start();
    }

    @Override
    public void start() {
        int previous = -1;
        int count = 0;
        for (String input : getInput().collect(Collectors.toList())) {
            int depth = Integer.parseInt(input);
            if (previous != -1 && depth > previous) count++;
            previous = depth;
        }

        System.out.println("Result: " + count);
    }
}
