package tp6;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class tp6 extends JFrame {
	// Rock n Roll
	/* Dice Roller Simulation */
	
	public tp6() {
		setTitle("Rock 'n roll");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void creerfen() throws IOException {
		 tp6 ex = new tp6();
	        
	     // PANNEAU PRINCIPAL 
	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        
	    // PANNEAU HEADER
	        JPanel header = new JPanel();
	        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
	        JLabel titreFen = new JLabel("Rock 'n Roll");
	        titreFen.setFont(new Font("Serif", Font.BOLD, 28));     
	       // titreFen.setHorizontalAlignment(SwingConstants.CENTER);
	        header.add(titreFen);
	       
	        
	        
	     // PANNEAU NUMERO 1. Contrôles 
	        JPanel control = new JPanel();
	        control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));
	        //control.setPreferredSize(new Dimension(200, 600));
	        
	        // On rajoute un titre à notre premier panneau
	        TitledBorder border = new TitledBorder("Options");
	        border.setTitleJustification(TitledBorder.CENTER);
	        border.setTitlePosition(TitledBorder.TOP);
	        control.setBorder(border);
	        
	        
	        // Checkbox pour le dé pipé
	        JCheckBox ch = new JCheckBox("Dé pipé");
	        control.add(ch);
	         
	        
	        // Radio button: Soit nb de lancers, soit x lancers jusqu'a une valeur
	        JPanel f=new JPanel();    
	        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
	        JRadioButton rb1=new JRadioButton("Nombre de lancers : ");    
	        JRadioButton rb2=new JRadioButton("Lancer jusqu'à la valeur : ");    
	        rb1.setBounds(75,50,100,30);    
	        rb1.setSelected(true);
	        rb2.setBounds(75,100,100,30);    
	        ButtonGroup bg=new ButtonGroup();    
	        bg.add(rb1);bg.add(rb2);    
	        f.add(rb1);f.add(rb2);      
	        	        
	        
	        // Spinner valeur numérique
	        JPanel boxb = new JPanel(new FlowLayout());
	        SpinnerModel model = new SpinnerNumberModel(10, 1, null, 1);   // Pas de max de lancers
	        JSpinner spinner = new JSpinner(model); 
	        
	        Dimension prefSize = spinner.getPreferredSize();
	        prefSize = new Dimension(100, prefSize.height);
	        spinner.setPreferredSize(prefSize); // On applique une nouvelle largeur au spinner
	        
	        boxb.add(f);
	        boxb.add(spinner);
	        control.add(boxb);
	              

	        // On met le combobox et son label dans un panneau distinct
	        JPanel box = new JPanel(new FlowLayout());
	        JLabel l = new JLabel("Nombre de faces : ");
	        Integer[] patternExamples = { 4, 6, 8, 12, 20 };
	        JComboBox<Integer> nbFaces = new JComboBox<Integer>(patternExamples);
	        nbFaces.setEditable(true);
	        box.add(l);
	        box.add(nbFaces);
	        control.add(box); 
	        // On doit vérifier que l'utilisateur rentre un entier, mais également qu'il soit inférieur à 50
	        
	   
	        // Bouton 'lancer le dé'
	        JButton btn = new JButton("Lancer le dé");
	        
	       
	        control.add(btn);
	        
	        
	        BufferedImage myPicture = ImageIO.read(new File("./dice.png"));
	        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	        //picLabel.setBounds(0, 0, 25, 25);
	        control.add(picLabel);
	        
	        
	        
	  // PANNEAU NUMERO 2. Résultats      
	        
	        JPanel res = new JPanel();
	        res.setLayout(new BoxLayout(res, BoxLayout.Y_AXIS));
	
	        // Somme des valeurs
	        JPanel sum = new JPanel();
	        JLabel l1 = new JLabel("Somme des valeurs : ");
	        JLabel r1 = new JLabel("");
	        sum.add(l1);
	        sum.add(r1);
	        res.add(sum);
	        
	        // Valeur max obtenue
	        JPanel mx = new JPanel();
	        JLabel l2 = new JLabel("Valeur max. obtenue : ");
	        JLabel r2 = new JLabel("");
	        mx.add(l2);
	        mx.add(r2);
	        res.add(mx);
	        
	        // Nb de lancers consécutifs
	        JPanel dic = new JPanel();
	        JLabel dxx = new JLabel("Plus grand nombre de lancers identiques consécutifs: ");
	        JLabel dxxx = new JLabel("");
	        dic.add(dxx);
	        dic.add(dxxx);
	        res.add(dic); 
	        
	        
	        // Plus grand nombre de lancers identiques
	        JPanel di = new JPanel();
	        JLabel d = new JLabel("Plus grand nombre de lancements identiques : ");
	        JLabel dx = new JLabel("");
	        di.add(d);
	        di.add(dx);
	        res.add(di); 
	        
	        // Nb de lancers
	        JPanel nL = new JPanel();
	        JLabel nLt = new JLabel("");
	        JLabel nLr = new JLabel("");
	        nL.add(nLt);
	        nL.add(nLr);
	        res.add(nL); 
	        
	        
	        btn.addActionListener(new ActionListener() { 
	        	  public void actionPerformed(ActionEvent e) {
	        		  // On récupère les valeurs de l'interface ici
	        		  // On envoie les valeurs de l'interface via lancers()
	        		  
	        		  // Valeur de la checkbox
	        		  boolean pipé = ch.isSelected();
	        		 
	        		  // Valeur du spinner nombre de lancers
	        		  Integer spi = (Integer) spinner.getValue();
	        		  
	        		  // Valeur du combo nb de faces
	        		  String value = nbFaces.getSelectedItem().toString();
	        		  String newString = value.replaceAll("[^0-9]","");
	        		  int helloNbFaces = Integer.parseInt(newString);
	        		  
	        		  
	        		  if (helloNbFaces > 50) {
	        			  // On vérifie que le nombre de faces soi inférieur à 50
	        		      JOptionPane.showMessageDialog(null, "Number of sides can't exceed 50.", "InfoBox: Dice Sides", JOptionPane.INFORMATION_MESSAGE);
	        		  }
	        		  else if ((rb2.isSelected())&& (spi > helloNbFaces)) {
	        		      JOptionPane.showMessageDialog(null, "Number seeked can't exceed number of sides.", "InfoBox: Dice Sides", JOptionPane.INFORMATION_MESSAGE);
	        		  }
	        		  else {
	        			  int rbx = 0;
	        			  if (rb1.isSelected() == true) { rbx = 1; }
	        			  int[] tab = lancers(pipé, helloNbFaces, spi, rbx);
	        			// RETOURNE: sum des lcers, val max obtenue, Nb max de val conséctives, + gd nb de lcrs idtiques
	        			  r1.setText(Integer.toString(tab[0]));
	        			  r2.setText(Integer.toString(tab[1]));
	        			  dxxx.setText(Integer.toString(tab[2]));
	        			  dx.setText(Integer.toString(tab[3]));
	        			  if (rbx == 0)  // Lancer jusqu'à la valeur x
	        			  {   nLt.setText("Nombre de lancers:");
	        				  nLr.setText(Integer.toString(tab[4])); }
	        			  else {
	        				  nLt.setText("");
	        				  nLr.setText("");
	        			  }
	        		  }
	        		  
	        	  } 
	        	} );
	        
	        
	        
	        
	        
	        
	  // On ajoute les panneaux au panneau principal
	        mainPanel.add(header, BorderLayout.NORTH);
	        mainPanel.add(control, BorderLayout.WEST);
	        mainPanel.add(res, BorderLayout.CENTER);
	        ex.getContentPane().add(mainPanel);
	        
	        ex.setVisible(true);
	}

	public static int[] lancers(boolean piped, int nbFace, int nbLanc, int rbX) {
		// RETOURNE: sum des lcers, val max obtenue, Nb max de val conséctives, + gd nb de lcrs idtiques
	       // On crée et affiche un dé
	       dice d1 = new dice(piped, nbFace);
	       System.out.println(d1.diceString());
	       
	       // On déclare les données qu'on veut enregistrer:
	       int sumLanc = 0; // Somme des valeurs des lancers
	       int valMx = 0; // Valeur maximale obtenue
	       
	       int nbLancConseq = 0, tmpNbLancConseq = 0; int tmpValDice = 1;
	       // +gd nb lanc consq, nb lanc conseq actuel, val dé actuelle, val dé avec + gd nb lanc conséq conséq.
	       
	       ArrayList<Integer> NbWValue = new ArrayList<Integer> ();
	       for (int t = 0; t < nbFace; t++) {
	    	   NbWValue.add(0);
	    	 }

	       int tmpDice; // Valeur du lancer actuel
	       		
	       int nblancers = 0;
	       
	       if (rbX == 0) { // Si rbx = 0, cad Lancer jusqu'à la valeur x
	    	  int d1tmp = 0;
	    	   do {
	    		   nblancers++;
		       		 tmpDice = d1.lancerDice();
		 	    	 d1tmp = tmpDice;
			 	    	//  System.out.println(tmpDice);
			 	    	  sumLanc += tmpDice; // On ajoute à sumLanc la valeur que l'on vient d'obtenir
			 	    	  
			 	    	  // Gestion de la valeur maximale
			 	    	  if(tmpDice > valMx) { valMx = tmpDice; } // Si la val actuelle est sup à la val max : val mx = val actuelle.
			 	    	  
			 	    	  // Gestion du + gd nombre de lancements consécutifs
			 	    	  if (tmpDice == tmpValDice) {  tmpNbLancConseq++;  } // Si val actuelle = val précédente: on incrémente le tmp
			 	    	  else if (tmpNbLancConseq > nbLancConseq) {nbLancConseq = tmpNbLancConseq ; tmpNbLancConseq = 1;}
			 	    	  else { tmpNbLancConseq = 1; }// Sinon
			 	    	  tmpValDice = tmpDice;
			 	    	  
			 	    	  // On incrémente l'élément à l'indice correspondant à la valeur du dé
			 	    	  NbWValue.set(tmpDice-1, NbWValue.get(tmpDice-1)+1);
	    	   }
	    	   while (d1tmp < nbLanc);
	       } else { // Si rbx = 1, cad lancer x fois
	    	   // On lance le dé et on affiche le résultat + on renseigne les données supplémentaires.
	 	      // System.out.println("Les lancers: ");
	 	       for(int i=0; i<nbLanc; i++) {
	 	    	  tmpDice = d1.lancerDice();
	 	    	  
	 	    	//  System.out.println(tmpDice);
	 	    	  sumLanc += tmpDice; // On ajoute à sumLanc la valeur que l'on vient d'obtenir
	 	    	  
	 	    	  // Gestion de la valeur maximale
	 	    	  if(tmpDice > valMx) { valMx = tmpDice; } // Si la val actuelle est sup à la val max : val mx = val actuelle.
	 	       
	 	    	  // Gestion du + gd nombre de lancements consécutifs
	 	    	  if (tmpDice == tmpValDice) {  tmpNbLancConseq++;  } // Si val actuelle = val précédente: on incrémente le tmp
	 	    	  else if (tmpNbLancConseq > nbLancConseq) {nbLancConseq = tmpNbLancConseq ; tmpNbLancConseq = 1;}
	 	    	  else { tmpNbLancConseq = 1; }// Sinon
	 	    	  tmpValDice = tmpDice;
	 	    	  
	 	    	  // On incrémente l'élément à l'indice correspondant à la valeur du dé
	 	    	  NbWValue.set(tmpDice-1, NbWValue.get(tmpDice-1)+1);
	 	    	  
	 	       }
	 	       
	       }
	       
	     
	       
	      // On recherche l'élément le plus grand de l'arrayList et son indice
	       int big = Collections.max(NbWValue);
	       
	       int[] tab = {sumLanc, valMx, nbLancConseq, big, nblancers};
	       
	       return tab;
		
	}
	
	
    public static void main(String[] args) throws IOException {
       creerfen();
       

       
       
    }
}
