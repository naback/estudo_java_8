package br.com.estudojava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Curso {
  private String nome;
  private int alunos;
}
