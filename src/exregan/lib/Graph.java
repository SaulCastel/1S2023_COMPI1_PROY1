/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan.lib;
import java.io.FileWriter;
import java.util.Stack;

/**
 *
 * @author saulc
 */
public class Graph {
  public void graphTree(RegexNode root, String fileName){
    String str = "";
    Stack<RegexNode> s = new Stack<>();
    RegexNode node = root;
    try {
      FileWriter fw = 
        new FileWriter(String.format("ARBOLES_201801178/%s.dot",fileName));
      fw.write("digraph G {\n");
      while (node != null || !s.isEmpty()) {
        while (node != null) {
          s.push(node);
          node = node.left;
        }
        node = s.pop();
        //Escribir al archivo de texto
        str += String.format("n%s[label=\"",Integer.toString(node.ID));
        str += ((node.isNull)? "A":"N" ) + "\\n";
        str += String.format("<%s>\\n", node.symbol);
        str += String.format("[%s] - ", node.first.toArray());
        str += String.format("[%s]\\n", node.last.toArray());
        str += (node.position == 0)? "":Integer.toString(node.position);
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
      execGraphviz("ARBOLES_201801178/", fileName);
    } catch (Exception e) {
    }
  }

  private void execGraphviz(String ruta, String fileName) {
    Runtime rt = Runtime.getRuntime();
    try {
      String[] cmd = {
        "dot",
        ruta+fileName+".dot",
        "-Tjpg",
        "-o",
        ruta+fileName+".jpg",
      };
      rt.exec(cmd);
    }catch(Exception e) {}    
  }
}
