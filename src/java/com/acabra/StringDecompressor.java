 package com.acabra;

 /**
  * Created by Agustin on 1/22/2019.
  * https://techdevguide.withgoogle.com/paths/advanced/compress-decompression/#code-challenge
 */
public class StringDecompressor {

    private static final char OPEN_BRACKET = '[';
    private static final char CLOSE_BRACKET = ']';

     private static class ReplaceExpression {
         final int openBracketIndex;
         final int closeBracketIndex;
         final int repetitions;
         final String parent;
         final int repetitionDigits;

         ReplaceExpression(int openBracketIndex, int closeBracketIndex, String repetitionsStr, String parent) {
             this.openBracketIndex = openBracketIndex;
             this.closeBracketIndex = closeBracketIndex;
             this.repetitions = Integer.parseInt(repetitionsStr);
             this.parent = parent;
             this.repetitionDigits = repetitionsStr.length();
         }

         private String replace() {
             return StringDecompressor.buildRepeatedString(parent.substring(openBracketIndex + 1, closeBracketIndex), repetitions);
         }

         @Override
         public String toString() {
             return "ReplaceExpression{" +
                     "openBracketIndex=" + openBracketIndex +
                     ", closeBracketIndex=" + closeBracketIndex +
                     ", repetitions=" + repetitions +
                     ", parent=" + parent +
                     '}';
         }
     }

     static String decompress(String input) {
         ReplaceExpression innerMostExpression = extractInnerMostExpression(input);
         if (innerMostExpression == null) return input;
         String ini = input.substring(0, innerMostExpression.openBracketIndex - innerMostExpression.repetitionDigits);
         String end = input.substring(innerMostExpression.closeBracketIndex + 1);
         return decompress(ini + innerMostExpression.replace() + end);
     }

     private static ReplaceExpression extractInnerMostExpression(String input) {
         int lastOpen = input.indexOf(OPEN_BRACKET);
         if (lastOpen < 0) return null;
         for (int i = lastOpen + 1; i < input.length(); i++) {
             char currentChar = input.charAt(i);
             if (currentChar == OPEN_BRACKET) {
                 lastOpen = i;
             } else if (currentChar == CLOSE_BRACKET) {
                 String amountRepetitionsStr = getAmountRepetitionsAsStr(input, lastOpen - 1);
                 return new ReplaceExpression(lastOpen, i, amountRepetitionsStr, input);
             }
         }
         return null;
     }

     private static String getAmountRepetitionsAsStr(String input, int endIndex) {
         StringBuilder sb = new StringBuilder();
         for (int i = endIndex; i >= 0 && Character.isDigit(input.charAt(i)); i--) {
             sb.append(input.charAt(i));
         }
         return sb.reverse().toString();
     }

    private static String buildRepeatedString(String string, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(string);
        }
        return sb.toString();
    }
}
