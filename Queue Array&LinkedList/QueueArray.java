public class QueueArray<T> {

    T[] queue;
    int front, rear;

    QueueArray() {
        this(10);
    }

    QueueArray(int size) {
        queue = (T[]) new Object[size];
        front = rear = -1;
    }

    public void enqueue(T data) {
        if (isFull()) {
            T[] tempArr = (T[]) new Object[queue.length + 1];
            int i = 0;
            int j = front;

            do {
                tempArr[i++] = queue[j];
                j = (j + 1) % queue.length;
            } while (j != (rear + 1) % queue.length);

            front = 0;
            rear = queue.length - 1;
            queue = (T[])tempArr;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = data;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return null;
        }

        T temp = queue[front];                          //storing data in temp
        if (front == rear) {                            //if last element
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        return temp;
    }


    public boolean isFull() {
        return ((rear + 1) % queue.length) == front;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

}
