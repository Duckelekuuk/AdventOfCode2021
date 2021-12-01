package com.duckelekuuk.aoc2021;

import java.util.List;
import java.util.stream.Collectors;

public class DayOnePartTwo extends AbstractChallenge {

    public static void main(String[] args) {
        DayOnePartTwo dayOnePartOne = new DayOnePartTwo();
        dayOnePartOne.start();
    }

    @Override
    public void start() {
        List<String> collect = getInput().collect(Collectors.toList());
        int count = 0;
        int previousSum = 0;

        for (int i = 1; i + 2 < collect.size(); i++) {
            int currentSum = 0;
            for (int j = 0; j < 3; j++) {
                int newIndex = i + j;
                currentSum += Integer.parseInt(collect.get(newIndex));
            }
            if (previousSum != -1 && previousSum < currentSum) count++;
            previousSum = currentSum;
        }

        System.out.println("Result: " + count);
    }
}
