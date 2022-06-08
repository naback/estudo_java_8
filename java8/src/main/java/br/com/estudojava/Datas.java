package br.com.estudojava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
  public static void main(String[] args) {
    LocalDate hoje = LocalDate.now();
    System.out.println(hoje);

    LocalDate olimpiadasRio = LocalDate.of(2100, Month.JUNE, 5);
    System.out.println("anos que faltam pra olimpiadas: " + (olimpiadasRio.getYear() - hoje.getYear()));

    Period periodo = Period.between(hoje, olimpiadasRio);
    System.out.println("tempo que falta usando classe Period: " + periodo);

    LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
    System.out.println("tempo que falta para as proximas olimpiadas: " + proximasOlimpiadas);

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("proximas olimpiadas padrao brasileiro de data: " + proximasOlimpiadas.format(formatador));

    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatadorComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    System.out.println("dia, mes e hora em nosso formato: " + agora.format(formatadorComHora));

    LocalTime intervalo = LocalTime.of(15, 30);
    System.out.println("hora do intervalo: " + intervalo);
  }
}
