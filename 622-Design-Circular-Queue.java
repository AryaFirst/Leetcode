//be careful when you initialize the value of front, end;
//because the end should be -1 at first,
//front should be 0
class MyCircularQueue {
    final int a[];
    public int front=0,
        end=-1,
        len=0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        a=new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            end=(end+1)%a.length;
            a[end]=value;
            len++;
            return true;
        }else return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            front=(front+1)%a.length;
            len--;
            return true;
        }else return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()) return a[front];
        else return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()) return a[end];
        else return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(len==0)return true;
        else return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(len==a.length)
            return true;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
