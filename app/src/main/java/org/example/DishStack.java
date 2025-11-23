package org.example;

public class DishStack {

    private Dish[] stackArray;
    private int top; 

    private static final int DEFAULT_CAPACITY = 10;

    // Default constructor
    public DishStack() {
        this.stackArray = new Dish[DEFAULT_CAPACITY];
        this.top = -1;
    }

    
    public DishStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.stackArray = new Dish[capacity];
        this.top = -1;
    }

    
    public void push(Dish dish) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push new dish.");
            return; 
        }
        stackArray[++top] = dish;
    }

    
    public Dish pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to pop.");
            return null;
        }
        Dish popped = stackArray[top];
        stackArray[top] = null; 
        top--;
        return popped;
    }

    
    public Dish peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null;
        }
        return stackArray[top];
    }

    
    public int size() {
        return top + 1;
    }

    
    public boolean isEmpty() {
        return top == -1;
    }

    
    public boolean isFull() {
        return top == stackArray.length - 1;
    }
}

