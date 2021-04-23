package com.cjervin.arithmetic.collection.queue;


/**
 * 基于数组实现的队列
 *
 * @author ervin
 * @Date 2021/4/23
 */
public class ArrayQueue<T> {


    private Object[] data;

    private int head;
    private int tail;

    public ArrayQueue(int size) {
        this.data = new Object[size];
        this.head = 0;
        this.tail = 0;
    }


    /**
     * 入队
     *
     * @param t
     * @return
     */
    public void add(T t) {
        //tail 指针已经到达最尾部
        if (this.tail == data.length) {
            //head 指针不等于 0 ，说明队列的头部有多余空间
            if (this.head != 0) {
                //数据迁移，所有元素向前移动 head 位
                for (int i = head; i < tail; i++) {
                    data[i - head] = data[i];
                }
                this.tail -= head;
                this.head = 0;
            } else {
                //扩容
                Object[] temp = new Object[data.length * 2];
                for (int i = 0; i < data.length; i++) {
                    temp[i] = this.data[i];
                }
                this.data = temp;
            }
        }
        this.data[tail++] = t;
    }

    public T poll() throws Exception {
        if (this.head == this.tail) {
            throw new Exception("queue empty");
        }
        return (T) this.data[head++];
    }

    public boolean isEmpty() {
        return this.tail == this.head;
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue<String> queue = new ArrayQueue(5);
        queue.add("a");
        queue.add("b");
        queue.add("c");

        queue.poll();

        queue.add("d");
        queue.add("e");
        queue.add("f");
        queue.add("g");
        queue.add("h");
        queue.add("i");
        queue.add("j");

        while (!queue.isEmpty()){
            System.out.println("queue poll:" + queue.poll());
        }

    }

}
