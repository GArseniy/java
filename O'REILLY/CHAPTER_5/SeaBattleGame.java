public class SeaBattleGame {

	static byte N = 7;
	static PlayingField field = new PlayingField();

	public static void main(String[] args) {
		field.createField();
		byte num_ships = 3;
		Ship[] ships = new Ship[num_ships];
		String[] names = {"Arseny", "Motya", "Sidart"};
		for (byte i = 0; i < num_ships; i++) {
			ships[i] = new Ship();
			ships[i].createShip(names[i]);
		}
		for (byte x = 0; x < N; x++) {
			for (byte y = 0; y < N; y++) {
				System.out.print(field.getBool(x, y));
				System.out.print(" ");
			}
			System.out.printf("\n");
		}
		for (byte i = 0; i < num_ships; i++) {
			System.out.print(i);
			System.out.print(" корабль: ");
			for (byte j = 0; j < 6; j++) {
				System.out.print(ships[i].coors[j]);
				System.out.print(" ");
			}
			System.out.printf("\n");
		}
	}
}


class Ship {

	byte N = SeaBattleGame.N;
	PlayingField field = SeaBattleGame.field;

	String name;
    byte[] coors;

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
			if ((cardinal_point == 0) && (y-2 >= 0) && (field.getBool(x, y) == field.getBool(x, (byte) (y-1)) == field.getBool(x, (byte) (y-2)) == false)){
				field.setBool(x, y, (byte) 1);
				field.setBool(x, (byte) (y-1) ,(byte) 1);
				field.setBool(x, (byte) (y-2) ,(byte) 1);
				byte[] coors_copy = {x, y, x, (byte) (y-1), x, (byte)(y-2)};
                coors = coors_copy;
				end = true;}
			else{if ((cardinal_point == 1) && (x+2 <= N) && (field.getBool(x, y) == field.getBool((byte) (x+1), y) == field.getBool((byte) (x+2), y) == false)){
				field.setBool(x, y, (byte) 1);
				field.setBool((byte) (x+1), y ,(byte) 1);
				field.setBool((byte) (x+2), y ,(byte) 1);
				byte[] coors_copy = {x, y, (byte) (x+1), y, (byte) (x+2), y};
                coors = coors_copy;
				end = true;}
			else{if ((cardinal_point == 2) && (y+2 <= N) && (field.getBool(x, y) == field.getBool(x, (byte) (y+1)) == field.getBool(x, (byte) (y+2)) == false)){
				field.setBool(x, y, (byte) 1);
				field.setBool(x, (byte) (y+1) ,(byte) 1);
				field.setBool(x, (byte) (y+2) ,(byte) 1);
				byte[] coors_copy = {x, y, x, (byte) (y+1), x, (byte) (y+2)};
                coors = coors_copy;
				end = true;}
			else{if ((cardinal_point == 3) && (x-2 >= 0) && (field.getBool(x, y) == field.getBool((byte) (x-1), y) == field.getBool((byte) (x-2), y) == false)){
				field.setBool(x, y, (byte) 1);
				field.setBool((byte) (x-1), y ,(byte) 1);
				field.setBool((byte) (x-2), y ,(byte) 1);
				byte[] coors_copy = {x, y, (byte) (x-1), y, (byte) (x-2), y};
                coors = coors_copy;
				end = true;}
			}}}
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

	boolean getBool(byte x, byte y) {
		return table[x][y];
	}
}
