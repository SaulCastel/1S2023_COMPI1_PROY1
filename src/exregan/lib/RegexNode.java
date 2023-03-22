/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan.lib;
import java.util.LinkedList;

public class RegexNode {
  public String symbol;
  public int ID;
  public int position;
  public boolean isNull;
  public LinkedList<Integer> first;
  public LinkedList<Integer> last;
  public RegexNode left;
  public RegexNode right;

  public RegexNode(String symbol, int position, int ID, RegexNode left, RegexNode right){
    this.symbol = symbol;
    this.ID = ID;
    this.position = position;
    this.left = left;
    this.right = right;
    this.first = new LinkedList<>();
    this.last = new LinkedList<>();
  }
}
