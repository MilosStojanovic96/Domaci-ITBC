package Sreda;

public class Zadatak1 {
    //    Biblord na autoputu treba da ispise poruku koja joj je prosledjena dalekovodima.
//    Kako su dalekovodi stari, cesto u prenosu poruke dodaju karaktere '$', '#' i '@' negde u poruku.
//    Napisati funkciju koja ispisuje originalnu poruku, bez tih dodatih simbola. Npr "Vo$z$ite $#@pazlj@i######vo!#" -> "Vozite pazljivo!"

    public static void withoutSymbol(String symbol) {
        symbol = symbol.replaceAll("#", "");
        symbol = symbol.replaceAll("@", "");
        symbol = symbol.replaceAll("\\$", "");
        System.out.println(symbol);
    }

    public static void main(String[] args) {
        String withSymbol = "Vo$z$ite $#@pazlj@i######vo!#";
        withoutSymbol(withSymbol);
    }

}
