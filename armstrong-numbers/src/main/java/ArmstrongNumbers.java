class ArmstrongNumbers {
/*
An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.


9 is an Armstrong number, because 9 = 9^1 = 9
10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
 */
	boolean isArmstrongNumber(int numberToCheck) {
		String numberAsString = Integer.toString(numberToCheck);
		int runningSum = 0;

		if(numberAsString.length() == 1){
			return true;
		}
		else if (numberAsString.length() == 2){
			return false;
		}
		else{
			for(int i = 0; i < numberAsString.length(); i++){
				runningSum += Math.pow(Integer.parseInt(String.valueOf(numberAsString.charAt(i))), numberAsString.length());
			}
			return numberToCheck == runningSum;
		}
		
	}

}
