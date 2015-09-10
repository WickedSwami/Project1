import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

/**
 * Write a description of class ReadFile here.
 * 
 * @author Eric Stuppard 
 * @version September 5th, 2015
 */
public class ReadFile
{
    private double totalWordCount = 0.00;
    private ArrayList<String> words = new ArrayList<String>();
    
    /**
     * Constructor for objects of class ReadFile
     */
    public void readIt(Scanner infile)
    {
               
        while (infile.hasNext())
        {
            totalWordCount++;
            String word = infile.next();
            words.add(word);
            
            System.out.println(word);
        }
        
        System.out.println(totalWordCount);
    }
    
    /**
    * BONUS: Writing to a file
    * @param outputFile is the file object for output
    * @param someWords is a list of words to print out
    **/
    public void writeIt(PrintWriter outputFile, HashMap<String,Integer> someWords)
    {
        outputFile.println("<html>");
		outputFile.println("<body>");
		
        for (String word: someWords.keySet()){
                       
            outputFile.println(word);
        }
        
        outputFile.println("</html>");
		outputFile.println("</body>");
    }
    
    
    public ArrayList<String> getWords()
    {
        return words;
    }
    
    public double getWordCount()
    {
        return totalWordCount;
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
                PrintWriter outFile = new PrintWriter("WickedWords.html");
                HashMap<String,Integer> wordBank = new HashMap<String,Integer>();
                int wordCount = 0;
                
                ArrayList<String> myWords = mainObject.getWords();
                for (String word : myWords) {
                    if (wordBank.get(word)!=null) {
                        wordCount = wordBank.get(word);
                        wordCount++;
                    }
                    
                    
                }
                mainObject.writeIt(outFile,wordBank);
                outFile.close();
            } catch(IOException e) {
                System.out.println("Uh oh, file error! "+ e);
            }

        }
    
    }
}