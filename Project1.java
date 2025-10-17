/*
 * Name: Khai Nguyen
 * Date: 09-10-2025
 * Task: 
 * 		- Project 1 is about creating a name statistics program that will prompt the user to
 * 		  input a list of names delimited by commas.
 * 		- Then the program will display a list of options for the user to pick from.
 * 		- The program will continue to run and allow the user to select multiple options
 * 		  only exiting when option '0' is selected
 * 
 * 
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 * this is project 1 which turn strings into different ways with 8 options the 9 is to set a new string with out 
 * hitting 0 to stop the program
 * @author Khai Nguyen
 * @version 1.3
 * @since 09-10-2025
 */
public class TestProject1 {

	/**
	 * This is the main method which handles the initial input of string from user 
	 * which then convert to array.
	 * it also handles the options for the switch case from the menu method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please input list of names: ");
		String listNames1 = scnr.nextLine(); //this takes in one line when the user input
		String listNames2 = scnr.nextLine(); //this takes in the second line when the user input
		String listName3 = scnr.nextLine();		
		//this combined the together seperating it with a space since with a comma it would break at the end of the line
		String listNameCombined = listNames1.trim() + " " + listNames2.trim() + " " + listName3.trim(); 
		
		String listNamesCombineArray [] = listNameCombined.split(","); //this turn the combine strings into arrays		
		
		int option = -1;//this is use to capture the user options, use sentinel value since 0 is taken		
		
		while(option != 0)
		{
			option = menu(scnr);
			switch(option) {
			case 1: 
					dListOrdered(listNamesCombineArray);
				break;
			case 2:
					dFullNames(listNamesCombineArray);
					
				break;
				
			case 3:
					dSingleNames(listNamesCombineArray);				
				break;

			case 4:
					dNameStatistics(listNamesCombineArray);
					
				break;
				
			case 5: 
					dNameEvenLength(listNamesCombineArray);
				
				break;
				
			case 6:
					dNameOddLength(listNamesCombineArray);
				
				break;
				
			case 7:
					dNamesNotCapitalized(listNamesCombineArray);
				
				break;
				
			case 8:
					dMostFrequentName(listNamesCombineArray);
				
				break;
				
			case 9:
					listNamesCombineArray = enterNewListNames(scnr); //this pass the scnr wihtou opening another one in the method or in main
				
				break;
				
			case 0:
					System.out.println("GoodBuye!");
				break;
			default:
					System.out.println("invalid option! only 1-9 or 0 to quit!");
				
			}//end switch
			 
		}//end while
	}//end main
//============================================================================================
/**
 * This takes in the input of the users for the option for the menu which then return it to main to go
 * with the correct case
 * @param scnr
 * @return option which is the int that the user entered
 */
public static int menu(Scanner scnr)
{
		System.out.println("\nPlease select an option: ");
		System.out.println("1: Display List Ordered\n" + 
						   "2: Display Full Names\n" +
						   "3: Display Single Names\n" + 
						   "4: Display Name Statistics\n" +
						   "5: Display Names with Even Length\n" +
						   "6: Display Names with Odd Length\n" + 
						   "7: Display Names not capitalized\n" +
						   "8: Display Most Frequent Name\n" +
						   "9: Enter new list of Names\n" +
						   "0: Quit Program\n");
		
		int option = scnr.nextInt();
		return option;
	}//end menu
	
//============================================================================================
/**
 * This method sort the array based on their capital letter, they come first
 * @param listNamesCombineArray
 */
public static void dListOrdered(String listNamesCombineArray[]) //*1*
{
	Arrays.sort(listNamesCombineArray, String.CASE_INSENSITIVE_ORDER);
	String listNamesCombineArraySort = Arrays.toString(listNamesCombineArray);
		
	System.out.println("This is =1=: " + listNamesCombineArraySort);
	//return listNamesCombineArraySort; 
}//end dListOrdered
	
//============================================================================================
/**
 * this method print the full name from the array
 * @param listNamesCombineArray
 */
public static void dFullNames(String listNamesCombineArray[]) //*2*
{
	String listOfFullNames = ""; //this takes in the list of full names
	for(int i = 0; i < listNamesCombineArray.length; i++ )
	{
		String listNamesCombineArrayAti = listNamesCombineArray[i]; //this takes in the element at i in the listNamesCombineArray
		if(listNamesCombineArrayAti.contains(" "))//this check to see if the element at i contains a "space"
		{
			listOfFullNames = listOfFullNames + listNamesCombineArrayAti + ", ";// this set the list of full names to that element
		}//end if
	}//end for
	System.out.println("This is =2=: " + listOfFullNames);
		
}//end dFullName();
	
//============================================================================================
/**
 * this method print the signle name of the array
 * @param listNamesCombineArray
 */
public static void dSingleNames(String listNamesCombineArray[]) //*3*
{
	String listOfSingleNames = "";
	for(int i = 0; i < listNamesCombineArray.length; i++)
	{
		String listNamesCombineArrayAti = listNamesCombineArray[i];
		if(!listNamesCombineArrayAti.contains(" "))
		{
			listOfSingleNames = listOfSingleNames + listNamesCombineArrayAti + ", ";
		}//end if
	}//end for
	System.out.println("This is =3=: " + listOfSingleNames);
		 
}//end dSignleName
	
//============================================================================================
/**
 * This method does 6 things
 * =1= it count the length of the names inside the array
 * =2= it count the letter of the names inside the array
 * =3= it calculate the average length of the names insdie the array
 * =4= it print the shortest names of the array
 * =5= it print the longest names of the array
 * =6= it caluclate the population standard deviation of the names of the array
 * @param listNamesCombineArray
 */
public static void dNameStatistics(String listNamesCombineArray[]) //*4*
{
	int fullNameCount = 0; //this track =2=
	int singleNameCount = 0; //this track =3=
	int letterCount = 0; //this track the letter count
	int totalCount = listNamesCombineArray.length; //this set the totalCount to the length of the array so we can use this to calculate the satndard diviation
		
		
	String shortestNames = listNamesCombineArray[0]; // this set the first element of the listNamesCombineArray to shortestName
	String longestNames = listNamesCombineArray[0];// this set the first element of the listNamesCombineArray to longestName
	int shortestLength = 0; //this takes in the length of the shortest letter
	int longestLength = 0;//this takes in the length of the shortest letter
	
	int nameLengths[] = new int[totalCount];//this stored the length of each name in an int array
	
	for(int u = 0; u < listNamesCombineArray.length; u++)
	{
		String listNamesCombineArrayAti = listNamesCombineArray[u];
	int currentLength = 0;
		
	if(listNamesCombineArrayAti.contains(" "))
	{
			fullNameCount++;
	}//end if
	if(!listNamesCombineArrayAti.contains(" "))
	{
		singleNameCount++;
	}//end if
			
	for(int n = 0; n < listNamesCombineArrayAti.length(); n++) //this loops through the listNamesCombineArrayAti length
	{
		char listNamesCombineArrayAtiCharAt = listNamesCombineArrayAti.charAt(n); //this change the string listNamesCombineArrayAti to c which stored the element at j
		if(Character.isLetter(listNamesCombineArrayAtiCharAt))//this check if the letter at char c is a letter				
		{
			currentLength++;

		}//end if	
	}//end for
			
	nameLengths[u] = currentLength;//this stored the length of each name in an int array 
	letterCount = letterCount + currentLength; //this get the total letter count of the string
			
		
	for(int f = 0; f < shortestNames.length(); f++) // this check and add for the shortest lengthn in the array
	{
		if(Character.isLetter(shortestNames.charAt(f)))
		{
			shortestLength++;
		}//end if
	}//end for
			
	for(int i = 0; i < longestNames.length(); i++)// this check and add for the longest lengthn in the array
	{
		if(Character.isLetter(longestNames.charAt(i)))
		{
			longestLength++;
		}//end if
	}//end for
			
		if(letterCount < shortestLength) //this compare the lettercount to the shorest
		{
			shortestNames = listNamesCombineArrayAti;//this set the first element of the array in shortestname to the one at u
		}//end if
		if(letterCount > longestLength)//this compare the lettercount to the shorest
		{
			longestNames = listNamesCombineArrayAti;//this set the first element of the array in longestnmae to the one at u
		}//end if
	}//end for
		

	totalCount = fullNameCount + singleNameCount; //reset the totalCount to combine the two count into one totalCount variable
	double averageNameLength =  (double) letterCount / totalCount;//this get the avg of name length and cast by double since lettercoutn and tottal count is int
		
	double secondStepStandard = 0.0;
	for(int j = 0; j < totalCount; j ++)
	{
		double thirdStepStandard = nameLengths[j] - averageNameLength;//this is the third step which takes in the nameLength at element j - the averageNameLEngth
		secondStepStandard = secondStepStandard + thirdStepStandard * thirdStepStandard; // this takes in the squared part of each element and the avg count
	}//end for
		
	double fourthStepStandard = Math.sqrt(secondStepStandard / totalCount); //this tkae the square root of the second step / totalCount;
		
		
	System.out.println("This is =4=:  Name Count: " + totalCount);
	System.out.println("	      Letter Count: " + letterCount);
	System.out.printf("	      Avg Name Length: %.2f%n", averageNameLength);
	System.out.println("      	      Shortest Name: " + shortestNames);
	System.out.println("      	      Longest Name: " + longestNames);
		System.out.printf("	      Population Standard Deviation: %.2f%n", fourthStepStandard);	
}//end dNameStatistics
	
//============================================================================================
/**
 * This method print the even names of the array using their letterCount at charAt i
 * @param listNamesCombineArray
 */
public static void dNameEvenLength(String listNamesCombineArray[]) //*5*
{	
	for(int i = 0; i < listNamesCombineArray.length; i++)
	{
		int letterCount2 = 0; //this track the letter count
		String evenName = listNamesCombineArray[i]; //this set the evenName string to the i th element in the listNamesCombienArray
		for(int j = 0; j < evenName.length(); j++)
		{
			char evenNameChar = evenName.charAt(j);
			if(Character.isLetter(evenNameChar))//this check if the element in the evenNameChar is a letter
			{
				letterCount2++;//this  increment letterCount2 if it is a letter
			}//end if
		}//end for
		if(letterCount2 % 2 == 0)//this check if the count is even and prints that element
		{
			System.out.println(evenName);
		}//end if
	}//end for
}//end dNameEvenLength
	
//============================================================================================
/**
 * This method print the odd names of the array using their letterCount at charAt i
 * @param listNamesCombineArray
 */
public static void dNameOddLength(String listNamesCombineArray[]) //*6*
{
	for(int i = 0; i < listNamesCombineArray.length; i++)
	{
		int letterCount3 = 0;
		String oddName = listNamesCombineArray[i];
		for(int j = 0; j < oddName.length(); j++)
		{
			char evenNameChar = oddName.charAt(j);
			if(Character.isLetter(evenNameChar))
			{
				letterCount3++;
			}//end if
		}//end for
		if(letterCount3 % 2 == 1) //this check if the element is odd and pritns that element
		{
			System.out.println(oddName);
		}//end if
	}//end for
}//end dNameOddLength	

//============================================================================================
/**
 * this print the non capitalize letter of the array
 * @param listNamesCombineArray
 */
public static void dNamesNotCapitalized(String listNamesCombineArray[]) //*7*
{
	for(int i = 0; i < listNamesCombineArray.length; i++)
	{
		String listName = listNamesCombineArray[i].trim(); //this takes in the array and trim it so it doesnt have any spaces at the end or beginning 
		String listSplit[] = listName.split(" ");// this split the array wiht a space
		
		for(int j = 0; j < listSplit.length; j++)
		{
			String listPart = listSplit[j].trim();
			if(listPart.length() > 0 && Character.isLowerCase(listPart.charAt(0))) //This is the listPart length is greater than 0 and the character at in listPart is lowercase.
			{
				System.out.println(listPart);
			}//end if
		}//end for
	}//end for
}//end dNamesNotCapitalized

//============================================================================================
/**
 * this print the most frequent names
 * @param listNamesCombineArray
 */
public static void dMostFrequentName(String listNamesCombineArray[]) //*8*
{
	String listNameMostFrequent = ""; //this will hold the most frequent name
	int count4 = 1; //this hold the base count of the names being repeated. 
	for(int i = 0; i< listNamesCombineArray.length; i++)//this loop through the i th element
	{
		int count5 = 0; //this increment the number of times a name is repeated
		for(int j = 0; j < listNamesCombineArray.length; j++) //this loop through he j th element
		{
			if(listNamesCombineArray[i].trim().equalsIgnoreCase(listNamesCombineArray[j].trim())) //this check the i th array with the j th array while ignoring the lower and uppercase.
			{
				count5++;
			}//end if
		}//end for
		if(count5 > count4) //this check witht eh base case where if the name is repeated more than onece the count5 would incremenet and check againsta the base case of 1
		{
			count4 = count5; //this set the base case to the current count
			listNameMostFrequent = listNamesCombineArray[i].trim(); //this set the element at i to listNamesMostFrequent
		}//end if
	}//end for
	if(count4 == 1) //this check the base case if its the base case. meaning at 1 where 0 names repeat
	{
		System.out.println("No Most Frequent Name");
	}
	else //if the base case is not 0, then print the name
	{
		System.out.println("Most Frequent Name: " + listNameMostFrequent);
	}//end else
}// end dMostFrequentName
	
//============================================================================================
/**
 * this takes in scnr and create a new string input for the user and return it into main so it can be 
 * set to with the first array when user select 9.
 * @param scnr
 * @return newListNameCombine ^^
 */
public static String[] enterNewListNames(Scanner scnr) //*9*
{
	System.out.println("Please enter new name =9=: ");
	
	// line 342-346 just like in main new scanner but this time its in the method not in main
	String newListNames1 = scnr.nextLine();
	String newListNames2 = scnr.nextLine();
	String newListNames3 = scnr.nextLine();
	
	String newListNameCombined = newListNames1.trim() + " " + newListNames2.trim() + " " + newListNames3.trim(); //same as in main, take in three string(line) and trim the space before and after
	String newListNameCombine[] = newListNameCombined.split(",");//turn it into array
	
	for(int i = 0; i < newListNameCombine.length; i++)
	{
		newListNameCombine[i] = newListNameCombine[i].trim();//set the new list at i
	}//end for

	return newListNameCombine;//return it to main to be merged to the old list variable
	
}//end enterNewListNames

}//end class
