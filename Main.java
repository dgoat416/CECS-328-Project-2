import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Class to house the solution to Project 2
 * @author Deron Washington II
 * Date Started: 9/14/20 @ 8:27pm
 * Date Finished: ? 
 * Date Optimized: ?
 *
 */
public class Main 
{
	// Class to hold the gcd output
	public static class gcdOutput
	{
		// public member variables
		BigInteger newA;
		BigInteger newB;
		int score;
		
		// Constructor
		public gcdOutput()
		{
			this.newA = null;
			this.newB = null;
			this.score = 0;
		}
		
		// Parameterized Constructor
		public gcdOutput(BigInteger newA, BigInteger newB, int score)
		{
			this.newA = newA;
			this.newB = newB;
			this.score = score;
		}
	}
	
	
	/**
	 * Method to return the "score" of a recursive algorithm
	 * @param a = one value to determine gcd
	 * 	@param b = another value to determine gcd
	 * @return
	 * 				= the score of the recursive algorithm
	 */
	public static int gcd(BigInteger a, BigInteger b, String divisor)
	{
		int score = 0;
		// not computing the gcd simply implement the algorithm 
		// he put on the page and calculate the score
		if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0 &&
			b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0)
		{
//			score += 3 * gcd(a.divide(new BigInteger("3")),
//					            b.divide(new BigInteger("3")), score);
			
			score += 3 * 2;
			a = a.divide(new BigInteger("3"));
		    b = b.divide(new BigInteger("3"));
		}
		
		else if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0 &&
			      	b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) != 0)
		{
//			score += gcd(a.divide(new BigInteger("3")), b, score);
			score += 1;
			a = a.divide(new BigInteger("3"));
		}
		
		else if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) != 0 &&
			      b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0)
		{
//			score += gcd(a, b.divide(new BigInteger("3")), score);
			score += 1;
			b = b.divide(new BigInteger("3"));
		}
		
		
//		if (a.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) == 0 &&
//				b.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) == 0)
//			{
//			score += 4 * gcd(a.divide(new BigInteger("4")),
//						            b.divide(new BigInteger("4")), score);
//			}
//			
//			else if (a.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) == 0 &&
//				      	b.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) != 0)
//			{
//				score += gcd(a.divide(new BigInteger("4")), b, score);
//			}
//			
//			else if (a.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) != 0 &&
//				      b.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) == 0)
//			{
//				score +=gcd(a, b.divide(new BigInteger("4")), score);
//			}
//		
//		if (a.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0 &&
//				b.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0)
//			{
//			score += 7 * gcd(a.divide(new BigInteger("7")),
//						            b.divide(new BigInteger("7")), score);
//			}
//			
//			else if (a.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0 &&
//				      	b.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) != 0)
//			{
//				score += gcd(a.divide(new BigInteger("7")), b, score);
//			}
//			
//			else if (a.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) != 0 &&
//				      b.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0)
//			{
//				score += gcd(a, b.divide(new BigInteger("7")), score);
//			}
		
		
		return score;
	}

	/**
	 * Method to write the results of countRecustions to an
	 * output file
	 * @param ezDivNums = easily divisible numbers
	 * @param scores = the scores to write to the file
	 */
	public static void writeOutput(List<Integer> ezDivNums, List<BigInteger> scores)
	{
		File outFile = new File("outputGANG.txt");
		PrintWriter writer = null;
		int index = 0;
		
		try
		{
			writer = new PrintWriter(outFile);
			
			// print out the "easily divisible nums" and their scores 
			// separated by a space
			for (Integer Int : ezDivNums)
			{
				writer.print(Int + " " + scores.get(index) + "\n");
				index++;
			}
				
				
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}
		
	}
	
	public static void main(String[] args) 
	{
		// Read input from file
		File inFile = new File("input.txt");
		Scanner scan = null;
		
		// necessary variables to store input 
		int numElements = 0; // n
		String divisor = "";
		
		// stores easily divisible numbers (there will b 'n' of these)
		List<Integer> ezDivNums = new ArrayList<Integer>();
		
		// stores the a values (there will b 'n' of these) first number in gcd statement
		List<BigInteger> aValues = new ArrayList<BigInteger>();
		
		// stores the b values (there will b 'n' of these) second number in gcd statement
		List<BigInteger> bValues = new ArrayList<BigInteger>();
		
		// stores the recursion scores (there will b 'n' of these)
		Integer[] scores = null;
		
		try
		{
			scan = new Scanner(inFile);
			
			// gives us the number of elements
			numElements = scan.nextInt();
			
			scores = new Integer[numElements];
			
			// gives us list of "easily divisible numbers"
			for (int i = 0; i < numElements; i++)
				ezDivNums.add(scan.nextInt());
			
			// gives us list of a and b values for initial gcd comparison
			for (int i = 0; i < numElements; i++)
			{
				aValues.add(scan.nextBigInteger());
				bValues.add(scan.nextBigInteger());
			}
			
			 //determine the gcd for each and store it in scores
			for (int i = 0; i < numElements; i++)
				scores.add(gcd(aValues.get(i), bValues.get(i), ezDivNums.get(i).toString()));
			
			// gcd output
			gcdOutput output = new gcdOutput();
			
//			// determine the gcd score of one statement executed through for each set of divisible numbers
//			// s = gcd statement number index
//			// d = each easily divisible number index
//			for(int s = 0; s < numElements; s++)
//			{
//				for (int d = 0; d < numElements; d++)
//				{
//					output = gcd(aValues.get(d),bValues.get(d), ezDivNums.get(d).toString());
//				}
//			}
			
			// print test
			for (Integer Int : scores)
				System.out.print(Int);
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			scan.close();
		}
		
		
		// print results to an output file
//		writeOutput(ezDivNums, scores);
		
	}

}
