package com.main;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "matrix.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.mark (1);
            int dim = reader.readLine().split (" ").length;
            System.out.println ("matrix dimension: ");
            System.out.println (dim);
            String [][] matrix = new String[dim][dim];
            String [][] originalMatrix = new String[dim][dim];
            int counter = 0;
            String line;

            reader.reset ();

            while ((line = reader.readLine()) != null) {

                originalMatrix[counter] = line.split (" ");

                String[] elems =  line.split (" ");

                for (int i = 0; i < dim; i++) {
                    matrix[i][dim - 1 - counter] = elems[i];
                }

                counter++;
            }

            String fileName = "matrixOut.txt";
            File newFile = new File(fileName);

            try {
                if (newFile.createNewFile()) {
                    System.out.println("File has been created");
                }
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            FileWriter writer = new FileWriter(fileName, true);

            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    writer.write (originalMatrix[i][j] + " ");
                }
                writer.write ("\n");
            }

            writer.write ("\n");

            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    writer.write (matrix[i][j] + " ");
                }
                writer.write ("\n");
            }

            writer.close ();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
