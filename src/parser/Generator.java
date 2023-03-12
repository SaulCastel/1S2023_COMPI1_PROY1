package parser;

public class Generator {

  public static void main(String[] args) {
    try {
      String path = "src/parser/";
      //ruta donde tenemos los archivos con extension .jflex y .cup
      String optJflex[] = {path + "scanner.jflex", "-d", path};
      jflex.Main.generate(optJflex);
      String optCUP[] = {"-destdir", path, "-parser", "Parser", path + "parser.cup"};
      java_cup.Main.main(optCUP);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
