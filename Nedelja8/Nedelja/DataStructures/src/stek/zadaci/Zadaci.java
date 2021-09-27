package stek.zadaci;


import java.util.Arrays;
import java.util.Stack;

public class Zadaci {

    /*
     * 1. Palacinke <-> za zadati niz izbaciti poslednjih n elemenata i obrnuti ga
     * Sara pravi palacinke sa dzemom, nutelom i sunkom za svoje drugare.
     * Funkciji se prosledjuje niska sa vrsom palacinke koju je Sara napravila, odovjene novim redom, redom;
     * kao i broj n koji oznacava koliko palacinaka ce pojesti Sarini prijatelji.
     * Ispisati kojim redom ce koje palacinke Sara pojesti posle svojih drugara, ako znamo da ce da pojede sve koje ostanu.
     *
     * NPR:
     * Nutela
     * Sunka
     * Nutela
     * Dzem
     * 2
     * ---------
     * Sunka
     * Nutela
     * */


    public static String palacinke(String s, int n){
        Stack<String> palacinke = new Stack<>();
        String[] token = s.split("\n");
        for (int i = 0; i < token.length; i++) {
            palacinke.push(token[i]);
        }
       /* while (!palacinke.isEmpty())
            System.out.println(palacinke.pop());*/

        for (int i = 0; i < n; i++) {
            if(!palacinke.isEmpty())
                palacinke.pop();
        }
        String res = "";
        while(!palacinke.isEmpty()) {
           res += palacinke.pop().concat("\n");
            }
        res = res.trim();
        if (res.isEmpty())   // ili -> res.equals("")
            return ":(";
        else
        return res;
    }

//    public static void main(String[] args) {
//        String s = "Nutela\nSunka\nNutela\nDzem";
//        System.out.println(palacinke(s,2));
//    }


    /*
     * 2. Istorija web pregledaca
     * Прегледач веба памти историју посећених сајтова и корисник има могућност да се враћа унатраг на сајтове које је раније посетио.
     * Написати програм који симулира историју прегледача тако што се учитавају адресе посећених сајтова (свака у посебном реду),
     * а када се учита ред у коме пише back прегледач се враћа на последњу посећену страницу.
     * Ако се наредбом back вратимо на почетну страницу, исписати -.
     * Ако се на почетној страници изда наредба back, остаје се на почетној страници.
     * Програм треба да испише све сајтове које је корисник посетио.
     * Улаз: Са стандардног улаза се учитавају веб-адресе, свака у посебној линији, koje се даље уписују у String, свака у посебном реду.
     * Излаз: Вратити String са исписаним сајтовима редом посећиваним.
     * */

    public static String history(String search){
        String[] tokens = search.split("\n");
        Stack<String> sajtovi = new Stack<>();
        String res = "";
        for (int i = 0; i < tokens.length; i++) {
            String trenutni = tokens[i];
            if (!trenutni.equals("back")) {
                //Sajt
                sajtovi.push(trenutni);
                res += trenutni + "\n";
            }
            else {
                //Naredba back
                if (!sajtovi.isEmpty())
                    sajtovi.pop();
                if (sajtovi.isEmpty())
                    res += "-\n";
                else
                    res += sajtovi.peek() + "\n";
            }
        }
        return res.trim();
    }


    /*
     * 3. Uparenost zagrada:
     * У изразу учествују следеће врсте заграда (, ), {, }, [ и ].
     * Напиши програм који проверава да ли су у унетом изразу заграде исправно упарене.
     * Улаз: Са стандардног улаза се уноси израз (цео у једном реду, без размака), које се даље уписују у String.
     * Излаз: Boolean.
     * */


    public static boolean uparenost(String s){
        Stack<Character> stack = new Stack<>();
     for (char zagrada : s.toCharArray()){
         if(zagrada == '(' || zagrada == '[' || zagrada == '{'){
             stack.push(zagrada);
         }
        else if(zagrada == ')' || zagrada == ']' || zagrada == '}'){
             if(stack.isEmpty())
                 return false;
             //pop
             char a = stack.pop();
             if ((zagrada == ')' && a !='(') || (zagrada == ']' && a !='[') || (zagrada == '}' && a !='{'))
                 return false;
         }
     }
     return stack.isEmpty();

//     if(stack.isEmpty())
//         return true;
//     else
//         return false;
    }

    /*
     * 4. Uzastopni brojevi
     * Низ се трансформише тако што се сваких 2 узастопних појављивања неког елемента бришу.
     * Напиши програм који одређује садржај низа након исцрпне примене ове трансформације.
     * Улаз:Са стандардног улаза се учитава елементи низа.
     * Излаз: На стандардни излаз исписати елементе резултујућег низа, раздвојене размаком.
     * NPR:
     * [] -> "1 3 3 2 1"
     * -ako je prazan = push
     * -ako nije praza:
     *   -ako se gadjaju = pop
     *   -ako se ne gadjaju = {ubaci u resenje, popu, pushuj trenutni}
     * ----------
     * -ako stack nije prazan = ubaciti stack u resenje
     *  1 1 2 2 2 2 1 3 4 4 5 5 4 4 3 2 1 1 1
     * ^
     * "1 3 3 2 1"
     * */

    public static String uzastopni(int[] arr){
        Stack<Integer> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            //da li je stack prazan
            if(stack.isEmpty())
                stack.push(arr[i]);
            else{
                //Stack nije prazan
                //Da li se gadjaju trenutni element i vrh stack-a
                if(arr[i] == stack.peek()){
                    //gadjaju se
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else{
                    //ne gadjaju se
                    res += stack.pop() + " ";
                    stack.push(arr[i]);
                }
            }
        }
        while(!stack.isEmpty())
            res += stack.pop() + " ";
        return res.trim();
    }

    /*
     * 5. Linijski editor
     * Sa standardnog ulaza se unose niske karaktera koje opisuju neku akciju. Akcije su sledece:
     * iX - korisnike je otkucao karakter X
     * < - korisnik je pritisnuo taster levo
     * > - korisnik je pritisnuo taster desno
     * b - korisnik je pritisnuo taster backspace za brisanje karaktera iza kursora
     * d - korisnik je pritisnuo taster delete za brisanje karaktera ispred kursora
     *
     * Vratiti String dobijen izvrsavanjem svih ackija
     *
     * NPR:
     * iaib<bic>>
     * cb
     *
     * Objasnjenje:
     * Tekst     Naredba
     * |         ia
     * a|        ib
     * ab|       <
     * a|b       b
     * |b        ic
     * c|b       >
     * cb|       >
     * cb|
     *
     * */

    public static String console(String input) {
        /*
         * Komande:
         * insert X    | iX | klikni dugme X
         * backspace   | b  | klikni dugme Backspace
         * delete      | d  | klikni dugme Delete
         * Left Arrow  | <  | klikni dugme Left Arrow
         * Right Arrow | >  | klikni dugme Right Arrow
         * */

        // "iHieililio<<<b" -> "Hllo"

        // "NekiTw|st"
        // [N, e, k, i, T, w] | [t, s]

        /*
         * iX -> push u levi stack karakter X
         * b -> pop iz levog stack-a
         * d -> pop iz desnog stack-a
         * < -> pop iz levog stack-a i push u desni
         * > -> pop iz desnog stack-a i push u levi
         * */

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        char[] chars = input.toCharArray();
        int i = 0;
        String res = "";
        while (i < chars.length){
            char trenutni = chars[i];
            switch (trenutni){
                case 'i':
                    left.push(chars[i+1]);
                    break;
                case 'b':
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case 'd':
                    if (!right.isEmpty())
                        right.pop();
                    break;
                case '<':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case '>':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
            }
            i++;
        }
        // l:[x,Y] d:[S,e]
        // l:[Y, x] d:[S, e]
        // xYeS
        // "ixiYieis<<" -> "xY|es" -> "xYes" -> obrnuto(l).obrnuto(d)
        Stack<Character> pomocni = new Stack<>();
        while(!left.isEmpty())
            pomocni.push(left.pop());
        while (!pomocni.isEmpty())
            res += String.valueOf(pomocni.pop());
        while(!right.isEmpty())
            res += String.valueOf(right.pop());
        return res;
    }

    /*
     * 6. Vrednost postfiksnog izraza
     * Са стандардног улаза се учитава постфиксно записан израз
     * који садржи једноцифрене бројеве и операторе +, -, * и / (без размака).
     * Ispisati vrednost izraza
     *
     * NPR:
     * 12+3*
     * 9
     *
     * Objasnjenje:
     * 112+3*+ -> ((1+2)*3)+1 = 10 add(mul(add(1, 2), 3), 1);
     *
     * [] resnje = 10
     * 112+3*+
     *         ^
     * Strategija:
     * - ako si naleteo na broj = push na stack
     * - ako ... na operaciju = 2xpop sa steka, odradi operaciju, resenje push na stek
     * --------------
     * resenje = stack.pop()
     * */

   /* public static int add(int a, int b){
        return  a + b;
    }

    public static int mul(int a, int b){
        return  a * b;
    }*/

   /* public static void main(String[] args) {
        //System.out.println(mul(add(1, 2), 3));
        System.out.println(eval("12+*"));
    }*/

    public static int eval(String s){
       Stack<Integer> stack = new Stack<>();
       for(char c : s.toCharArray()){
           //ako je broj
           if(Character.isDigit(c))
               stack.push(Character.getNumericValue(c));
           else{
               //operacija
               if(c == '+'){
                   stack.push(stack.pop() + stack.pop());
               }
               else if (c == '*'){
                   stack.push(stack.pop() * stack.pop());
               }
               else if (c == '-'){
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a - b);
               }
               else{
                   // c == '/'
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a / b);
               }
           }
       }
        return stack.pop();
    }


    /*
    * 7. Berza
    * Duzina Si cene nekoe hartije ne berzi je definisana kao najveci broj uzastopnih dana,
    * pre datog dana, za koje je cena hartije manja ili jednaka trenutnoj ceni.
    * Za dat niz cena jedne hartije, vratiti niz duzina Si za svaki od tih dana
    *
    * NPR:
    * Cene po danima:      [100, 80, 60, 70, 60, 75, 85]
    * Si duzine po danima: [  1,  1,  1,  2,  1,  4,  6]
    * */

    private static Stack<Integer> obrni(Stack<Integer> stack){
        Stack<Integer> ret = new Stack<>();
        while (!stack.isEmpty())
            ret.push(stack.pop());
        return ret;
    }

    private static int levo(Stack<Integer> stack, int t){
        int br = 0;
        Stack<Integer> copy1 = new Stack<>();
        Stack<Integer> copy2 = new Stack<>();
        // stack -> copy1, copy2 ; obrisace stack
        while(!stack.isEmpty()){
            int i = stack.pop();
            copy1.push(i); // radni stek <- obrnuti od stack
            copy2.push(i); // storage stek <- bornuti od stack
        }
        copy1 = obrni(copy1);
        while(!copy1.isEmpty()){
            int trenutni = copy1.pop();
            if (trenutni <= t)
                br++;
            else
                break;
        }
        // vratimo copy2 -> stack
        while (!copy2.isEmpty())
            stack.push(copy2.pop());
        return br;
    }

    public static int[] hartije(int... hartija){ //1, 2, 3 -> []
        int[] res = new int[hartija.length]; // hartija[2];
        res[0] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(hartija[0]);
        for (int i = 1; i < hartija.length; i++) {
            int trenutni = hartija[i];
            // koliko levo od trenutnog ima manjih ili jednakih
            stack.push(trenutni);
            int manji = levo(stack, trenutni);
            res[i] = manji;
        }
        return res;
    }

    public static void main(String[] args) {
        //* Cene po danima:      [100, 80, 60, 70, 60, 75, 85]
        //* Si duzine po danima: [  1,  1,  1,  2,  1,  4,  6]
        int[] resenje = hartije(100, 80, 60, 70, 60, 75, 85);
        System.out.println(Arrays.toString(resenje));
    }
}
