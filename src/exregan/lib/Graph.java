/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan.lib;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author saulc
 */
public class Graph {

  public void graphTree(RegexNode root, String fileName) throws IOException {
    String route = "ARBOLES_201801178/";
    String str = "";
    Stack<RegexNode> s = new Stack<>();
    RegexNode node = root;
    FileWriter fw
      = new FileWriter(String.format(route + "%s.dot", fileName));
    fw.write("digraph G {\n");
    fw.write("node[shape=\"circle\"];\n");
    while (node != null || !s.isEmpty()) {
      while (node != null) {
        s.push(node);
        node = node.left;
      }
      node = s.pop();
      //Escribir al archivo de texto
      str += String.format("n%s[label=\"", Integer.toString(node.ID));
      str += ((node.isNull) ? "A" : "N") + "\\n";
      str += String.format("<%s>\\n", node.symbol);
      str += String.format("[%s] - ", node.first.toArray());
      str += String.format("[%s]\\n", node.last.toArray());
      str += (node.position == 0) ? "" : Integer.toString(node.position);
      str += "\"];\n";
      if (node.left != null) {
        str += String.format(
          "n%s->n%s;\n",
          Integer.toString(node.ID),
          Integer.toString(node.left.ID)
        );
      }
      if (node.right != null) {
        str += String.format(
          "n%s->n%s;\n",
          Integer.toString(node.ID),
          Integer.toString(node.right.ID)
        );
      }
      fw.write(str);
      str = "";
      node = node.right;
    }
    fw.write("}");
    fw.close();
    //llamar graphviz para graficar
    //Guardar archivo en carpeta especial
    execGraphviz(route, fileName);
  }

  public void graphAFD(FSM automaton, String fileName) throws IOException {
    String route = "AFD_201801178/";
    String str = "";
    FileWriter fw
      = new FileWriter(String.format(route + "%s.dot", fileName));
    HashMap<String, Integer> transition;
    int destination;
    fw.write("digraph G {\n");
    fw.write("rankdir=\"LR\";\n");
    fw.write("node[shape=\"circle\"];\n");
    for (int origin : automaton.transitionTable.keySet()) {
      transition = automaton.transitionTable.get(origin);
      for (String symbol : transition.keySet()) {
        destination = transition.get(symbol);
        str += String.format(
          "%d -> %d[label=\"%s\"];\n",
          origin,
          destination,
          symbol
        );
        if (automaton.validationStates.contains(destination)) {
          str += String.format("%d[shape=\"doublecircle\"];\n", destination); 
        }
      }
      fw.write(str);
      str = "";
    }
    fw.write("}");
    fw.close();
    execGraphviz(route, fileName);
  }

  private void execGraphviz(String route, String fileName) throws IOException {
    Runtime rt = Runtime.getRuntime();
    String[] cmd = {
      "dot",
      route + fileName + ".dot",
      "-Tjpg",
      "-o",
      route + fileName + ".jpg",};
    rt.exec(cmd);
  }
}
