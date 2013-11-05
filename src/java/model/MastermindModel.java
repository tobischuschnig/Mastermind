package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tobi
 */
public class MastermindModel {
    private ArrayList<int[]> versuche;
    private ArrayList<int[]> check;
    private int[] zahlen;
    private boolean gewonnen;
    private boolean verloren;
    private String aus;
    
    public MastermindModel() {
        gewonnen = false;
        verloren = false;
        aus = "";
        zahlen = new int[4];
        for (int i = 0 ; i < 4; i++) {
            zahlen[i] = ((int) (Math.random()*8+1));
            for(int ii = 0; ii< i; ii++) {
                if(zahlen[i] == zahlen[ii]) {
                    zahlen[i] = ((int) (Math.random()*8+1));
                    ii--;
                }
            }
        }
        //zahlen = new int[4];
        //zahlen[0] = 2;
        //zahlen[1] = 3;
        //zahlen[2] = 4;
        //zahlen[3] = 5;
        versuche = new ArrayList();
        check = new ArrayList();
    }
    
    public MastermindModel(int[] zahle) {
        gewonnen = false;
        verloren = false;
        aus = "";
        if(zahle.length < 5) {
            zahlen = zahle;
        }
        else {
        	zahlen = new int[4];
            for (int i = 0 ; i < 4; i++) {
                zahlen[i] = ((int) (Math.random()*8+1));
                for(int ii = 0; ii< i; ii++) {
                    if(zahlen[i] == zahlen[ii]) {
                        zahlen[i] = ((int) (Math.random()*8+1));
                        ii--;
                    }
                }
            }
        }
        //zahlen = new int[4];
        //zahlen[0] = 2;
        //zahlen[1] = 3;
        //zahlen[2] = 4;
        //zahlen[3] = 5;
        versuche = new ArrayList();
        check = new ArrayList();
    }
    
    public ArrayList<int[]> check(int[] vers) {
        int[] checkvers = new int[2];
        if(!verloren && !gewonnen) {
            checkvers[0] = checkFarbe(vers);
            checkvers[1] = checkStelle(vers);
            if(check.size()==9)verloren = true;
            if(checkvers[1]==4)gewonnen = true;
            check.add(checkvers);
            versuche.add(vers);
        }
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
    
    public boolean sieg() {
       return gewonnen; 
    }
    
    public boolean niederlage() {
        return verloren;
    }
    
    public String stringHTML() {
        aus = "";
        Iterator iv = versuche.iterator();
        Iterator ic = check.iterator();
        while(iv.hasNext() && ic.hasNext()) {
            int[] iva = (int[]) iv.next();
            int[] ica = (int[]) ic.next();
            aus+="<br>"+iva[0]+"&nbsp;"+iva[1]+"&nbsp;"+iva[2]+"&nbsp;"+iva[3]+"&nbsp;";
            aus+="&nbsp;&nbsp;&nbsp;<span style='color:red'>"+"Richtige Zahl:&nbsp;"+ica[0]+"</span>&nbsp;&nbsp;<span style='color:white'>"+"Richtige Stelle:&nbsp;" + ica[1] + "</span>";
        }
        if(verloren == true || gewonnen == true) {
            aus+= "<br> <br> <br>Richtige Zahlen:&nbsp";
            for(int i= 0; i < 4;i++) {
                aus+= zahlen[i];
            }
        }
        return aus;
    }

    public void setZahlen(int[] zahlen) {
        this.zahlen = zahlen;
    }
    
    public void restart() {
        gewonnen = false;
        verloren = false;
        aus = "";
        zahlen = new int[4];
        for (int i = 0 ; i < 4; i++) {
            zahlen[i] = ((int) (Math.random()*8+1));
            for(int ii = 0; ii< i; ii++) {
                if(zahlen[i] == zahlen[ii]) {
                    zahlen[i] = ((int) (Math.random()*8+1));
                    ii--;
                }
            }
	}
        //zahlen = new int[4];
        //zahlen[0] = 2;
        //zahlen[1] = 3;
        //zahlen[2] = 4;
        //zahlen[3] = 5;
        versuche = new ArrayList();
        check = new ArrayList();
    }
}
