package com.duckelekuuk.aoc2021;

import java.util.Locale;
import java.util.stream.Collectors;

public class DayTwoPartTwo extends AbstractChallenge {

    public static void main(String[] args) {
        DayTwoPartTwo dayTwoPartTwo = new DayTwoPartTwo();
        dayTwoPartTwo.start();
    }

    @Override
    public void start() {
        int aim = 0;
        int depth = 0;
        int horizontal = 0;
        for (String instruction : getInput().collect(Collectors.toList())) {
            String[] actions = instruction.split(" ");
            int amount = Integer.parseInt(actions[1]);
            switch (actions[0].toLowerCase(Locale.ROOT)) {
                case "forward":
                    horizontal += amount;
                    depth += (aim * amount);
                    break;
                case "up":
                    aim -= amount;
                    break;
                case "down":
                    aim += amount;
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
