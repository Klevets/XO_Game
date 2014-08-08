import java.util.Scanner;

public class Field {
	
	public static int FIELD_SIZE = 3;
	
	private static final char DEFAULT_CELL_VALUE = ' ';
	
	private static final int DEFAULT_FIELD_SIZE = 3;

	private char[][] field;
	
	public  String[][] EXAMPLE_FIELD;
	
	public static int [][] HYSTORY_ARRAY;
	
	
	public char typeX = 'x';
	public char typeO = 'o';
	
	public Field(){
		this(DEFAULT_FIELD_SIZE);
	}
	
    public Field(int size){
		FIELD_SIZE = size;
		field = new char[FIELD_SIZE][FIELD_SIZE];	
    }
		
	public int getFieldSize(){
		return FIELD_SIZE;
	}
	
	public void eraseField(){
		for (int i = 0; i < FIELD_SIZE; i++){
			for (int j = 0; j < FIELD_SIZE; j++){
			field[i][j] = DEFAULT_CELL_VALUE;
			}
		}
	}
	
	public void showField(){
		System.out.println();
		for ( int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++){
			showCell(i,j);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void showRule(){
	EXAMPLE_FIELD = new String[3][3];
	EXAMPLE_FIELD[0][0] ="00" ;
	EXAMPLE_FIELD[0][1] ="01" ;
	EXAMPLE_FIELD[0][2] ="02" ;
	EXAMPLE_FIELD[1][0] ="10" ;
	EXAMPLE_FIELD[1][1] ="11" ;
	EXAMPLE_FIELD[1][2] ="12" ;
	EXAMPLE_FIELD[2][0] ="20" ;
	EXAMPLE_FIELD[2][1] ="21" ;
	EXAMPLE_FIELD[2][2] ="22" ;
	
	for (int i = 0; i < FIELD_SIZE; i++){
		for(int j = 0; j < FIELD_SIZE; j++){
			System.out.print("[" + EXAMPLE_FIELD[i][j] + "]");
		}
		System.out.println();
	}
	
	}
	
	private void showCell (int i, int j){
		System.out.print ("[" + field[i][j] + "]");
	}
	
	private void checkPlayer(int playerIndex){
		if ((playerIndex % 2) != 0){
    		System.out.println("The 'O' player is running...");
    		}
        else{
			 System.out.println("The 'X' player is running...");
        }
	}
	
	private int checkCorrectChoice(int coordinateX, int coordinateY){
		if(coordinateX >= 0 && coordinateX <=2 && coordinateY >= 0 && coordinateY <=2){
			return 1;
		}
		return 0;
	}
	
	private void setDefaultHistory (){
		HYSTORY_ARRAY = new int[FIELD_SIZE][FIELD_SIZE];
		for (int i = 0; i < FIELD_SIZE; i++){
			for(int j = 0; j < FIELD_SIZE; j++){
				HYSTORY_ARRAY[i][j] = 1;
			}
			
		}
	}
	
	public void setResult () {
		setDefaultHistory ();
		Scanner sc = new Scanner(System.in);
        int valueX = 0;
        int valueY = 0;
        for (int i = 0; i < 9; i++){
        	
        	if (i > 4){
        		FieldCheck.checkForWinner(valueX, valueY, field); // Catch the Winner!!!        		
        	}
        	
        showRule();
        checkPlayer(i);
        System.out.print("Your turn: ");
       
        	if(sc.hasNextInt()) {
        		valueX = sc.nextInt();
        		valueY = sc.nextInt();
        		
        		
    			HYSTORY_ARRAY[valueX][valueY] = i;
        		
        		if (checkCorrectChoice(valueX, valueY) == 1){
        			
        		 if ((i % 2) != 0){        	
        		field[valueX][valueY] = typeO;  
				}
        		 else{
        	        	field[valueX][valueY] = typeX;
        	        	}
        		 showField();
        		
        	}
        		else {
            		System.out.println("Incorrect choice!!!");
            		i--;
            	}
        	}
        	
        }
    
        sc.close();
	}
	
	public void showHistory (){
		for (int i = 0; i < FIELD_SIZE; i++){
			for(int j = 0; j < FIELD_SIZE; j++){
				System.out.print("[" + HYSTORY_ARRAY[i][j] + "]");
			}
			System.out.println();
		}
		
	}
	
}
