/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan;
import parser.Parser;
import parser.Lexer;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author saulc
 */
public class Main {
  public static void main(String args[]){
    String file = "test_files/dificil.olc";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      Lexer s = new Lexer(br);
      Parser p = new Parser(s);
      p.parse();
      System.out.println("Parsing de archivo terminado");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
