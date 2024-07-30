public class FinancialForecasting {

    
    public static double calculateFutureValue(double initialValue, double annualGrowthRate, int numYears) {
       
        if (numYears == 0) {
            return initialValue;
        }
       
        double priorYearValue = calculateFutureValue(initialValue, annualGrowthRate, numYears - 1);
        return priorYearValue * (1 + annualGrowthRate);
    }

    public static void main(String[] args) {
        
        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05; 
        int projectionYears = 10;

        
        double futureInvestmentValue = calculateFutureValue(initialInvestment, annualGrowthRate, projectionYears);
        System.out.println("Projected Future Value after " + projectionYears + " years: $" + futureInvestmentValue);
    }
}
