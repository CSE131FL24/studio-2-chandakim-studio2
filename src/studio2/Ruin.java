package studio2;
import java.util.Scanner;
import java.util.Random;
public class Ruin {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		Random random = new Random ();
		System.out.println("Please input the amount of money that you'll start with (no greater than $15): ");
		int startAmount = in.nextInt();
		int amount = startAmount;
		System.out.println("Enter the numnber of days you'd like to simulate: ");
		int totalSimulations = in.nextInt();
		System.out.println("Please enter the win limit");
		int winLimit = in.nextInt();
		System.out.println("Enter the win chance: ");
		double winChance = in.nextDouble();
		int j = 0;
		int ruinDays=0;
		int winDays=0;
		for (int i = 1; i <= totalSimulations; i++) {
			System.out.println("Day " + i + ": ");
			while (amount < winLimit && amount > 0) {
				j++;
				double randomDouble = Math.random();
		       if (randomDouble < winChance) {
		    	   amount++;
		       }
		       else {
		    	   amount--;  
		       }
	
			}
			
			 if (amount == 0) {
		    	   System.out.println("You lose day " + i);
		    	   ruinDays++;
		       }	
		      else {
		    	   System.out.println("You win day " + i);
		    	   winDays++;
		       }
			 System.out.println("You played " + j + " runs on day " + i);
			 
			 amount = startAmount;
			 j = 0;
		}
		System.out.println("The estimate of the ruin rate is " + (double)ruinDays/(double)totalSimulations);
		if (winChance == 0.5) {
			System.out.println("The expected ruin rate is " + (1.0 - (double)startAmount/(double)winLimit));
		}
		else {
			double a = (1.00 - winChance)/winChance;
			double expectedRuin = ((Math.pow(a, startAmount)) - (Math.pow(a, winLimit)))/(1.00-(Math.pow(a,winLimit)));
			System.out.println("The expected ruin rate is " + expectedRuin);
		}
		
	}

}
