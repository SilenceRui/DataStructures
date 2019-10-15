package com.test;

import java.util.Scanner;

/**
 * @author Silence
 * @creat 2019-10-15  14:34
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        System.out.println("请输入数组长度");
        int length = scanner.nextInt();
        ArrayQueue queue = new ArrayQueue(length);
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):显示列头数据");
            System.out.println("d(exit):显示列尾数据");
            System.out.println("e(exit):退出程序");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数字");
                        int value = scanner.nextInt();
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.println("取出的数据是" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.println("取出的头数据是" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                    try {
                        int result = queue.endQueue();
                        System.out.println("取出的尾数据是" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

    static class ArrayQueue {
        private int maxSize;//数组最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;//存放数据，模拟队列

        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;//初始化数组
            rear = -1;//初始化数组
        }

        /**
         * 判断队列是否已满
         *
         * @return
         */
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * 添加数据
         *
         * @param n
         */
        public void addQueue(int n) {
            if (isFull()) {
                throw new RuntimeException("队列满，不能添加数据");
            } else {
                rear++;
                arr[rear] = n;
            }
        }

        /**
         * 取数据
         *
         * @return
         */
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            } else {
                front++;
                return arr[front];
            }
        }

        /**
         * 显示所有数据
         */
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列空，无数据");
            }else {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
            }
        }

        /**
         * 取出头数据
         *
         * @return
         */
        public int headQueue() {
            if (isEmpty()) {
                System.out.println("队列空，无数据");
            }
            return arr[front + 1];
        }

        public int endQueue() {
            if (isEmpty()) {
                System.out.println("队列空，无数据");
            }
            return arr[rear];
        }
    }
}
