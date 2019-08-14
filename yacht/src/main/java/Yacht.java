import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

class Yacht {
/*
enum YachtCategory {

    YACHT,
    ONES,
    TWOS,
    THREES,
    FOURS,
    FIVES,
    SIXES,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    LITTLE_STRAIGHT,
    BIG_STRAIGHT,
    CHOICE

}

Always 5 dice
 */

    int totalScore = 0;
    int[] dice;
    YachtCategory yachtCategory;
    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;

    }

    int score() {
        int[] littleStraight = {1, 2, 3, 4, 5};
        int[] bigStraight = {2, 3, 4, 5, 6};
        Arrays.sort(dice);
        switch (yachtCategory){
            case YACHT:
                if (dice[0] == dice[4]){
                    return 50;
                }
                break;
            case ONES:
                calculatePoints(1);
                return totalScore;
            case TWOS:
                calculatePoints(2);
                return totalScore;
            case THREES:
                calculatePoints(3);
                return totalScore;
            case FOURS:
                calculatePoints(4);
                return totalScore;
            case FIVES:
                calculatePoints(5);
                return totalScore;
            case SIXES:
                calculatePoints(6);
                return totalScore;
            case FULL_HOUSE:
                testFullHouse(dice[0], dice[4], yachtCategory);
                return totalScore;
            case FOUR_OF_A_KIND:
                testFullHouse(dice[0], dice[4], yachtCategory);
                return totalScore;
            case LITTLE_STRAIGHT:
                if (Arrays.equals(littleStraight, dice))
                    return 30;
                break;
            case BIG_STRAIGHT:
                if (Arrays.equals(bigStraight, dice))
                    return 30;
                break;
            case CHOICE:
                return IntStream.of(dice).sum();
            default:
                return 0;
        }
        return totalScore;
    }

    private void calculatePoints(int categoryMultiplier) {
        for(int i = 0; i < dice.length; i++){
            if (dice[i] == categoryMultiplier)
                totalScore += categoryMultiplier;
        }
    }

    private void testFullHouse(int firstNumber, int secondNumber, YachtCategory yachtCategory){
        int first = 0;
        int second = 0;

        for (int i = 0; i < dice.length; i++){
            if (dice[i] == firstNumber)
                first++;
            else if (dice[i] == secondNumber)
                second++;
        }

        if ((yachtCategory == YachtCategory.FULL_HOUSE) && (first == 3 && second == 2) || (first == 2 && second == 3))
            totalScore = (first * firstNumber) + (second * secondNumber);
        else if (yachtCategory == YachtCategory.FOUR_OF_A_KIND && first == 4) {
            totalScore = first * firstNumber;
        }
        else if (yachtCategory == YachtCategory.FOUR_OF_A_KIND && second == 4){
            totalScore = second * secondNumber;
        }
        else if (yachtCategory == YachtCategory.FOUR_OF_A_KIND && first == 5){
            totalScore = 4 * firstNumber;
        }
    }

}
