class Darts {
/*
0,0 = center
inner circle = 1 unit, 10 pts
middle circle = 5 units, 5 pts
outer circle = 10 units, 1 point
outside = 0 points

x^2 + y^2 = r^2 <= point is within circle
 */
    String circleLocation = "";

    Darts(double x, double y) {
        double testPoint = Math.pow(x, 2) + Math.pow(y, 2);

        if (testPoint <= 1){
            circleLocation = "inner";
        }
        if (testPoint > 1){
            circleLocation = "middle";
        }
        if (testPoint > 25){
            circleLocation = "outer";
        }
        if (testPoint > 100) {
            circleLocation = "off";
        }
    }

    int score() {
        if (circleLocation.equals("off"))
            return 0;
        else if (circleLocation.equals("outer"))
            return 1;
        else if (circleLocation.equals("middle"))
            return 5;
        else
            return 10;
    }

}
