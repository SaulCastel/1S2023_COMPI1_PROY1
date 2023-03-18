/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exregan;
import parser.Parser;
import parser.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author saulc
 */
public class Main {
  public static void main(String args[]){
    String file = "test_files/media.olc";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      Scanner s = new Scanner(br);
      Parser p = new Parser(s);
      p.parse();
      System.out.println("Parsing de archivo terminado");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
