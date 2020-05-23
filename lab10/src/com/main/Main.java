package com.main;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<Character> openBrcktStack = new Stack<>();
    private static Bracket [] brcketBox = {
            new Bracket('(',')'),
            new Bracket('[',']'),
            new Bracket('<','>'),
    };

    private static String getTypeBrackets() {
        StringBuilder boxRet = new StringBuilder();

        for (Bracket tmpBrt : brcketBox) {
            boxRet.append(tmpBrt.getOpenBrkt()).append(' ').append(tmpBrt.getCloseBrkt()).append(',');
        }

        return boxRet.append('\n').toString();
    }

    private static boolean isValidString(String str) {
        if (str.length() < 2)
            return false;
        boolean result = false;

        for (Bracket tmpBrt : brcketBox) {
            if (str.indexOf(tmpBrt.getOpenBrkt()) > -1 || str.indexOf(tmpBrt.getCloseBrkt()) > -1)
                result = true;
        }

        return result;
    }

    private static boolean isLegalBrackets(String str) {
        for (char tmpChar : str.toCharArray()) {
            for (Bracket tmpBrt : brcketBox) {
                if (tmpBrt.isChageBrktCondition(tmpChar)) {
                    if (tmpBrt.isFlagOpenBrkt()) {
                        openBrcktStack.push(tmpBrt.getOpenBrkt());
                    }

                    if (tmpBrt.isFlagCloseBrkt()) {
                        if (openBrcktStack.empty () || !openBrcktStack.pop ().equals (tmpBrt.getOpenBrkt ())) {
                            openBrcktStack.clear ();
                            return false;
                        }
                    }
                }
            }
        }

        if (!openBrcktStack.empty()) {
            openBrcktStack.clear();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String typeBrackts = getTypeBrackets();
        System.out.printf("Введите строку содержащую скобки следующих типов:%n%s", typeBrackts);
        String str;

        do {
            str = userInput.nextLine();
            if (isValidString(str))
                System.out.println(isLegalBrackets(str));
            else  System.out.println("Введенная строка не корректна!");
        } while (userInput.hasNext());
    }
}