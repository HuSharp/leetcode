import java.util.HashMap;
import java.util.HashSet;

import sun.security.krb5.internal.Ticket;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-04 11:08:48
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-04 15:55:02
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    // 定制节点
    private class Node {
        private int value;
        private Node last;
        private Node next;

        public Node(int val) {
            this.value = val;
        }

        private void aa() {
            
        }
    }

    // 自制双端链表
    // 由于是 LRU 结构
    public class NodeDoubleLinkedList {
        private Node head;
        private Node tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // 加入节点(加到尾结点)
        private void addNode(Node newNode) {
            if(newNode == null) {
                return;
            }
            // 若是链表为空
            if(this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {// 若非空
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        // 由于 本人实现 LRU 采用最近缓存为尾结点，
        // 因此当遇到 LRU 中还有的节点时， 移到尾结点即可
        private void moveNodeToTail(Node curNode) {
            if(this.tail == curNode) {
                return;
            }
            // 说明此时不为尾结点
            // 注意！！此时可能为头结点， 需要进行判断
            if(this.head == curNode) {
                this.head = curNode.next;
                curNode.next.last = null;
            } else {// 说明为中间节点
                curNode.last.next = curNode.next;
                curNode.next.last = curNode.last;
            }

            this.tail.next = curNode;
            curNode.next = null;
            curNode.last = this.tail;
            this.tail = curNode;
        }

        // 当缓存满时， 进行删除 Head
        private Node removeHead() {
            // 首先判断是否为空
            if(this.head == null) {
                return null;
            }
            // 至此不为空
            // 判断是否只有一个
            Node preHead = this.head;
            if(this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {//说明 >= 2
                // 还应该记得将 之前 head 的 next 去掉！！！
                Node newHead = this.head.next; 
                this.head.next = null;
                newHead.last = null;
                this.head = newHead;
            }
            return preHead;
        }
    }

    // 至此 实现了 双向链表结构
    // 主要采用 map 记录当前在链表中的值， 再进行移入移出
    private HashMap<Node, Integer> nodeKeyMap;
    private HashMap<Integer, Node> keyNodeMap;
    private NodeDoubleLinkedList lru;
    int capacity;
    public LRUCache(int capacity) {
        this.nodeKeyMap = new HashMap<>();
        this.keyNodeMap = new HashMap<>();
        this.lru = new NodeDoubleLinkedList();
        this.capacity = capacity;
    }
    
    // 取优先级最高的
    public int get(int key) {
        if(keyNodeMap.containsKey(key)) {
            Node res = this.keyNodeMap.get(key);
            // 然后将优先级提前
            this.lru.moveNodeToTail(res);
            return res.value;
        } else {
            return -1;
        }

    }
    // 放置
    public void put(int key, int value) {
        // 若没有， 那就放入各个容器中
        if(!keyNodeMap.containsKey(key)) {
            Node curNode = new Node(value);
            this.lru.addNode(curNode);
            this.keyNodeMap.put(key, curNode);
            this.nodeKeyMap.put(curNode, key);
            // 还需要判断 缓存大小！！！
            if(this.keyNodeMap.size() == this.capacity + 1) {
                // 现在需要移除 head
                Node preHead = this.lru.removeHead();
                // 再从两个 map 中删掉
                int headKey = nodeKeyMap.get(preHead);
                this.nodeKeyMap.remove(preHead);
                this.keyNodeMap.remove(headKey);
            } 
        } else {// 说明有 key
            Node curNode = this.keyNodeMap.get(key);
            curNode.value = value;// 更新
            this.lru.moveNodeToTail(curNode);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @    lc code=end

