package com.duckelekuuk.aoc2021;

import java.util.*;
import java.util.stream.Collectors;

public class DayFourPartOne extends AbstractChallenge {

    public static void main(String[] args) {
        DayFourPartOne dayFourPartOne = new DayFourPartOne();
        dayFourPartOne.start();
    }

    private final List<Integer[][]> bingoCards = new ArrayList<>();

    @Override
    public void start() {
        List<String> input = getInput().collect(Collectors.toList());
        // Get bingu numbers
        List<Integer> bingoNumbers = Arrays.stream(input.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        List<Integer[][]> cards = new ArrayList<>();
        // Set up cards
        int bingoCardIndex = 0;
        for (int i = 2; i < input.size(); i = i + 6) {
            Integer[][] currentCard = new Integer[5][5];
            for (int j = 0; j < 5; j++) {
                String[] row = input.get(i + j).split(" ");
                for (int k = 0; k < row.length; k++) {
                    currentCard[j][k] = Integer.parseInt(row[k]);
                }
            }
            cards.add(bingoCardIndex, currentCard);
            bingoCardIndex++;
        }

        // Act
        int currentNumber = -1;
        for (Integer bingoNumber : bingoNumbers) {
            for (Integer[][] card : cards) {
                boolean rowWon = false;
                boolean colWon = false;
                for (int i = 0; i < card.length; i++) {
                    for (int j = 0; j < card[i].length; j++) {
                        if (card[i][j].equals(bingoNumber)) {
                            card[i][j] = 100;
                        }
                    }
                }
            }

        }

        // Result
        System.out.println("Current number: " + currentNumber);
//        System.out.println("Sum: " + sum);
//        System.out.println("Output: " + (sum * currentNumber));
    }
}
