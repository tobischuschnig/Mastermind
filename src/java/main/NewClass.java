/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.MastermindModel;

/**
 *
 * @author tobi
 */
public class NewClass {
    public static void main(String[] args) {
        MastermindModel wert = new MastermindModel();
        System.out.print("Succed"+"\n");
        int[] vers = {1,2,3,4};
        wert.check(vers);
        wert.check(vers);
        wert.check(vers);
        String wertt = wert.stringHTML();
        System.out.println(wertt+"123");
    }
}
