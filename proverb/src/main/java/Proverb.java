import java.util.Arrays;
import java.util.List;

class Proverb {

    /*
    ["nail", "shoe", "horse", "rider", "message", "battle", "kingdom"]

    For want of a nail the shoe was lost.
For want of a shoe the horse was lost.
For want of a horse the rider was lost.
For want of a rider the message was lost.
For want of a message the battle was lost.
For want of a battle the kingdom was lost.
And all for the want of a nail.
     */
    private List<String> words;
    private String firstWord;
    private String finalString = "";

    Proverb(String[] words) {
        this.words = Arrays.asList(words);
        if (words.length > 0) {
            firstWord = words[0];
        }
    }

    String recite() {
        createString();
        return finalString;
    }

    private void createString() {

        if (words.isEmpty())
            finalString += "";
        while (!words.isEmpty()) {
            if (words.size() == 1) {
                finalString += "And all for the want of a " + firstWord + ".";
                words.clear();
                //words.remove(0);
                //createString();
            } else {
                finalString += "For want of a " + words.get(0) + " the " + words.get(1) + " was lost.\n";
                words.remove(0);
                //  createString();
            }
        }

    }

}
