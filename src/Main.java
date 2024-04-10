import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Menu.ShowMenu();
    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();

    while (option != 9) {
      switch (option) {
        case 1 -> {
          System.out.print("Digite o valor em Dólar: ");
          double dollar = scanner.nextDouble();
          System.out.println("O valor em Peso Argentino é: " + CurrencyConverter.Convert("USD", "ARS", dollar).conversion_result);
        }
        case 2 -> {
          System.out.print("Digite o valor em Peso Argentino: ");
          double peso = scanner.nextDouble();
          System.out.println("O valor em Dólar é: " + CurrencyConverter.Convert("ARS", "USD", peso).conversion_result);
        }
        case 3 -> {
          System.out.print("Digite o valor em Real: ");
          double euro = scanner.nextDouble();
          System.out.println("O valor em Euro é: " + CurrencyConverter.Convert("BRL", "EUR", euro).conversion_result);
        }
        case 4 -> {
          System.out.print("Digite o valor em Euro: ");
          double real = scanner.nextDouble();
          System.out.println("O valor em Real é: " + CurrencyConverter.Convert("EUR", "BRL", real).conversion_result);
        }
        case 5 -> {
          System.out.print("Digite o valor em Dólar: ");
          double dollarToEuro = scanner.nextDouble();
          System.out.println("O valor em Euro é: " + CurrencyConverter.Convert("USD", "EUR", dollarToEuro).conversion_result);
        }
        case 6 -> {
          System.out.print("Digite o valor em Euro: ");
          double euroToDollar = scanner.nextDouble();
          System.out.println("O valor em Dólar é: " + CurrencyConverter.Convert("EUR", "USD", euroToDollar).conversion_result);
        }
        case 7 -> {
          System.out.print("Digite o valor em Real: ");
          double realToDollar = scanner.nextDouble();
          System.out.println("O valor em Dólar é: " + CurrencyConverter.Convert("BRL", "USD", realToDollar).conversion_result);
        }
        case 8 -> {
          System.out.print("Digite o valor em Dólar: ");
          double dollarToReal = scanner.nextDouble();
          System.out.println("O valor em Real é: " + CurrencyConverter.Convert("USD", "BRL", dollarToReal).conversion_result);
        }
        default -> System.out.println("Número inválido!");
      }
      Menu.ShowMenu();
      option = getValidOption(scanner);
    }
  }

  private static int getValidOption(Scanner scanner) {
    int option = -1;
    boolean validOption = false;
    while (!validOption) {
      try {
        System.out.print("Digite um número entre 1 e 9: ");
        option = scanner.nextInt();
        if (option >= 1 && option <= 9) {
          validOption = true;
        } else {
          System.out.println("Entrada inválida. Por favor Digite um número entre 1 e 9.");
          Menu.ShowMenu();
        }
      } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor Digite um número.");
        Menu.ShowMenu();
        scanner.next();
      }
    }
    return option;
  }
}