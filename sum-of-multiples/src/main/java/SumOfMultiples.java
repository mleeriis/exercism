import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfMultiples {
/*
    Find sum of multiples of numbers in set that are less than number.

    i.e., number = 1, set = 3,5 answer = 0; no multiples of 3 or 5 under 1

    number = 20, set = 3,5 answer = 78; multiples = 3, 5, 6, 9, 10, 12, 15, and 18.

 */

    LinkedHashSet<Integer> multiples = new LinkedHashSet<Integer>();

    SumOfMultiples(int number, int[] set) {
        set = checkTheSet(number, set);
        if (set.length != 0)
            findMultiples(number, set);
    }

    int getSum() {
        int totalSum = 0;
      //  multiples = multiples.stream().distinct();
        if (multiples.size() == 0)
            return totalSum;
        else {
            for(int i : multiples){
                totalSum += i;
            }
            return totalSum;
        }
    }

    private int[] checkTheSet(int number, int[] set) {
        ArrayList<Integer> setToTest = new ArrayList<Integer>();

        for (int i = 0; i < set.length; i++) {
            if (set[i] == 0){
                break;
            }
            else if (set[i] < number) {
                setToTest.add(set[i]);
            }
        }
        return setToTest.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void findMultiples(int number, int[] set){
        for (int i = 0; i < set.length; i++){
            addMultiples(set[i], number);
        }
    }

    private void addMultiples(int setNumber, int maxNumber){
        int previousNumber = setNumber;
        while(previousNumber < maxNumber){
            multiples.add(previousNumber);
            previousNumber += setNumber;
        }
    }

}