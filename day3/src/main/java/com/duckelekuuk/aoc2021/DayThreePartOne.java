package com.duckelekuuk.aoc2021;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayThreePartOne extends AbstractChallenge {

    public static void main(String[] args) {
        DayThreePartOne dayThreePartOne = new DayThreePartOne();
        dayThreePartOne.start();
    }

    private int[] positiveCount = new int[12];

    @Override
    public void start() {
        List<String> input = getInput().collect(Collectors.toList());
        long count = input.size();
        input.forEach(s -> {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') positiveCount[i]++;
            }
        });

        String gamma  = "";
        String epsilon   = "";
        for (int i = 0; i < positiveCount.length; i++) {
            if (positiveCount[i] >= (count / 2)) {
                gamma  += "1";
                epsilon += "0";
            } else {
                gamma  += "0";
                epsilon += "1";
            }
        }

        int gammaInt = Integer.parseInt(gamma , 2);
        int epsilonInt = Integer.parseInt(epsilon, 2);

        System.out.println("Gamma: " + gamma);
        System.out.println("Result: " + gammaInt);

        System.out.println("Epsilon: " + epsilon);
        System.out.println("Result: " + epsilonInt);

        System.out.println("Multiplied: " + (gammaInt * epsilonInt));
    }
}
