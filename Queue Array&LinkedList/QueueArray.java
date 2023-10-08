public class QueueArray<T> {

    T[] queue;
    int front, rear;

    QueueArray() {
        queue = (T[]) new Object[10];
        front = rear = 9;
    }

    QueueArray(int size) {
        queue = (T[]) new Object[size];
        front = rear = size - 1;
    }

    public void enqueue(T data) {
        if (isFull()) {
            T[] tempArr = (T[]) new Object[queue.length + 1];

            for (int i = 0; i < queue.length; i++) {
                tempArr[i] = queue[(front + i) % queue.length];
            }

            front = 0;
            rear = queue.length;

            queue = tempArr;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = data;

        if (front == 9) {
            front = rear;
        }

//        if (front == 9) {
//            front = rear;
//        }
//
//        if (isFull()) {
//            System.out.println("Queue full");
//            return;
//        }
//        if (isEmpty()) {
//            front = 9;
//        }
//
//        queue[rear] = data;
//        rear = (rear + 1) % queue.length;
//        System.out.println("ADDED " + data);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return null;
        }

        T temp = queue[front];
        if (front == rear) {
            front = rear = 9;
        } else {
            front = (front + 1) % queue.length;
        }
        return temp;
    }


    public boolean isFull() {
        return ((rear + 1) % queue.length) == front;

//        if ((front == 0 && rear == queue.length - 1) || (front == (rear + 1) % queue.length))
//            return true;
//        return false;
    }

    public boolean isEmpty() {
        return front == 9 && rear == 9;
    }

}
