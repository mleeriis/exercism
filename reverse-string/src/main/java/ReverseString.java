class ReverseString {

    String reverse(String inputString) {
        int length = inputString.length();
        String outputString = "";

        if (length > 0){

            for(int i = (length - 1); i >=0; i--){
                outputString += inputString.charAt(i);
            }
        }

        return outputString;
    }
  
}