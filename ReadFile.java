import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class ReadFile here.
 * 
 * @author Eric Stuppard 
 * @version September 5th, 2015
 */
public class ReadFile
{
    /**
     * Constructor for objects of class ReadFile
     */
    public void readIt(Scanner infile)
    {
        int count = 1;
        HashMap<String,Integer> wordBank = new HashMap<String,Integer>();
        
        while (infile.hasNext())
        {
            String word = infile.next();
            wordBank.put(word,count);
            if (wordBank.containsKey(word)) {
                int thisInt = wordBank.get(word);
                thisInt++;
            }
            System.out.println("WORD: " + word);              
        }
    }
    
    /**
	* BONUS: Writing to a file
	* @param outputFile is the file object for output
	* @param someWords is a list of words to print out
	**/
	public void writeIt(PrintWriter outputFile, ArrayList<String> someWords)
	{
		for (String word: someWords) 
		{
			outputFile.println(word);
		}
	}
    

    public static void main(String [] args)
	{
		if (args.length < 1) {
			System.out.println("You are a bad person. Give a filename to read");
		} else {
			ReadFile mainObject = new ReadFile();
			File fileToRead = new File(args[0]);
			try {
				Scanner in = new Scanner(fileToRead);
				mainObject.readIt(in);
				/* Now demonstrate a PrintWriter for printing a file */
				PrintWriter outFile = new PrintWriter("words.txt");
				ArrayList<String> words = new ArrayList<String>();
				words.add("how");
				words.add("now");
				words.add("brown");
				words.add("cow");
				mainObject.writeIt(outFile,words);
				outFile.close();
			} catch(IOException e) {
				System.out.println("Uh oh, file error! "+ e);
			}

		}
    
        
        if (args.length < 1) {
            System.out.println("Give a valid filename.");
        } else {
            File fileToRead = new File(args[0]);
            try {
                
                Scanner in = new Scanner(fileToRead);
                ReadFile mainObject = new ReadFile();
                mainObject.readIt(in);
                
            } catch(IOException e) {
                System.out.println("File error!");
            }
        }
    
    }
}