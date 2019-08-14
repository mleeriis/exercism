class IsbnVerifier {
    private String cleanedInput = "";

    boolean isValid(String stringToVerify) {
        if (stringToVerify.equals(""))
            return false;

        int checkDigit = getCheckDigit(stringToVerify);
        if (checkDigit > 10)
            return false;

        if (isISBNten(stringToVerify)){
            return (checkDigitCalculation(cleanedInput) == checkDigit);
        } else if (isISBNthirteen(stringToVerify)){
            return (checkDigitCalculation(cleanedInput) == checkDigit);
        }

        return false;
    }

    public boolean isCorrectLength(String isbn){
        return (isISBNten(isbn) || isISBNthirteen(isbn));
    }

    private boolean isISBNten(String isbn){
        isbn = cleanInputString(isbn);
        return (isbn.length() == 10);
    }

    private boolean isISBNthirteen(String isbn){
        isbn = cleanInputString(isbn);
        return (isbn.length() == 13);
    }

    private int checkDigitCalculation(String isbn){
        isbn = cleanInputString(isbn);
        int digitSum = 0;

        if (isISBNthirteen(isbn)){
            for(int i = 0; i < 12; i++){
                if(i % 2 == 0){
                    digitSum += Character.getNumericValue(isbn.charAt(i));
                } else {
                    digitSum += (Character.getNumericValue(isbn.charAt(i)) * 3);
                }
            }

            digitSum = Math.abs(((digitSum % 10) - 10) % 10);
        } else{
            for(int i=0; i < 9; i++){
                digitSum += Character.getNumericValue(isbn.charAt(i)) * (i + 1);
            }
            digitSum = Math.abs(digitSum % 11);
        }

        return digitSum;

    }


    private String cleanInputString(String isbn){
        isbn = isbn.replaceAll(" ", "");
        isbn = isbn.replaceAll("-", "");
        cleanedInput = isbn;

        return cleanedInput;
    }

    private int getCheckDigit(String isbn){
        isbn = isbn.trim();
        if (Character.toUpperCase(isbn.charAt(isbn.length() - 1)) == 'X'){
            return 10;
        }
        else if (Character.toUpperCase(isbn.charAt(isbn.length() - 1)) == 'A')
            return 11;
        else
            return (Character.getNumericValue(isbn.charAt(isbn.length() - 1)));

    }


}