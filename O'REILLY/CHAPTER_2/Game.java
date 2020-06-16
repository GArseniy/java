public class Game 
{
	public static void main(String[] args) 
	{
		byte n = 3;
		byte diapason = 9;
		Gamer[] gamers = new Gamer[n];
		for (byte i = 0; i < n; i++) 
		{
			gamers[i] = new Gamer();
		}
		byte number = (byte) ( Math.random() * diapason);
		System.out.printf("%d is hidden number...\n", number);
		System.out.println("Today our players will guess it");
		boolean end = false;
		while (!end) 
		{
			for (byte i = 0; i < n; i++)
			{
				gamers[i].setNum();
				System.out.printf("Player %d chooses number: %d\n", i + 1, gamers[i].getNum());
			}
			for (byte i = 0; i < n; i++) 
			{
				if (number == gamers[i].getNum()) 
				{
					end = true;
					System.out.printf("Player %d won!\n", i + 1);
				}
			}
			if (!end) 
			{
				System.out.println("No one guessed...");
			}
		}
		System.out.println("The game is over! Congratulations to the winners!");
	}
}
class Gamer 
{
	byte diapason = 9;
	private byte num;
	

	byte getNum() 
	{
		return num;
	}

	void setNum() 
	{
		num = (byte) (Math.random() * diapason);
	}
}

