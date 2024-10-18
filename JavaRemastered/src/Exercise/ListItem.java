package Exercise;

import org.w3c.dom.NodeList;

abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    // Abstract methods
    abstract ListItem next(); // Returns the item to the right
    abstract ListItem setNext(ListItem item); // Sets the item to the right

    abstract ListItem previous(); // Returns the item to the left
    abstract ListItem setPrevious(ListItem item); // Sets the item to the left

    abstract int compareTo(ListItem item); // Compares current item to another

    // Getters and setters for value
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

class Node extends ListItem{

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return item;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}

class MyLinkedList implements NodeList{

    ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot(){
        return this.root;
    }

    @Override
    public org.w3c.dom.Node item(int index) {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
