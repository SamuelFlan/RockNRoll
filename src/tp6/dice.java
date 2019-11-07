package tp6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class dice {
	private boolean pipé;
	private int nbFaces;
	private ArrayList<Integer> listeFaces;
    private Random randomGenerator;


	public dice(boolean piped, int nbf) {
		nbFaces = nbf;
		pipé = piped;
		randomGenerator = new Random();
		
		listeFaces = new ArrayList<Integer> ();
		
		for(int i = 1 ; i <= nbFaces; i++ ) {
			listeFaces.add(i);
			if ((i == nbFaces) && (pipé == true)) {
				listeFaces.add(i);
			}
		}
	}
	
	public String diceString() {	
		return Arrays.toString(listeFaces.toArray());

	}
	
	
	public int lancerDice() {
		int index = randomGenerator.nextInt(listeFaces.size());
        int item = listeFaces.get(index);
        return item;
		
      //  return listeFaces.get(new Random().nextInt(listeFaces.size()));
	}
}