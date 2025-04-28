package challenge.lv2;

public enum UserType {
    VETERAN(0.10), SOLDIER(0.05), STUDENT(0.03), GENERAL(0.0);

    private final double rate;
    UserType(double rate) { this.rate = rate; }


    public double apply(int total) {            // total: 원단위
        return total * (1 - rate);
    }
}
