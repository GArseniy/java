public class SeaBattle {
	static byte N = 7;
	static Game newGame = new Game();
	public static void main(String[] args) {
		newGame.initGame();
		byte num_ships = 3;
		Ship[] ships = new Ship[num_ships];
		for (byte i = 0; i < num_ships; i++) 
		{
			ships[i] = new Ship();
			ships[i].initShip();
		}
		for (byte i = 0; i < N; i++) {
			for (byte j = 0; j < N; j++)	
			{	
				System.out.print(newGame.table[i][j]);
				System.out.print(" ");
			}
			System.out.printf("\n");
		}
	}
}

class Ship {
	
	Game newGame = SeaBattle.newGame;
	byte N = SeaBattle.N;
	String name;
	byte x;
	byte y;
	// newGame.table[x][y] : zero cell coordinates
	byte cardinal_point;
	// 0 : N
	// 1 : E
	// 2 : S
	// 3 : W
	
	void initShip() {
	boolean end = false;
	while(!end) {
		x = (byte) (Math.random() * N);
		y = (byte) (Math.random() * N);
		// table[x][y] : zero cell coordinates
		cardinal_point = (byte) (Math.random() * 4);
		// 0 : N
		// 1 : E
		// 2 : S
		// 3 : W

		if ((cardinal_point == 0) && ((y - 2) >= 0) && (newGame.table[x][y] == newGame.table[x][y-1] == newGame.table[x][y-2] == false)){
			newGame.table[x][y] = true;
			newGame.table[x][y-1] = true;
			newGame.table[x][y-2] = true;
			end = true;}
		else{if ((cardinal_point == 1) && ((x + 2) <= (N-1)) && (newGame.table[x][y] == newGame.table[x+1][y] == newGame.table[x+2][y] == false)){
			newGame.table[x][y] = true;
			newGame.table[x+1][y] = true;
			newGame.table[x+2][y] = true;
			end = true;}
		else{if ((cardinal_point == 2) && ((y + 2) <= (N-1)) && (newGame.table[x][y] == newGame.table[x][y+1] == newGame.table[x][y+2] == false)){
			newGame.table[x][y] = true;
			newGame.table[x][y+1] = true;
			newGame.table[x][y+2] = true;
			end = true;}
		else{if ((cardinal_point == 3) && ((x - 2) >= 0) && (newGame.table[x][y] == newGame.table[x-1][y] == newGame.table[x-2][y] == false)){
			newGame.table[x][y] = true;
			newGame.table[x-1][y] = true;
			newGame.table[x-2][y] = true;
			end = true;}
		}}}
		}
	}	
}
class Game {
	
	//    <table[x][y]>
	// __|_0_1_2_3_4_5_6 ... x
	// 0 | f f f f f f f
	// 1 | f f f f f f f
	// 2 | f f f f f f f
	// 3 | f f f f f f f
	// 4 | f f f f f f f
	// 5 | f f f f f f f
	// 6 | f f f f f f f
	//... 
	// y

	byte N = SeaBattle.N; // size: N x N
	boolean[][] table = new boolean[N][N];
	void initGame() {
	for (byte x = 0; x < N; x++) 
	{
		table[x] = new boolean[N];
		for (byte y = 0; y < N; y++)
		{
			table[x][y] = false;
		}
	}
	}
}
