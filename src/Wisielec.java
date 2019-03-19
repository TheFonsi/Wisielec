import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Wisielec
{
	private static int lines = 0;
	private static File file = new File("slownik.txt");
	
	public static void main(String[] args)
	{
		lines = getLinesOfFile(file);
		Game.start();
	}
	
	public static String getRandomWord()
	{
		try
		{
			Scanner sc = new Scanner(file);
			int r = new Random().nextInt(lines);
			String cWord = "";
			
			for(int i = 0; sc.hasNextLine(); i++)
			{
				cWord = sc.next();
				if(i == r)
				{
					break;
				}
			}
			return cWord;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku: "+ file.getAbsolutePath());
		}
		return null;
	}
	
	public static int getLinesOfFile(File file)
	{
		int lines = 0;
		try
		{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				sc.next();
				lines++;
			}
			sc.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku: "+ file.getAbsolutePath());
		}
		return lines;
	}

	public static int getDifferentCharacters(String word)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < word.length(); i++)
		{
			map.put(word.charAt(i), i);
		}
		
		return map.size();
	}
}