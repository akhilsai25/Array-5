package TaxCalculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This solution uses a slab based approach where we calculate tax based on each slab with minimum of either the amount left or the total amount in that slab
// We can use prev variable to track previous limit and iteratively calculate the total tax
public class TaxCalculation {

    public static void main (String[] args) {

        List<List<Double>> levels = new ArrayList<>();

        levels.add( Arrays.asList(10000.0, 0.3) ); // 3000

        levels.add( Arrays.asList(20000.0, 0.2) ); // 2000

        levels.add( Arrays.asList(30000.0, 0.1) ); // 1000

        levels.add( Arrays.asList(null, 0.1) ); // 1500

        double tax = calculateTax(levels,45000);

        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary){

        double prev = 0, totalTax = 0;

        for(int i=0;i<levels.size();i++) {
            if(salary==0) break;
            List<Double> level = levels.get(i);
            Double currentLimit = level.get(0)==null?Double.MAX_VALUE:level.get(0);
            Double taxPercentage = level.get(1);

            double amount, tax;


            if(i==0) {
                amount = Math.min(currentLimit, salary);
            } else {
                amount = Math.min(currentLimit-prev, salary);
            }

            tax = amount*taxPercentage;
            totalTax += tax;
            salary-=amount;
            prev=currentLimit;
        }

        return totalTax;
    }
}
