/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan.lib;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author saulc
 */
public class FSM {
  LinkedList<Dstate> dStates;
  HashMap<Integer, HashMap> transitionTable; 
  LinkedList<Integer> validationStates;
  int state;

  public FSM(LinkedList<Dstate> dStates, HashMap<Integer, HashMap> table, LinkedList<Integer> validationStates) {
    this.dStates = dStates;
    this.transitionTable = table;
    this.validationStates = validationStates;
    this.state = 0;
  }
}
