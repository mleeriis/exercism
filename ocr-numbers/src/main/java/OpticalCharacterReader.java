import java.util.ArrayList;
import java.util.List;

public class OpticalCharacterReader {
    /*
        Size should be 3 across, 4 high
     */
    public String parse(List<String> input) {
        String finalOutput = "";
        if (input.size() % 4 != 0)
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");

        for (String item : input) {
            if (item.length() % 3 != 0)
                throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }

        while (input.size() > 3) {
            finalOutput += parseLine(input.subList(0, 4));


            if (input.size() > 4) {
                input = input.subList(4, (input.size() - 1));
                finalOutput += ",";
            } else
                break;
        }

        return finalOutput;
    }

    //each Line = set of 4
    private String parseLine(List<String> eachLine) {
        //parse each character
        // substring 0 - 3

        String subAnswer = "";
        String subDigit = "";
        String remainingDigits = "";
        List<String> singleNumber = new ArrayList<String>();

        if (eachLine.get(0).length() > 3) {
            while (eachLine.get(0).length() > 3) {
                for (int i = 0; i < 4; i++) {
                    subDigit = eachLine.get(i).substring(0, 3);
                    singleNumber.add(subDigit);

                    remainingDigits = eachLine.get(i);
                    eachLine.set(i, remainingDigits.substring(3, 6));
                }
                subAnswer += parseDigit(singleNumber);
            }
        } else
            subAnswer = parseDigit(eachLine);

        return subAnswer;
    }

    private String parseDigit(List<String> eachDigit) {

        if (!eachDigit.get(3).equals("   "))
            return "?";

        String testString = eachDigit.get(0);
        System.out.println(testString);


        if (eachDigit.get(0).equals(" _ ")) {
            if (eachDigit.get(1).equals("| |")) {
                if (eachDigit.get(2).equals("|_|"))
                    return "0";
            } else if (eachDigit.get(1).equals(" _|")) {
                if (eachDigit.get(2).equals("|_ "))
                    return "2";
                else if (eachDigit.get(2).equals(" _|"))
                    return "3";
            } else if (eachDigit.get(1).equals("|_|")) {
                if (eachDigit.get(2).equals("  |"))
                    return "4";
                else if (eachDigit.get(2).equals("|_|"))
                    return "8";
                else if (eachDigit.get(2).equals(" _|"))
                    return "9";
            } else if (eachDigit.get(1).equals("|_ ")) {
                if (eachDigit.get(2).equals(" _|"))
                    return "5";
                else if (eachDigit.get(2).equals("|_|"))
                    return "6";
            } else if (eachDigit.get(1).equals("  |")) {
                if (eachDigit.get(2).equals("  |"))
                    return "7";
            }
        } else if (eachDigit.get(0).equals("   ")) {
            if (eachDigit.get(1).equals("  |")) {
                if (eachDigit.get(2).equals("  |"))
                    return "1";
            }
        }

        return "?";
    }
}


