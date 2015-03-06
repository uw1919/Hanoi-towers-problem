/*
 * Hanoi.java
 * 
 * @version 
 * $Id: Hanoi.java , Version 1.0 09/18/2014 $ 
 * 
 * @revision 
 * $Log Initial Version $  
 * 
 */

/**
 * This class solves the tower of hanoi problem while printing each state
 * 
 * @author Uday Wadhone
 * 
 * 
 */
public class Hanoi {
	static int disc=4;// number of discs
	
	// initialize the tower array
	static int[] tower0= new int[disc], tower1= new int[disc],
			tower2= new int[disc];

	/**
	 * The main program
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Initial tower positions");
		System.out.println();
																																							
		// store the initial number of discs on tower 0
	    for(int pos=disc-1;pos>=0;pos--){
	    	tower0[pos]=disc-pos;
	    	}
	    
		// Print the initial tower positions
	    for(int pos=disc-1;pos>=0;pos--){
	    	System.out.println("" + tower0[pos]+" " + tower1[pos]+" " 
	    + tower2[pos]);
	    	}
	    System.out.println("-----");
	    System.out.println("0 1 2");
	    System.out.println();
	    
	    // move n discs from tower 0 to 2 using tower1
	    move(disc, "0", "1", "2");
	    }
	
	/**
	 * Description
	 * 
	 * @param	n			disc number	
	 * @param	poleStart	from disc
	 * @param	poleOver	using disc
	 * @param	poleEnd		to disc
	 */
	public static void move(int  n, String poleStart, String poleOver,
			String poleEnd){
		if (n==1)
			// print the disc movement from the start pole to the end pole
			printTower(1, poleStart, poleEnd);
		else{
			// move n-1 discs recursively from the start to the pole over
			move(n - 1, poleStart, poleEnd, poleOver);
			
			// print the disc movement from the start pole to the end pole
			printTower(n, poleStart, poleEnd);
			
			// move the discs recursively from the pole over to the end pole 
			// solving the problem 
	        move(n - 1, poleOver, poleStart, poleEnd);	
	        }
		}

	/**
	 * Move the disc in array for every move made.
	 * 
	 * @param	n			disc number	
	 * @param	poleStart	from disc
	 * @param	poleOver	using disc
	 * @param	poleEnd		to disc
	 */
	 static void printTower(int currentDisc,String poleStart, String poleEnd) {
		int lastPos;
		
		// for tower0 to 1 or 2
		if(poleStart=="0"){
			System.out.println("Move disk "+currentDisc+" from pole "+ poleStart 
					+ " to pole " + poleEnd);
			System.out.println();
			
			// check for the top most disc on the tower
			lastPos=getLastPosFromTower(tower0);
			tower0[lastPos]=0;// remove the top most disc 
			
			if(poleEnd=="1"){
				lastPos=getLastPosToTower(tower1);
				tower1[lastPos]=currentDisc;//move the currentDisc on the tower
				printOnScreen();
				}
			else if(poleEnd=="2"){
				lastPos=getLastPosToTower(tower2);
				tower2[lastPos]=currentDisc;//move the currentDisc on the tower
				printOnScreen();
				}
			}	
		// for tower1 to 0 or 2
		else if(poleStart=="1"){
			System.out.println("Move disk "+currentDisc+" from pole "+ poleStart 
					+ " to pole " + poleEnd);
			System.out.println();
			lastPos=getLastPosFromTower(tower1);
			tower1[lastPos]=0;// remove the top most disc 
			
			if(poleEnd=="0"){
				lastPos=getLastPosToTower(tower0);
				tower0[lastPos]=currentDisc;//move the currentDisc on the tower
				printOnScreen();
				}
			else if(poleEnd=="2"){
				lastPos=getLastPosToTower(tower2);
				tower2[lastPos]=currentDisc;//move the currentDisc on the tower
				printOnScreen();
				}
			}
		
		// for tower2 to 0 or 1
		else if(poleStart=="2"){
			System.out.println("Move disk "+currentDisc+" from pole "+ poleStart 
					+ " to pole " + poleEnd);
			System.out.println();
			lastPos=getLastPosFromTower(tower2);
			tower2[lastPos]=0;// remove the top most disc 
			if(poleEnd=="0"){
				lastPos=getLastPosToTower(tower0);
				tower0[lastPos]=currentDisc;//move the currentDisc on the tower
				printOnScreen();
				}
			else if(poleEnd=="1"){
				lastPos=getLastPosToTower(tower1);
				tower1[lastPos]=currentDisc;//move the currentDisc on the tower
				printOnScreen();
				}
			}
		}
	
	 /**
	   * Print the towers for every move made.
	   *
	   */
	 static void printOnScreen(){
		 for(int currentDisc=disc-1;currentDisc>=0;currentDisc--){
			 System.out.println("" + tower0[currentDisc]+" " 
		 + tower1[currentDisc]+" "		 + tower2[currentDisc]);
			 }
		 System.out.println("-----");
		 System.out.println("0 1 2");
		 System.out.println();
		 }
	 
	 /**
	  * Get the top most disc on the tower 
	  *
	  *@param	tower[]					the tower number 
	  *@return	tower.length-counter	position of top disc
	  */
	 static int getLastPosFromTower(int[] tower) {
		 int counter = 1;
		 
		 // iterate from top to bottom of the tower looking for the top disc
		 for(int position=tower.length-1; position >= 0 ; position--){
			 // iterate till a disc is found on the tower
			 if(tower[position]==0){
				 counter++;
				 }
			 else
				 return tower.length-counter;
			 }
		 return 0;
		 }
	 
	 /**
	  * Get the top most available empty place on the tower 
	  *
	  *@param	tower[]						the tower number 
	  *@return	(tower.length-counter)+1	empty position on the tower
	  */
	 static int getLastPosToTower(int[] tower) {
		 int counter = 1;
		 
		 // iterate from top to bottom of the tower looking for the available 
		 // space
		 for(int position=tower.length-1; position >= 0 ; position--){
			// iterate till a disc is found on the tower
			 if(tower[position]==0){
				 counter++;
				 }
			// return the position above the disc
			 }	return (tower.length-counter)+1;
			 }
	 }
	 


