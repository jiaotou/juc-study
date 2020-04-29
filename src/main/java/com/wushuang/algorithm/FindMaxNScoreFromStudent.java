package com.wushuang.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/29 16:51
 */
public class FindMaxNScoreFromStudent {

    static class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if (o.getScore() > this.score) {
                return 1;
            } else if (o.getScore() < this.score) {
                return -1;
            }
            return 0;
        }
    }

    private TreeSet<Student> topN = new TreeSet<>();
    private List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        FindMaxNScoreFromStudent test = new FindMaxNScoreFromStudent();
        test.initList();//随机初始化学生分数
        test.topN(10);//获取前10个最高分
        test.printTopN();
    }

    /**
     * 打印TreeSet
     */
    public void printTopN() {
        // TODO Auto-generated method stub
        System.out.println("--------------------topN result----------------");
        int index = 0;
        for (Student student : topN) {
            index++;
            System.out.println("No:" + index + ",name=" + student.getName() + ",score=" + student.getScore());
        }
    }

    /**
     * 随机产生100个学生的分数，并初始化到studentList中
     */
    public void initList() {
        System.out.println("--------------------init----------------");
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            Student student = new Student("student" + i, rand.nextInt(100));
            studentList.add(student);
            //System.out.println("name = "+student.getName()+",score="+student.getScore());
        }
    }

    /**
     * 计算前N个最大的值
     *
     * @param N 返回前N个最大的值
     */
    public void topN(int N) {
        int minScore = 110;
        for (Student student : studentList) {
            //第一次运行
            if (minScore > 100) {
                minScore = student.getScore();
            }
            //首先填满topN
            if (topN.size() < N) {
                topN.add(student);
                if (student.getScore() < minScore) {
                    //更新最低分
                    minScore = student.getScore();
                }
                //topN已经填满，并且该学生的分数比最低分高
            } else if (student.getScore() > minScore) {
                //先删除topN中的最低分
                topN.remove(topN.last());
                topN.add(student);
                //更新最低分
                minScore = topN.last().getScore();
            }
        }
    }


}
