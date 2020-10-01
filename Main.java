import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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


	// Class to hold the gcd output
	public static class gcdPack
	{
		// public member variables
		boolean isGood;
		int score;

		// Constructor
		public gcdPack()
		{
			isGood = true;
			this.score = 0;
		}

		// Parameterized Constructor
		public gcdPack(int score, boolean isGood)
		{
			this.isGood = isGood;
			this.score = score;
		}
	}

	// gcd method using gcd output to analyze the results
	/**
	 * Method to return the "score" of a recursive algorithm
	 * @param a = one value to determine gcd
	 * 	@param b = another value to determine gcd
	 * @param div = divisor as a string to create a bigInteger
	 * @return
	 * 				= the score of the recursive algorithm
	 */
	public static int gcd(BigInteger a, BigInteger b, String div)
	{
		int score = 0;
		BigInteger divisor = new BigInteger(div);
		//		boolean aGood = true;
		//		boolean bGood = true;
		//		gcdOutput temp = new gcdOutput();

		//		while (aGood || bGood)
		//		{
		// if a % divisor == 0 && b % divisor == 0
		if (a.mod(divisor).compareTo(BigInteger.ZERO) == 0
				&& b.mod(divisor).compareTo(BigInteger.ZERO) == 0)
		{
			//			score += 3 * gcd(a.divide(new BigInteger("3")),
			//					            b.divide(new BigInteger("3")), score);

			//			score += 3 * 2;

			a = a.divide(divisor);
			b = b.divide(divisor);
			score += 2;
			//			temp.score = 2;
			//			temp = gcd(a, b, divisor.toString());
			//			temp.score *= divisor.intValue();
			//System.out.println("Score + 2" + a + ","+ b);
			return score +=  gcd(a, b, divisor.toString());
		}


		// if only b % divisor == 0
		if (b.mod(divisor).compareTo(BigInteger.ZERO) == 0)
		{
			b = b.divide(divisor);
			score+=1;
			//			 temp = gcd(a, b, divisor.toString());
			return score += gcd(a, b, divisor.toString());
		}

		// if only a % divisor == 0
		if (a.mod(divisor).compareTo(BigInteger.ZERO) == 0)
		{
			a = a.divide(divisor);
			score+=1;
			//			temp = gcd(a,b, divisor.toString());
			return score += gcd(a, b, divisor.toString());
		}

		//		else {
		//			return gcd(a.max(b).subtract(a.min(b)), a.min(b), divisor.toString());
		//		}
		// base case
		System.out.println("Base case" + a + ","+ b);
		return 0;

		//		else
		//				return 0;

		//		else
		//		{
		//			return gcd(a.max(b).subtract(a.min(b)), a.min(b), divisor.toString());
		//		}

		//		Math.log10(a.max(b)a.doubleValue());


		//		BigInteger max = a.max(b);
		//		BigInteger min = max.compareTo(a) == 0 ? b : a;
		//		double score1  = 0; // max
		//		double score2 = 0; // min
		//		double score3 = 0; // divisor
		//		double temp = 0;
		//		
		//		score1  =  Math.log10(max.doubleValue());
		//		score2 =  Math.log10(min.doubleValue());
		//		score3 =  Math.log10(divisor.doubleValue());
		//		
		//		temp = score1 % score3;
		//		score += temp == 0 ? score1 / score3 :  0;
		//		
		//		if (temp != 0)
		//			while(max.mod(divisor) == BigInteger.ZERO)
		//			{
		//				score+= 1;
		//				max = max.divide(divisor);
		//			}
		//				
		//			
		//		temp = score2 %  score3;
		//		score += temp == 0 ? score2 / score3 : 0;
		//		
		//		if (temp != 0)
		//			while(min.mod(divisor) == BigInteger.ZERO)
		//			{
		//				score+=1;
		//				min = min.divide(divisor);
		//			}
		//
		//		









		//		else
		//			bGood = false;

		//		else if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0 &&
		//			      	b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) != 0)
		//		{
		////			score += gcd(a.divide(new BigInteger("3")), b, score);
		//			score += 1;
		//			a = a.divide(new BigInteger("3"));
		//		}
		//		
		//		else if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) != 0 &&
		//			      b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0)
		//		{
		////			score += gcd(a, b.divide(new BigInteger("3")), score);
		//			score += 1;
		//			b = b.divide(new BigInteger("3"));
		//		}
		//		
		//		
		//		// not computing the gcd simply implement the algorithm 
		//		// he put on the page and calculate the score
		//		if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0 &&
		//			b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0)
		//		{
		////			score += 3 * gcd(a.divide(new BigInteger("3")),
		////					            b.divide(new BigInteger("3")), score);
		//			
		//			score += 3 * 2;
		//			a = a.divide(new BigInteger("3"));
		//		    b = b.divide(new BigInteger("3"));
		//		}
		//		
		//		else if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0 &&
		//			      	b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) != 0)
		//		{
		////			score += gcd(a.divide(new BigInteger("3")), b, score);
		//			score += 1;
		//			a = a.divide(new BigInteger("3"));
		//		}
		//		
		//		else if (a.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) != 0 &&
		//			      b.mod(new BigInteger("3")).compareTo(BigInteger.ZERO) == 0)
		//		{
		////			score += gcd(a, b.divide(new BigInteger("3")), score);
		//			score += 1;
		//			b = b.divide(new BigInteger("3"));
		//		}









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
		//		}

		//		return 0;
	}


	public static gcdPack gcd(BigInteger a, BigInteger b, BigInteger div, boolean isGood)
	{
		gcdPack temp = new gcdPack(0, isGood);

		// 1. ------------------------------------------------------------------------
		// if a == 0 or b == 0 or they are both 0
		if (a.compareTo(BigInteger.ZERO) == 0
				|| b.compareTo(BigInteger.ZERO) == 0)
		{
			return new gcdPack(0, false); // no score
		}

		// 2. --------------------------------------------------------------------
		// if a % divisor == 0 && b % divisor == 0
		if (a.mod(div).compareTo(BigInteger.ZERO) == 0
				&& b.mod(div).compareTo(BigInteger.ZERO) == 0)
		{		
			a = a.divide(div);
			b = b.divide(div);
			temp = gcd(a, b, div, isGood);
			temp.score += 2;
			return temp;
		}


		// if only b % divisor == 0
		if (b.mod(div).compareTo(BigInteger.ZERO) == 0 && isGood)
		{
			b = b.divide(div);
			temp = gcd(a, b, div, isGood);
			temp.score += 1;
			return temp;
		}

		// if only a % divisor == 0
		if (a.mod(div).compareTo(BigInteger.ZERO) == 0 && isGood)
		{
			a = a.divide(div);
			temp = gcd(a, b, div, isGood);
			temp.score += 1;
			return temp;
		}


		// 5. ---------------------------------------------------------------------
		// "if we reach this point" .....
		//		a = a.max(b).subtract(a.min(b));
		//		b = a.min(b);

		else
		{
			// get rid of the unnecessary function calls on the stack
			while(a.mod(div).compareTo(BigInteger.ZERO) != 0
			   || b.mod(div).compareTo(BigInteger.ZERO) != 0)
			{
				BigInteger tempA = a.max(b).subtract(a.min(b)).divide(div);
				BigInteger tempB = a.min(b);
				a = tempA;
				b = tempB;
				temp.score += 1;
				
				if (tempA.compareTo(div) <= 0
				 || tempB.compareTo(div) <= 0)
				{
					return new gcdPack(0, false); // no score 
				}  
				
				// if a == 0 or b == 0 or they are both 0
				if (a.compareTo(BigInteger.ZERO) == 0
						|| b.compareTo(BigInteger.ZERO) == 0)
				{
					return new gcdPack(0, false); // no score
				}
			}

			return gcd(a.max(b).subtract(a.min(b)), a.min(b), div, false);
		}

		//return new gcdPack(0, false);
	}

	/**
	 * Method to return the "score" of a recursive algorithm
	 * @param a = one value to determine gcd
	 * 	@param b = another value to determine gcd
	 * @param div = divisor as a string to create a bigInteger
	 * @return
	 * 				= the score of the recursive algorithm
	 */
	public static gcdOutput gcdO(BigInteger a, BigInteger b, String div)
	{
		int score = 0;
		BigInteger divisor = new BigInteger(div);
		//		boolean aGood = true;
		//		boolean bGood = true;
		gcdOutput output = new gcdOutput();

		//		while (aGood || bGood)
		//		{
		// if a % divisor == 0 && b % divisor == 0
		if (a.mod(divisor).compareTo(BigInteger.ZERO) == 0
				&& b.mod(divisor).compareTo(BigInteger.ZERO) == 0)
		{		
			a = a.divide(divisor);
			b = b.divide(divisor);
			//			score += 2;
			//			temp.score = 2;
			//			temp = gcd(a, b, divisor.toString());
			//			temp.score *= divisor.intValue();
			//System.out.println("Score + 2" + a + ","+ b);
			output.score +=  2 + gcdO(a, b, divisor.toString()).score;
			//			return output;
		}


		// if only b % divisor == 0
		if (b.mod(divisor).compareTo(BigInteger.ZERO) == 0)
		{
			b = b.divide(divisor);
			//			 score+=1;
			//			 temp = gcd(a, b, divisor.toString());
			output.score += 1 + gcdO(a, b, divisor.toString()).score;
			//			 return output;
		}

		// if only a % divisor == 0
		if (a.mod(divisor).compareTo(BigInteger.ZERO) == 0)
		{
			a = a.divide(divisor);
			//			score+=1;
			//			temp = gcd(a,b, divisor.toString());
			output.score += 1 + gcdO(a, b, divisor.toString()).score;
			//			 return output;
		}

		//		else {
		//			return gcd(a.max(b).subtract(a.min(b)), a.min(b), divisor.toString());
		//		}
		// base case
		//		System.out.println("Base case" + a + "\n"+ b);

		return output;
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
		File inFile = new File("inputTest.txt");
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

			// create an array of scores and initialize to 0
			scores = new Integer[numElements];
			Arrays.fill(scores, 0);

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
			//			for (int i = 0; i < numElements; i++)
			//				scores.add(gcd(aValues.get(i), bValues.get(i), ezDivNums.get(i).toString()));

			// gcd output
			//			gcdOutput output = new gcdOutput();
			//			int output = 0;
			gcdPack output = new gcdPack();

			// determine the gcd score of one statement executed through for each set of divisible numbers
			// s = gcd statement number index
			// d = each easily divisible number index
			for(int s = 0; s < numElements; s++)
			{
				for (int d = 0; d < numElements; d++)
				{
					output = gcd(aValues.get(d),bValues.get(d), new BigInteger(ezDivNums.get(s).toString()), true);
					//output = gcdO(aValues.get(s),bValues.get(s), ezDivNums.get(d).toString());

					// update values
					scores[s] += output.score;
					//					System.out.println("\n" + aValues.get(s) + "\n" + bValues.get(s) + "\ndiv by" + ezDivNums.get(d)
					//					" gave us: " );
					//					scores[d] += output;
					//					aValues.set(s, output.newA);
					//					bValues.set(s, output.newB);
				}
			}


			// output test
			for (int i = 0; i < numElements; i++)
			{
				System.out.print(ezDivNums.get(i) + " " + scores[i] + "\n");
			}

			//			// print test
			//			for (Integer Int : scores)
			//				System.out.print(Int);

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