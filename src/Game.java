import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	private static String word;
	private static String hiddenWord;
	private static ArrayList<Character> usedChar = new ArrayList<Character>();
	private static int differentCharacters = 0;
	private static int chance = 7;

	public static void start()
	{
		word = Wisielec.getRandomWord();
		hiddenWord = getHiddenWord();
		differentCharacters = Wisielec.getDifferentCharacters(word);
		
		sendStartMessage();
		
		while(chance != 0)
		{
			char litera;
			Scanner odczyt = new Scanner(System.in);
			
			if(odczyt.hasNext())
			{
				String znak = odczyt.next();
				if(znak.length() == 1)
				{
					litera = znak.charAt(0);
					
					if(!usedChar.contains(litera) && word.indexOf(litera) >= 0)
					{
						correctly(litera);
						if(isWin())
						{
							odczyt.close();
							return;
						}
					}
					else
					{
						incorrectly();
					}
				}
				else
				{
					incorrectly();
					System.out.println("To nie jest 1 znak!");
				}
			}
		}
	}
	
	public static boolean isWin()
	{
		if(differentCharacters == usedChar.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void sendStartMessage()
	{
		printGraphWithTag(chance);
		System.out.println("#####################################");
		System.out.println("# Hasło: "+hiddenWord + "\n#");
		System.out.println("# Twoje hasło składa się z " + word.length() + " znaków,\n# spróbuj je odgadnąć!\n# Możesz skuć tylko 6 razy.\n# Powodzenia!\n#");
		System.out.println("# Wprowadź literę...");
		System.out.println("#####################################");
	}
	
	public static String getHiddenWord()
	{
		String text = "";
		for(int i = 0; i< word.length(); i++)
		{
			text = text.concat("_");
		}
		
		return text;
	}
	
	public static void addCharToHiddenWord(char c)
	{
		char[] hiddenW = new char[word.length()];
		hiddenW = hiddenWord.toCharArray();
		
		for(int i = 0; i< word.length(); i++)
		{
			if(word.charAt(i) == c)
			{
				hiddenW[i] = c;
			}
		}
		
		hiddenWord = String.valueOf(hiddenW);
	}
	
	
	public static void correctly(char word)
	{
		addCharToHiddenWord(word);
		usedChar.add(word);
		printGraphWithTag(chance);
		System.out.println("#####################################");
		System.out.println("# Hasło: " + hiddenWord + "\n#");
		System.out.println("# Trafione!\n# Pozostało tobie: "+ chance + " szans!");
		if(!isWin())
		{
			System.out.println("#\n# Wprowadź kolejną literę...");
		}
		else
		{
			System.out.println("#\n# Gratulacje!\n# Odgadłeś/aś hasło!");
		}
		System.out.println("#####################################");
	}
	
	public static void incorrectly()
	{
		chance--;
		
		printGraphWithTag(chance);
		
		System.out.println("#####################################");
		System.out.println("# Hasło: " + hiddenWord + "\n#");
		if(chance != 0)
		{
			System.out.println("# BŁĄD!\n# Pozostało tobie: "+ chance + " szans!\n# Wprowadź kolejną literę...");
		}
		else
		{
			System.out.println("# Błąd!\n# Wykorzystano wszystkie szanse!\n# Nie odgadnięto hasła: " + word + "\n# Przegrana :(");
		}
		System.out.println("#####################################");
	}
	
	public static void printGraphWithTag(int chance)
	{
		switch(chance)
		{
			case 7:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /\n" + 
						"| |/ /\n" + 
						"| | /\n" + 
						"| |/\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"\"\"\"\"\"\"\"\"\"\"|         |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 6:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\n" + 
						"| |/ /       ||\n" + 
						"| | /        ||\n" + 
						"| |/         ||\n" + 
						"| |          ||\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |               \n" + 
						"| |               \n" + 
						"| |               \n" + 
						"| |                \n" + 
						"\"\"\"\"\"\"\"\"\"\"|         |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 5:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\r\n" + 
						"| |/ /       ||\r\n" + 
						"| | /        ||.-''.\r\n" + 
						"| |/         |/  _  \\\r\n" + 
						"| |          ||  `/,|\r\n" + 
						"| |          (\\\\`_.'\r\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |\n" + 
						"| |               \n" + 
						"| |               \n" + 
						"| |               \n" + 
						"| |                \n" + 
						"\"\"\"\"\"\"\"\"\"\"|         |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 4:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\r\n" + 
						"| |/ /       ||\r\n" + 
						"| | /        ||.-''.\r\n" + 
						"| |/         |/  _  \\\r\n" + 
						"| |          ||  `/,|\r\n" + 
						"| |          (\\\\`_.'\r\n" + 
						"| |         .-`--'.\n" + 
						"| |           . . \n" + 
						"| |          |   |\n" + 
						"| |          | . |\n" + 
						"| |          |   |\n" + 
						"| |            '  \r\n" + 
						"| |               \r\n" + 
						"| |               \r\n" + 
						"| |               \r\n" + 
						"| |                \n" + 
						"\"\"\"\"\"\"\"\"\"\"|         |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 3:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\r\n" + 
						"| |/ /       ||\r\n" + 
						"| | /        ||.-''.\r\n" + 
						"| |/         |/  _  \\\r\n" + 
						"| |          ||  `/,|\r\n" + 
						"| |          (\\\\`_.'\r\n" + 
						"| |         .-`--'.\r\n" + 
						"| |           . . Y\\\r\n" + 
						"| |          |   | \\\\\r\n" + 
						"| |          | . |  \\\\\r\n" + 
						"| |          |   |   (`\r\n" + 
						"| |            '  \r\n" + 
						"| |               \r\n" + 
						"| |               \r\n" + 
						"| |               \r\n" + 
						"| |                \n" + 
						"\"\"\"\"\"\"\"\"\"\"|         |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 2:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\r\n" + 
						"| |/ /       ||\r\n" + 
						"| | /        ||.-''.\r\n" + 
						"| |/         |/  _  \\\r\n" + 
						"| |          ||  `/,|\r\n" + 
						"| |          (\\\\`_.'\r\n" + 
						"| |         .-`--'.\r\n" + 
						"| |        /Y . . Y\\\r\n" + 
						"| |       // |   | \\\\\r\n" + 
						"| |      //  | . |  \\\\\r\n" + 
						"| |     ')   |   |   (`\r\n" + 
						"| |            '  \r\n" + 
						"| |               \r\n" + 
						"| |               \r\n" + 
						"| |               \r\n" + 
						"| |                \n" + 
						"\"\"\"\"\"\"\"\"\"\"|         |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 1:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\r\n" + 
						"| |/ /       ||\r\n" + 
						"| | /        ||.-''.\r\n" + 
						"| |/         |/  _  \\\r\n" + 
						"| |          ||  `/,|\r\n" + 
						"| |          (\\\\`_.'\r\n" + 
						"| |         .-`--'.\r\n" + 
						"| |        /Y . . Y\\\r\n" + 
						"| |       // |   | \\\\\r\n" + 
						"| |      //  | . |  \\\\\r\n" + 
						"| |     ')   |   |   (`\r\n" + 
						"| |            '||\r\n" + 
						"| |             ||\r\n" + 
						"| |             ||\r\n" + 
						"| |             ||\r\n" + 
						"| |             | \\\r\n" + 
						"\"\"\"\"\"\"\"\"\"\"|     `-' |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
			case 0:
				printTAG();
				System.out.println(" ___________.._______\r\n" + 
						"| .__________))______|\r\n" + 
						"| | / /      ||\r\n" + 
						"| |/ /       ||\r\n" + 
						"| | /        ||.-''.\r\n" + 
						"| |/         |/  _  \\\r\n" + 
						"| |          ||  `/,|\r\n" + 
						"| |          (\\\\`_.'\r\n" + 
						"| |         .-`--'.\r\n" + 
						"| |        /Y . . Y\\\r\n" + 
						"| |       // |   | \\\\\r\n" + 
						"| |      //  | . |  \\\\\r\n" + 
						"| |     ')   |   |   (`\r\n" + 
						"| |          ||'||\r\n" + 
						"| |          || ||\r\n" + 
						"| |          || ||\r\n" + 
						"| |          || ||\r\n" + 
						"| |         / | | \\\r\n" + 
						"\"\"\"\"\"\"\"\"\"\"|_`-' `-' |\"\"\"|\r\n" + 
						"|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\r\n" + 
						"| |        \\ \\        | |\r\n" + 
						": :         \\ \\       : :  \r\n" + 
						". .          `'       . .\n");
				break;
		}
	}
	
	public static void printTAG()
	{
		System.out.println(" __      __                          ___                      ____                \r\n" + 
				"/\\ \\  __/\\ \\  __          __        /\\_ \\                    /\\  _`\\              \r\n" + 
				"\\ \\ \\/\\ \\ \\ \\/\\_\\    ____/\\_\\     __\\//\\ \\      __    ___    \\ \\ \\L\\ \\  __  __    \r\n" + 
				" \\ \\ \\ \\ \\ \\ \\/\\ \\  /',__\\/\\ \\  /'__`\\\\ \\ \\   /'__`\\ /'___\\   \\ \\  _ <'/\\ \\/\\ \\   \r\n" + 
				"  \\ \\ \\_/ \\_\\ \\ \\ \\/\\__, `\\ \\ \\/\\  __/ \\_\\ \\_/\\  __//\\ \\__/    \\ \\ \\L\\ \\ \\ \\_\\ \\  \r\n" + 
				"   \\ `\\___x___/\\ \\_\\/\\____/\\ \\_\\ \\____\\/\\____\\ \\____\\ \\____\\    \\ \\____/\\/`____ \\ \r\n" + 
				"    '\\/__//__/  \\/_/\\/___/  \\/_/\\/____/\\/____/\\/____/\\/____/     \\/___/  `/___/> \\\r\n" + 
				"                                                                            /\\___/\r\n" + 
				"                                                                            \\/__/ \r\n" + 
				" ____                                  __      ____         \r\n" + 
				"/\\  _`\\                         __    /\\ \\    /\\  _`\\       \r\n" + 
				"\\ \\ \\/\\ \\     __     __  __  __/\\_\\   \\_\\ \\   \\ \\ \\L\\_\\     \r\n" + 
				" \\ \\ \\ \\ \\  /'__`\\  /\\ \\/\\ \\/\\ \\/\\ \\  /'_` \\   \\ \\ \\L_L     \r\n" + 
				"  \\ \\ \\_\\ \\/\\ \\L\\.\\_\\ \\ \\_/ \\_/ \\ \\ \\/\\ \\L\\ \\   \\ \\ \\/, \\__ \r\n" + 
				"   \\ \\____/\\ \\__/.\\_\\\\ \\___x___/'\\ \\_\\ \\___,_\\   \\ \\____/\\_\\\r\n" + 
				"    \\/___/  \\/__/\\/_/ \\/__//__/   \\/_/\\/__,_ /    \\/___/\\/_/");
	}
}