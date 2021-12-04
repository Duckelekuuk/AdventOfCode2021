package com.duckelekuuk.aoc2021;

import java.util.Locale;
import java.util.stream.Collectors;

public class DayTwoPartOne extends AbstractChallenge {

    public static void main(String[] args) {
        DayTwoPartOne dayOnePartOne = new DayTwoPartOne();
        dayOnePartOne.start();
    }

    @Override
    public void start() {
        int depth = 0;
        int horizontal = 0;
        for (String instruction : getInput().collect(Collectors.toList())) {
            String[] actions = instruction.split(" ");
            int amount = Integer.parseInt(actions[1]);
            switch (actions[0].toLowerCase(Locale.ROOT)) {
                case "forward":
                    horizontal += amount;
                    break;
                case "up":
                    depth -= amount;
                    break;
                case "down":
                    depth += amount;
                    break;
                default:
                    continue;
            }
        }

        System.out.println("Horizontal: " + horizontal);
        System.out.println("Depth: " + depth);
        System.out.println("Result: " + (depth * horizontal));
    }
}
