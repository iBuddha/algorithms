package chapter1.section3.exercises.ex37;

import chapter1.section3.content.Queue;

/**
 * 快速解法参见http://maskray.me/blog/2013-08-27-josephus-problem-two-log-n-solutions
 * 令f(n)为有n个人时，最后一个死掉的人的编号。思路为找到f(n)和f(n-1)之间的关系。
 */
public class JosephusSimulation {
    private int M;
    private int N;
    private Queue<Integer> queue;

    public JosephusSimulation(int m, int n){
        this.M = m;
        this.N = n;
        queue = new Queue();
        for(int i = 0; i < n; i++)
            queue.enqueue(i);
    }

    public void print(){
        while(queue.size() > 1){
            for(int i = 1; i < M; i++){
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
    }

    public static void main(String[] args) {
        JosephusSimulation sim = new JosephusSimulation(2, 7);
        sim.print();
    }

}
