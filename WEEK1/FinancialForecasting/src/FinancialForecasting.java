public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base case: No more periods left to forecast
        if (periods == 0) {
            return currentValue;
        }
        // Recursive case: Calculate future value by reducing the periods
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        // Example parameters
        double initialValue = 1000.0;  // Initial value
        double annualGrowthRate = 0.05; // 5% annual growth rate
        int years = 10;                // Number of years to forecast

        // Calculate future value
        double futureValue = calculateFutureValue(initialValue, annualGrowthRate, years);

        // Output the result
        System.out.printf("Future value after %d years with a growth rate of %.2f%% is: %.2f%n",
                years, annualGrowthRate * 100, futureValue);
    }
}
