import java.util.Scanner;

public class SeaBattleGame {

	static byte N = 7;
	static PlayingField field = new PlayingField();

	public static void main(String[] args) {
		field.createField();
		byte num_ships = 3;
		Ship[] ships = new Ship[num_ships];
		String[] names = {"Арсения", "Матвея", "Дарика"};
		for (byte i = 0; i < num_ships; i++) {
			ships[i] = new Ship();
			ships[i].createShip(names[i]);
		}


		System.out.println("  A B C D E F G                       A B C D E F G");
		for (byte x = 0; x < N; x++) {
			System.out.printf("%d ",x+1);
			for (byte y = 0; y < N; y++) {
				System.out.print("o ");
			}
			System.out.print("                    ");
			System.out.printf("%d ",x+1);
			for (byte y = 0; y < N; y++) {
				if (field.getBool(x, y)) {
					System.out.print("x ");
				} else {
					System.out.print("o ");
				}
			}
			System.out.printf("\n");
		}
		System.out.printf("\nОбразец координат: 'A 1'\n\n");


		boolean end = false;
		byte endCounter = 0;
		while (!end) {
			try {
				byte[] coors = new byte[2];
				coors = SeaBattleGame.getCoors();
				if (field.getBool(coors[0], coors[1])) {
					System.out.println("Попал!");
					for (byte i = 0; i < num_ships; i++) {
						byte counter = 0;
						for (byte j = 0; j < 3; j++) {
							if (ships[i].coors[j][0] == coors[0] && ships[i].coors[j][1] == coors[1]) {
								field.setBool(ships[i].coors[j][0], ships[i].coors[j][1], (byte) 0);
								for (byte k = 0; k < 3; k++) {
									if (!field.getBool(ships[i].coors[k][0], ships[i].coors[k][1])) {
										counter++;
									}
								}
								if (counter == 3) {
									System.out.printf("Потопил %s\n", ships[i].name);
									endCounter++;
								}
								if (endCounter == 3) {
									end = true;
								}
							}
						}
					}
					System.out.println(" ");
				}
				else {
					System.out.printf("Мимо!\n\n");
				}
			} catch (Exception e) {
				System.out.printf("Введены некорректные данные!\n\n");
			}
		}
		System.out.println("Ты победил!");
	}

	static byte[] getCoors() {
		byte x;
		byte y = 0;
		System.out.print("Введите координаты: ");
		Scanner scan = new Scanner(System.in);
		String strCoors = scan.nextLine();
		char[] charsX = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L'};
		for (byte i = 0; i < N; i++) {
			if (strCoors.charAt(0) == charsX[i]) {
				y = i;
			}
		}
		x = (byte) ((Integer.parseInt(String.valueOf(strCoors.charAt(2)))) - 1);
		byte[] coors = {x, y};
		return coors;
	}
}


class Ship {

	byte N = SeaBattleGame.N;
	PlayingField field = SeaBattleGame.field;

	String name;
    byte[][] coors;

	void createShip(String nick) {
		name = nick;
		boolean end = false;
		while(!end) {
			byte x = (byte) (Math.random() * N);
			byte y = (byte) (Math.random() * N);
			byte cardinal_point = (byte) (Math.random() * 4);
			// 0 : N
			// 1 : E
			// 2 : S
			// 3 : W
			try {
				if ((cardinal_point == 0) && (field.getBool(x, y) == field.getBool(x, (byte) (y-1)) == field.getBool(x, (byte) (y-2)) == false)){
					field.setBool(x, y, (byte) 1);
					field.setBool(x, (byte) (y-1) ,(byte) 1);
					field.setBool(x, (byte) (y-2) ,(byte) 1);
					byte[][] coors_copy = {{x, y}, {x, (byte) (y-1)}, {x, (byte)(y-2)}};
					coors = coors_copy;
					end = true;}
				else{if ((cardinal_point == 1) && (field.getBool(x, y) == field.getBool((byte) (x+1), y) == field.getBool((byte) (x+2), y) == false)){
					field.setBool(x, y, (byte) 1);
					field.setBool((byte) (x+1), y ,(byte) 1);
					field.setBool((byte) (x+2), y ,(byte) 1);
					byte[][] coors_copy = {{x, y}, {(byte) (x+1), y}, {(byte) (x+2), y}};
					coors = coors_copy;
					end = true;}
				else{if ((cardinal_point == 2) && (field.getBool(x, y) == field.getBool(x, (byte) (y+1)) == field.getBool(x, (byte) (y+2)) == false)){
					field.setBool(x, y, (byte) 1);
					field.setBool(x, (byte) (y+1) ,(byte) 1);
					field.setBool(x, (byte) (y+2) ,(byte) 1);
					byte[][] coors_copy = {{x, y}, {x, (byte) (y+1)}, {x, (byte) (y+2)}};
					coors = coors_copy;
					end = true;}
				else{if ((cardinal_point == 3) && (field.getBool(x, y) == field.getBool((byte) (x-1), y) == field.getBool((byte) (x-2), y) == false)){
					field.setBool(x, y, (byte) 1);
					field.setBool((byte) (x-1), y ,(byte) 1);
					field.setBool((byte) (x-2), y ,(byte) 1);
					byte[][] coors_copy = {{x, y}, {(byte) (x-1), y}, {(byte) (x-2), y}};
					coors = coors_copy;
					end = true;}
				}}}
			}
			catch (Exception e) {

			}
		}
	}
}


class PlayingField
{
	private byte N = SeaBattleGame.N; // size: N x N
	private boolean[][] table = new boolean[N][N];

	void createField() {
		for (byte x = 0; x < N; x++)
		{
			table[x] = new boolean[N];
			for (byte y = 0; y < N; y++)
			{
				table[x][y] = false;
			}
		}
	}

	void setBool(byte x, byte y, byte bool) { // coors = {x, y, 0/1 (int boolean)}
		if (bool == 0){
			table[x][y] = false;
		}
		else {
			table[x][y] = true;
		}
	}

	public boolean getBool(byte x, byte y) {
		return table[x][y];
	}
}

