class Node {
    String data;
    Node next, prev;

    Node(String data) {
        this.data = data;
    }
}

class Train {
    Node head, tail;

    void addLast(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void remove(String name) {
        Node temp = head;

        while (temp != null && !temp.data.equals(name)) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
    }

    void printForward() {
        Node temp = head;

        System.out.print("Forward: ");

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }

        System.out.println();
    }

    void printBackward() {
        Node temp = tail;

        System.out.print("Backward: ");

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) System.out.print(" <-> ");
            temp = temp.prev;
        }

        System.out.println();
    }
}

public class TrainCoaches {
    public static void main(String[] args) {
        Train train = new Train();

        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
