package br.com.estudojava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ExemploCursos {
  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();
    cursos.add(new Curso("Python", 45));
    cursos.add(new Curso("JavaScript", 150));
    cursos.add(new Curso("Java 8", 113));
    cursos.add(new Curso("C", 55));

    cursos.sort(Comparator.comparing(Curso::getAlunos));
    cursos.forEach(c -> System.out.println(c.getNome()));

    System.out.println("--------------------------------------------------------------");

  var stream   = cursos.stream().filter(c -> c.getAlunos() >= 100);
    cursos.forEach(curso -> System.out.println(curso.getNome()));
    // aqui imprime a lista e você vê que o filtro de cima não funcionou porquê tudo que é feito no Stream não altera a coleção original, só o stream

    System.out.println("--------------------------------------------------------------");

    stream.forEach(curso -> System.out.println(curso.getNome()));

    System.out.println("--------------------------------------------------------------");

    // OBS: NÃO É BOM JOGAR STREAM DENTRO DE VARIAVEL PQ O JAVA LIMPA AS STREAMS DA MEMORIA E QUANDO USAR VAI DAR EXCEPTION
    // o map recebe uma stream de um objeto e devolve uma stream de outro, no caso ai recebe uma de curso e devolve de inteiro. Mapeia de uma stream para stream
//    cursos.stream().filter(c -> c.getAlunos() >= 100).map(curso -> curso.getAlunos()).forEach(total -> System.out.println(total));
//    cursos.stream().filter(c -> c.getAlunos() >= 100).map(curso -> curso.getAlunos()).forEach(System.out::println);
    cursos.stream().filter(c -> c.getAlunos() >= 100).map(Curso::getAlunos).forEach(System.out::println);

    System.out.println("--------------------------------------------------------------");

    System.out.println("somando todo mundo da stream:");
    int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
    System.out.println("soma:" + sum);

    System.out.println("--------------------------------------------------------------");

    cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

    OptionalDouble media = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).average();
    System.out.println("media: " + media.getAsDouble());

    System.out.println("--------------------------------------------------------------");

    List<Curso> cursosListaFiltrada = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
    System.out.println("printando lista nova filtrada: ");
    cursosListaFiltrada.stream().forEach(curso -> System.out.println(curso.getNome()));

    System.out.println("--------------------------------------------------------------");

    System.out.println("printando lista normal: ");
    cursos.stream().forEach(curso -> System.out.println(curso.getNome()));

    System.out.println("--------------------------------------------------------------");

    System.out.println("map gerado atraves do stream");
    var map = cursos.stream().filter(curso -> curso.getAlunos() >= 100).collect(Collectors.toMap(curso -> curso.getNome(), curso -> curso.getAlunos()));
    System.out.println(map);

    System.out.println("--------------------------------------------------------------");
    map.forEach((nome, quantidadeDeAlunos) -> System.out.println(nome + "tem " + quantidadeDeAlunos + " alunos"));

    System.out.println("--------------------------------------------------------------");
    // esse faz usando multithreads sozinho
    cursos.parallelStream().filter(curso -> curso.getAlunos() >= 100).collect(Collectors.toMap(curso -> curso.getNome(), curso -> curso.getAlunos())).forEach((nome, quantidadeDeAlunos) -> System.out.println(nome + "tem " + quantidadeDeAlunos + " alunos"));
  }
}
