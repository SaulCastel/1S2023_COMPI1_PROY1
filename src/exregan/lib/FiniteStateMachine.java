/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan.lib;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;

/**
 *
 * @author saulc
 */
public class FiniteStateMachine {
  public FSM getFSM(
      HashMap<Integer, String> symbols,
      HashMap<Integer, LinkedList> nextTable,
      LinkedList<Integer> firstState,
      int finalIndex
    ){
    int originState = 0;
    int destinationState;
    LinkedList<Integer> validationStates = new LinkedList<>();
    LinkedList<Dstate> dStates = new LinkedList<>();
    HashMap<Integer, HashMap> transitionTable = new HashMap<>();

    dStates.add(new Dstate(firstState));
    Dstate current = dStates.getFirst();
    while(dStates.getLast().isNew){
      current.isNew = false;
      for (String symbol : symbols.values()){
        Dstate newState = 
          this.getPossibleNewState(symbol, symbols, current.list, nextTable, finalIndex);
        destinationState = this.searchStateInTable(newState, dStates);
        if (destinationState == -1){
          dStates.add(newState);
          destinationState = nextTable.size() - 1;
          if (newState.list.contains(finalIndex)){
            validationStates.add(destinationState);
          }
        }
        this.dTran(transitionTable, originState, symbol, destinationState);
      }
      originState++;
      if (originState != dStates.size()){
        current = dStates.get(originState);
      }
    }
    return new FSM(transitionTable,validationStates);
  }

  private Dstate getPossibleNewState(
      String symbol,
      HashMap<Integer, String> symbols,
      LinkedList<Integer> positions,
      HashMap<Integer, LinkedList> nextTable,
      int finalIndex
    ){
    Dstate union = new Dstate();
    for (int p : positions){
      if (p != finalIndex && symbols.get(p).equals(symbol)){
        union.list.addAll(nextTable.get(p));
      }
    }
    return union;
  }

  public int searchStateInTable (Dstate state, LinkedList<Dstate> dStates){
    int index = 0;
    Object[] newState = state.list.toArray();
    for (Dstate currState : dStates){
      if (Arrays.equals(newState, currState.list.toArray())){
        return index;
      }
      index++;
    }
    return -1;
  }

  private void dTran (
      HashMap<Integer, HashMap> transitionTable,
      int origin,
      String symbol,
      int destination
    ){
    HashMap<String, Integer> transition = transitionTable.get(origin);
    if (transition == null){
      transition = new HashMap<>();
    }
    transition.put(symbol, destination);
    transitionTable.put(origin, transition); 
  }
}
