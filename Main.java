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
	
	/**
	 * Method to return the "score" of a recursive algorithm
	 * @param a = one value to determine gcd
	 * 	@param b = another value to determine gcd
	 * @return
	 * 				= the score of the recursive algorithm
	 */
	public static BigInteger countRecursions(BigInteger a, BigInteger b)
	{
		return BigInteger.ONE;
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
		int numElements = 0;
		
		// stores easily divisible numbers (there will b 'n' of these)
		List<Integer> ezDivNums = new ArrayList<Integer>();
		
		// stores the a values (there will b 'n' of these)
		List<BigInteger> aValues = new ArrayList<BigInteger>();
		
		// stores the b values (there will b 'n' of these)
		List<BigInteger> bValues = new ArrayList<BigInteger>();
		
		// stores the recursion scores (there will b 'n' of these)
		List<BigInteger> scores = new ArrayList<BigInteger>();
		
		try
		{
			scan = new Scanner(inFile);
			
			// gives us the number of elements
			numElements = scan.nextInt();
			
			// gives us list of "easily divisible numbers"
			for (int i = 0; i < numElements; i++)
				ezDivNums.add(scan.nextInt());
			
			// gives us list of a and b values for initial gcd comparison
			for (int i = 0; i < numElements; i++)
			{
				aValues.add(scan.nextBigInteger());
				bValues.add(scan.nextBigInteger());
			}
			
			// determine the gcd for each and store it in scores
			for (int i = 0; i < numElements; i++)
				scores.add(countRecursions(aValues.get(i), bValues.get(i)));
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			scan.close();
		}
		
		
		// print results to an output file
		writeOutput(ezDivNums, scores);
		
	}

}
