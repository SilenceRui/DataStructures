package com.test;

import java.io.*;
import java.net.URL;

/**
 * @author Silence
 * @creat 2019-10-15  13:18
 */

public class FileReadAndWriter {
    public static void main(String[] args) {
//        fileReader();
//        fileWriter();
        bufferedReader();
        bufferedWriter();
    }

    public static void fileWriter() {
        try {
            String path = FileReadAndWriter.class.getClassLoader().getResource("sparseArray.txt").getPath();
            FileWriter fileWriter = new FileWriter(path);
            System.out.println(path);
            fileWriter.write("股份的思考");
            fileWriter.write("dfhdkaschfv");
            fileWriter.write("45");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    public static void fileReader() {
        URL resource = FileReadAndWriter.class.getClassLoader().getResource("sparseArray.txt");
        String path = resource.getPath();
        System.out.println(resource);
        System.out.println("----------------------------");
        System.out.println(path);
        System.out.println(path);
//        String s = path.toString();
        int num = 0;
        char[] chars = new char[1024];
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (((num = fileReader.read(chars)) != -1)) {
                    System.out.println(new String(chars, 0, num));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void bufferedReader() {
        URL resource = FileReadAndWriter.class.getClassLoader().getResource("sparseArray.txt");
        String path = resource.getPath();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = null;
//            String[] strings = new String[1024];
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedWriter() {
        URL resource = FileReadAndWriter.class.getClassLoader().getResource("sparseArray.txt");
        String path = resource.getPath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write("kdmfgvhgkgnfdkghruo;gkcxvndkfg");
            bufferedWriter.newLine();
            bufferedWriter.write("kdmfgvhgkgnfdkghruo;gkcxvndkfg");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

