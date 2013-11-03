/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author tobi
 */
public class MastermindModel {
    private ArrayList<int[]> versuche;
    private ArrayList<int[]> check;
    private int[] zahlen;
    boolean gewonnen = false;
    boolean verloren = false;
    
    public MastermindModel() {
        zahlen = new int[4];
        for (int i = 0 ; i < 4; i++) {
            zahlen[1] = ((int) (Math.random()*8+1));
	}
    }
    
    public ArrayList<int[]> check(int[] vers) {
        int[] checkvers = new int[2];
        checkvers[1] = checkFarbe(vers);
        checkvers[2] = checkStelle(vers);
        if(check.size()==10)verloren = true;
        if(checkvers[2]==4)gewonnen = true;
        check.add(checkvers);
        versuche.add(vers);
        return check;
    }
    
    public int checkFarbe(int[] vers) {
        int farbe = 0;
        for(int i = 0; i<4;i++) {
            for(int ii = 0; ii<4;ii++) {
                if(zahlen[i]==vers[ii])farbe++;
            }
        }
        farbe-= checkStelle(vers);
        return farbe;
    }

    private int checkStelle(int[] vers) {
        int stelle = 0;
        for(int i = 0;i<4;i++) {
            if(vers[i]==zahlen[i])stelle++;
        }
        return stelle;
    }
    
    private boolean sieg() {
       return gewonnen; 
    }
    
    private boolean niederlage() {
        return verloren;
    }
    
    private String ausString() {
        return "";
    }
}
