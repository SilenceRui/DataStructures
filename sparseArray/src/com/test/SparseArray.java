package com.test;
import java.io.*;

/**
 * @author Silence
 * @creat 2019-10-15  13:16
 */

public class SparseArray {
    public static void main(String[] args) {
//        创建棋盘
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][7] = 2;
//        输出原始数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }

//          遍历数组，计算非零元素的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }
        System.out.println("非零元素的个数" + sum);

//        创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

//        给稀疏数组赋值
        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

//        //        输出稀疏数组
//        System.out.println("---------------------------");
//        System.out.println("稀疏数组：");
//        for (int i = 0; i < sparseArr.length; i++) {
//            System.out.print(sparseArr[i][0]+"\t");
//            System.out.print(sparseArr[i][1]+"\t");
//            System.out.print(sparseArr[i][2]+"\t");
//            System.out.println();
//        }

//        输出稀疏数组
        System.out.println("------------------------jk---");
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("\t" + sparseArr[i][j]);
            }
            System.out.println();
        }

//        把稀疏数组写入磁盘
        try {
            String path = SparseArray.class.getClassLoader().getResource("sparseArray.txt").getPath();
//            System.out.println(path);
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int[] row : sparseArr) {
                for (int i : row) {
                    bw.write("\t" + i);
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        把稀疏数组从磁盘读出
        System.out.println("把稀疏数组从磁盘读出");
        try {
            String path = SparseArray.class.getClassLoader().getResource("sparseArray.txt").getPath();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        对稀疏数组进行恢复
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

//        输出由稀疏数组恢复后的数组
        System.out.println("---------------------------------------");
        System.out.println("由稀疏数组恢复后的数组：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
    }
}

