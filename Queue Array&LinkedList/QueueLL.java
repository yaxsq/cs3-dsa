public class QueueLL<T>{

    NodeQ<T> front;
    NodeQ<T> rear;

    QueueLL() {
        front = rear = null;
    }

    public void enqueue(T data) {
        if (front == null) {
            front = new NodeQ<>(data);
            rear = front;
        } else {
            rear.next = new NodeQ<>(data);
            rear = rear.next;
        }
    }

    public NodeQ dequeue() {
        if (front == null) {                                                //if empty
            return null;
        } else if (front == rear) {                                         //if one element
            NodeQ temp = front;
            front = rear = null;
            return temp;
        } else {
            NodeQ temp = front;
            front = front.next;
            return temp;
        }
    }

    public boolean isEmpty() {
        if (front == null) {
            return true;
        }
        return false;
    }

}
