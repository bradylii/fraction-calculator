// BradyLi
// Ensure the above line contains your name in the formation FirstNameLastName
//
// You can test your code by pressing the `Run` button.
// Once you are happy with it, change the `ReadyForSubmission` line
// to say `YES` and press the `Run` button again to submit
// -----------------------------------------------------------------
// ReadyForSubmission=no
// Checkpoint = 4
import java.util.Scanner;

public class FracCalc {

  public static void main(String[] args) {
    // TODO: Read the input from the user and call produceAnswer with an equation
    Scanner console = new Scanner(System.in);
    System.out.print("Equation: (type quit to exit)");
    String equation = console.nextLine();
    produceAnswer(equation);
    // getting first equation
    while (!"quit".equals(equation)) {

      System.out.print("Equation: (type quit to exit)");
      String equation1 = console.nextLine();
      produceAnswer(equation1);

    } // loop of getting equations

  }

  // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
  // test your code
  // This function takes a String 'input' and produces the result
  //
  // input is a fraction string that needs to be evaluated. For your program, this
  // will be the user input.
  // e.g. input ==> "1/2 + 3/4"
  //
  // The function should return the result of the fraction after it has been
  // calculated
  // e.g. return ==> "1_1/4"
  public static String produceAnswer(String input) {
    // TODO: Implement this function to produce the solution to the input

    if (!"quit".equals(input)) {
      int operand1n = input.indexOf(" ");

      String operand1 = input.substring(0, operand1n);

      int endoperator = operand1n + 3;

      String operator = input.substring(operand1n + 1, endoperator - 1);

      String operand2 = input.substring(endoperator);

      int wholespot1 = operand1.indexOf("_");
      int wholespot2 = operand2.indexOf("_");
      int fracsymbol = operand1.indexOf("/");
      int fracsymbol2 = operand2.indexOf("/");

      String wholenum1 = operand1; // default values
      String numerator1 = "0";
      String denominator1 = "1";

      if (fracsymbol != -1) { // first operand
        if (wholespot1 != -1) {
          wholenum1 = operand1.substring(0, wholespot1);

        } else {
          wholenum1 = "0";
        }
        numerator1 = operand1.substring(wholespot1 + 1, fracsymbol);
        denominator1 = operand1.substring(fracsymbol + 1, operand1n);
      }

      String wholenum2 = operand2; // default values
      String numerator2 = "0";
      String denominator2 = "1";

      if (fracsymbol2 != -1) { // second operand
        if (wholespot2 != -1) {
          wholenum2 = operand2.substring(0, wholespot2);
          numerator2 = operand2.substring(wholespot2 + 1, fracsymbol2);
        } else {
          wholenum2 = "0";
        }
        numerator2 = operand2.substring(wholespot2 + 1, fracsymbol2);
        denominator2 = operand2.substring(fracsymbol2 + 1);
      }

      // String answer = ("whole:" + wholenum2 + " numerator:" + numerator2 +
      // "denominator:" + denominator2);

      // strings to ints
      int whole1 = Integer.parseInt(wholenum1);
      int whole2 = Integer.parseInt(wholenum2);
      int numer1 = Integer.parseInt(numerator1);
      int numer2 = Integer.parseInt(numerator2);
      int denom1 = Integer.parseInt(denominator1);
      int denom2 = Integer.parseInt(denominator2);

      String answer = "";
      // EX -2_-3/4 to -2_3/4
      if (wholenum1.indexOf("-") != -1) {
        numer1 = -numer1;
      }
      if (wholenum2.indexOf("-") != -1) {
        numer2 = -numer2;
      }
      int finalNumer = 0;
      int finalDenom = 1;
      int finalWhole = 0;
      if (operator.equals("+")) {
        if (denom1 != denom2) {
          finalWhole = whole1 + whole2;
          finalNumer = numer1 * denom2 + numer2 * denom1;
          finalDenom = denom1 * denom2;
        } else if (denom1 == denom2) {
          finalWhole = whole1 + whole2;
          finalNumer = numer1 + numer2;
          finalDenom = denom1;
        }
      }

      if (operator.equals("-")) {
        if (denom1 != denom2) {
          whole1 = whole1 * denom1;
          whole2 = whole2 * denom2;

          finalNumer = (whole1 + numer1) * denom2 - ((whole2 + numer2) * denom1);
          finalDenom = denom1 * denom2;

        } else if (denom1 == denom2) {
          finalWhole = whole1 - whole2;
          finalNumer = (numer1 - numer2);
          finalDenom = denom1;
        }

      }
      numer1 = (whole1 * denom1) + numer1;
      numer2 = (whole2 * denom2) + numer2;
      if (operator.equals("*")) {

        finalNumer = (numer1 * numer2);
        finalDenom = (denom1 * denom2);

      }
      if (operator.equals("/")) {

        finalNumer = (numer1 * denom2);
        finalDenom = (numer2 * denom1);

      }
      // normal equation
      answer = finalWhole + "_" + finalNumer + "/" + finalDenom;
      // 2_10/5 example
      if (Math.abs(finalNumer) > Math.abs(finalDenom)) {
        finalWhole = finalNumer / finalDenom + finalWhole;
        finalNumer = finalNumer % finalDenom;
        answer = finalWhole + "_" + finalNumer + "/" + finalDenom;
      }
      // 3/3 example
      if (finalNumer % finalDenom == 0) {
        answer = finalNumer / finalDenom + "";

      }
      // -2_-3/4 example
      if (finalWhole < 0) {

        if (finalNumer < 0) {
          finalNumer = -finalNumer;

        }

        if (finalDenom < 0) {
          finalDenom = -finalDenom;

        }
        answer = finalWhole + "_" + finalNumer + "/" + finalDenom;

      }

      // simplifying
      int gcd = Math.abs(finalNumer % finalDenom);

      for (int i = gcd; i >= 1; i--) {
        if (finalNumer % i == 0 && finalDenom % i == 0) {
          finalNumer /= i;
          finalDenom /= i;
          answer = finalWhole + "_" + finalNumer + "/" + finalDenom;

        }
      }
      // -5/-21 example
      if (finalNumer < 0 && finalDenom < 0) {
        answer = finalWhole + "_" + -finalNumer + "/" + -finalDenom;
      }
      // 5/-21 example
      if (finalNumer > 0 && finalDenom < 0) {
        answer = finalWhole + "_" + -finalNumer + "/" + -finalDenom;
      }

      // 0_2/5 example
      if (finalWhole == 0) {

        answer = answer.substring(answer.indexOf("_") + 1);
      }
      // 5_0/2 example
      if (finalNumer == 0) {
        answer = finalWhole + "";

      }

      System.out.println(answer);
      return answer;

    } else if ("quit".equals(input)) {
      System.out.println("program has stopped");
    } // quiting program

    return "";
  }

  // TODO: Fill in the space below with any helper methods that you think you will
  // need

}
