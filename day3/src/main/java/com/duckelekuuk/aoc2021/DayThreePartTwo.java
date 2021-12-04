package com.duckelekuuk.aoc2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayThreePartTwo extends AbstractChallenge {

    public static void main(String[] args) {
        DayThreePartTwo dayThreePartTwo = new DayThreePartTwo();
        dayThreePartTwo.start();
    }


    @Override
    public void start() {
        List<String> input = getInput().collect(Collectors.toList());

        System.out.println("Result: " + (getRating(input, true) * getRating(input, false)));
    }

    private int getRating(List<String> input, boolean mostCommon) {
        int bits = input.get(0).length();
        List<String> restInput = new ArrayList<>(input);

        for (int i = 0; i < bits; i++) {
            final int fi = i;
            int ones = getPositiveCount(restInput, fi);
            int zeros = restInput.size() - ones;

            restInput.removeIf(s -> {
                if (ones >= zeros) {
                    return (!mostCommon || s.charAt(fi) != '1') &&
                            (mostCommon || s.charAt(fi) != '0');
                } else {
                    return (!mostCommon || s.charAt(fi) != '0') &&
                            (mostCommon || s.charAt(fi) != '1');
                }
            });

            if (restInput.size() == 1) return Integer.parseInt(restInput.get(0), 2);
        }

        return 0;
    }

    private int getPositiveCount(List<String> input, int index) {
        int count = 0;
        for (String line : input) {
            if (line.charAt(index) == '1') count++;
        }
        return count;
    }
}
