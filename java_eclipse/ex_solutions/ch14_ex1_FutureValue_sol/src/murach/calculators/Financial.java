package murach.calculators;

public class Financial {

    public static double calculateFutureValue(double monthlyInvestment,
            double yearlyInterestRate, int years) {

        // convert yearly values to monthly values
        double monthlyInterestRate = yearlyInterestRate / 12 / 100;
        int months = years * 12;        
        
        // calculate the future value
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue += monthlyInvestment;
            double monthlyInterestAmount = futureValue * monthlyInterestRate;
            futureValue += monthlyInterestAmount;            
        }
        
        return futureValue;
    }
}