package com.test;

/**
 * @author Silence
 * @creat 2019-10-15  20:22
 */
public class SingleLinkDemo {
    public static void main(String[] args) {
/*        HeroNote hero1 = new HeroNote(1, "宋江", "及时雨");
        HeroNote hero2 = new HeroNote(2, "卢俊义", "玉麒麟");
        HeroNote hero3 = new HeroNote(3, "吴用", "智多星");
        HeroNote hero4 = new HeroNote(4, "林冲", "豹子头");
        SingleList singleList = new SingleList();
//        添加英雄
        singleList.add(hero1);
        singleList.add(hero3);
        singleList.add(hero4);
        singleList.add(hero2);
        singleList.list();*/
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleList singleList = new SingleList();
//        有序添加
        singleList.addByOrder(hero1);
        singleList.addByOrder(hero3);
        singleList.addByOrder(hero4);
        singleList.addByOrder(hero2);
        singleList.list();
        System.out.println("------------------------------");

//        修改英雄属性
        HeroNode newHero2 = new HeroNode(2, "小卢~", "玉麒麟~~~");
        singleList.updateByNo(newHero2);
        singleList.list();
        System.out.println("------------------------------");


//        删除
        singleList.deleteByNo(1);
        singleList.list();

        int length = singleList.getLength(singleList.getHead());
        System.out.println(length);
    }

    static class SingleList {
        //        头结点，不存放数据
        private HeroNode head = new HeroNode(0, "", "");

        /**
         * 添加节点到单项列表
         *
         * @param heroNode
         */
        public void add(HeroNode heroNode) {
//            temp存放头部节点
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
//            将最后一个节点的next指向新的节点
            temp.next = heroNode;
        }

        /**
         * 按顺序添加
         *
         * @param heroNode
         */
        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                } else if (temp.next.no > heroNode.no) {
                    break;
                } else if (temp.next.no == heroNode.no) {
                    flag = true;//说明编号存在
                    break;
                } else {
                    temp = temp.next;//后移，遍历链表
                }
            }
            if (flag) {
                System.out.println("准备添加的英雄的编号已存在，无法加入" + heroNode.no);
            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        /**
         * 根据no修改数据
         *
         * @param heroNode
         */
        public void updateByNo(HeroNode heroNode) {
            //判断是否空
            if (head.next == null) {
                System.out.println("链表为空~");
                return;
            }
            //找到需要修改的节点, 根据no编号
            //定义一个辅助变量
            HeroNode temp = head.next;
            boolean flag = false; //表示是否找到该节点
            while (true) {
                if (temp == null) {
                    break; //已经遍历完链表
                }
                if (temp.no == heroNode.no) {
                    //找到
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag 判断是否找到要修改的节点
            if (flag) {
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
            } else { //没有找到
                System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
            }
        }

        public void del(int no) {
            HeroNode temp = head;
            boolean flag = false; // 标志是否找到待删除节点的
            while(true) {
                if(temp.next == null) { //已经到链表的最后
                    break;
                }
                if(temp.next.no == no) {
                    //找到的待删除节点的前一个节点temp
                    flag = true;
                    break;
                }
                temp = temp.next; //temp后移，遍历
            }
            //判断flag
            if(flag) { //找到
                //可以删除
                temp.next = temp.next.next;
            }else {
                System.out.printf("要删除的 %d 节点不存在\n", no);
            }
        }

        /**
         * 根据no删除英雄
         * @param no
         */
        public void deleteByNo(int no) {
//            if (head.next == null) {
//                System.out.println("链表为空");
//                return;
//            }
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
//                到达链表尾部
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == no) {
//                    找到啦
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag){
                temp.next=temp.next.next;
            }else {
                System.out.println("未找到待删除英雄的编号"+no);
            }
        }


        /**
         * 输出链表
         */
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }

        /**
         * 获取头结点
         * @return
         */
        public HeroNode getHead() {
            return head;
        }

        /**
         * 获取链表长度
         * @param head
         * @return
         */
        public int getLength(HeroNode head){
            if(head.next==null){
                System.out.println("空链表");
                return 0;
            }
            int length = 0;
            HeroNode cur = head.next;
            while (cur!=null){
                length++;
                cur=cur.next;
            }
            return length;
        }
    }


    static class HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;//指向下一个节点


        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNote{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
