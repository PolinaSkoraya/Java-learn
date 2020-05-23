package by.learn.textparser.runner;

import by.learn.textparser.components.Text;
import by.learn.textparser.utils.Reader;

import static by.learn.textparser.utils.Parser.cost;

public class SecondRunner {
    public static void main(String[] args) {
        String path = "D:\\Univer_labs\\JAVA\\string\\test2.txt";
        Text text = new Text(Reader.fromFile(path));

        System.out.println ("telegram cost: ");
        System.out.println (cost (text, 1));
    }
}
