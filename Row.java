import java.util.ArrayList;

public class Row {//Main Row Object
	//Class Variables
	String Name;
	int reservations = 0;
	ArrayList<Integer> row = new ArrayList<Integer>();
	
	//Constructor
	public Row(String Name) {
		this.Name = Name;
		for(int i = 0; i < 20; i++) {
			row.add(0);
		}
	}
	
	//Methods
	ArrayList<Integer> getRow(){
		return row;
	}
	
	String getName(){
		return Name;
	}
	
	ArrayList<String> printFullSeats() {//returns the full seats with the format of A1,A2,A3
		ArrayList<String> seats = new ArrayList<String>();
	for(int i = 0, j = 0; i < 20; i++) {
		if(i == 0) {
			
			seats.add(Name+(i+1));
			j++;
		}
		else if(row.get(i-1).equals(1)&&row.get(i).equals(1)) {
			seats.set(j-1, seats.get(j-1)+","+Name+(i+1));
			
		}	
		else if(row.get(i).equals(1)) {
			seats.add(Name+(i+1));
			j++;
		}
		else {
			seats.add(Name+(i+1));
			j++;
		}	
	}
		return seats;
	}
		
	void claimSeats(int people) {//Claims the seat for the respective reservation
		int rs = remainingSeats();
		for(int i = 20-rs; people > 0 ;people--, i++) {
			row.set(i, 1);
		}
		reservations++;
	}
	
	int remainingSeats() {//determines the remaining seats in the row
		for(int i = 19; i >= 0 ; i--) {
			if(row.get(i).equals(1) == true){
				return((16-i) <= 0 ? 0  : (16-i)); 
			}
		}	
		return 20;
	}
	
	void displayRow(){ // Non-necessary method to produce the row for visual aid
		System.out.println("#--------------------------------------------------#");
		System.out.print("|     ");
		for(int i = 0; i < 20; i++) {
			System.out.print(row.get(i)+" ");
		}
		System.out.println("     |");
		System.out.println("#--------------------------------------------------#");
	}
}