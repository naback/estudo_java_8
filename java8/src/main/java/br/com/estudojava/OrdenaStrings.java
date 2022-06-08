package br.com.estudojava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

  public static void main(String[] args) {
    List<String> palavras = new ArrayList<>();

    palavras.add("alura online");
    palavras.add("caelum");
    palavras.add("editora casa do codigo");

//    palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
//    palavras.sort(Comparator.comparing(s -> s.length()));
//    palavras.sort(Comparator.comparing(String::length));

//    como recebe somente um parametro, podemos simplificar a lambda assim
      palavras.forEach(s -> System.out.println(s));
      palavras.forEach(System.out::println);
  }
}