package com.cjervin.arithmetic.collection.list;

/**
 * 线性表
 *
 * @author ervin
 * @Date 2021/4/18
 */
public interface ListInterface<T> {

    /**
     * 初始化
     *
     * @param size
     */
    void init(int size);

    /**
     * 长度
     *
     * @return
     */
    int length();


    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取元素下标
     *
     * @param t
     * @return
     */
    int eleIndex(T t);

    /**
     * 根据index获取数据
     *
     * @param index
     * @return
     * @throws Exception
     */
    T getEle(int index) throws Exception;

    /**
     * 根据index插入数据
     *
     * @param index
     * @param t
     * @throws Exception
     */
    void add(int index, T t) throws Exception;

    /**
     * 删除元素
     *
     * @param index
     * @throws Exception
     */
    void delete(int index) throws Exception;

    /**
     * 尾部插入元素
     *
     * @param t
     * @throws Exception
     */
    void add(T t) throws Exception;

    /**
     * 修改
     *
     * @param index
     * @param t
     * @throws Exception
     */
    void set(int index, T t) throws Exception;

}
