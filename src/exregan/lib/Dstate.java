/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan.lib;
import java.util.LinkedList;

/**
 *
 * @author saulc
 */
public class Dstate {
  public boolean isNew;
  public LinkedList<Integer> list;

  public Dstate(){
    this.isNew = true;
    this.list = new LinkedList<>();
  }

  public Dstate(LinkedList list){
    this.isNew = true;
    this.list = list;
  }
}
