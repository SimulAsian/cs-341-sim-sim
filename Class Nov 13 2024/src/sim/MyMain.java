package sim;

public class MyMain {

	public static void main(String[] args) {
		double[] hoursOfCoding = {2, 3, 5, 7, 9, 11, 14};
		double[] numberOfBugs= {4, 5, 7, 10, 15, 20, 30};
		
		double[] result = performLinearRegression(hoursOfCoding, numberOfBugs);
		
		System.out.println("Linear Regression Results:");
		System.out.println("Slope (m): " + result[0]);
		System.out.println("Intercept (b): " + result[1]);
		
		double hoursToPredict = 13;
		double predictedBugs = predictBugs(result, hoursToPredict);
		System.out.println("Bugs for " + hoursToPredict + " hours of coding: " + predictedBugs);
	}
	
	public static double[] performLinearRegression(double[] x, double[] y) {
		int n = x.length;
		double sumX = 0;
		double sumY = 0;
		double sumXY = 0;
		double sumX2 = 0;
		
		for(int i = 0; i < n; i++) {
			sumX += x[i];
			sumY += y[i];
			sumXY += x[i] * y[i];
			sumX2 += x[i] * x[i];
		}
		
		double slope = (n*sumXY-sumX*sumY)/(n*sumX2-sumX*sumX);
		double intercept = (sumY-slope*sumX)/n;
		
		double[] result = {slope, intercept};
		return result;
	}
	
	public static double predictBugs(double[] regressionResult, double hours) {
		double slope = regressionResult[0];
		double intercept = regressionResult[1];
		return intercept + slope * hours;
		}
}
