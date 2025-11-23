package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DishStackTest {

    @Test
    void newStackHasSizeZero() {
        DishStack stack = new DishStack();
        assertEquals(0, stack.size(), "New stack should have size 0");
        assertTrue(stack.isEmpty(), "New stack should be empty");
    }

    @Test
    void pushIncreasesSizeAndPeekShowsTop() {
        DishStack stack = new DishStack();
        Dish oneDish = new Dish("one");
        Dish twoDish = new Dish("two");

        stack.push(oneDish);
        stack.push(twoDish);

        assertEquals(2, stack.size(), "Size should be 2 after two pushes");
        assertFalse(stack.isEmpty(), "Stack should not be empty");

        Dish top = stack.peek();
        assertNotNull(top, "Peek should not return null");
        assertEquals("two", top.getDescription(), "Top of stack should be the last pushed dish");
        assertEquals(2, stack.size(), "Peek should not change the size");
    }

    @Test
    void popReturnsTopAndDecreasesSize() {
        DishStack stack = new DishStack();
        Dish oneDish = new Dish("one");
        Dish twoDish = new Dish("two");

        stack.push(oneDish);
        stack.push(twoDish);

        Dish popped = stack.pop();
        assertNotNull(popped, "Popped dish should not be null");
        assertEquals("two", popped.getDescription(), "Popped dish should be the last pushed");

        assertEquals(1, stack.size(), "Size should be 1 after one pop");
        Dish remainingTop = stack.peek();
        assertEquals("one", remainingTop.getDescription(), "Remaining top should be the first dish");
    }

    @Test
    void popOnEmptyStackReturnsNullAndSizeStaysZero() {
        DishStack stack = new DishStack();

        Dish popped = stack.pop();
        assertNull(popped, "Popping from an empty stack should return null");
        assertEquals(0, stack.size(), "Size should remain 0 after popping empty stack");
        assertTrue(stack.isEmpty(), "Stack should still be empty");
    }

    @Test
    void pushOnFullStackDoesNotChangeSize() {
        // Small stack to easily fill it
        DishStack stack = new DishStack(2);
        Dish dish1 = new Dish("one");
        Dish dish2 = new Dish("two");
        Dish dish3 = new Dish("three");

        stack.push(dish1);
        stack.push(dish2);

        assertTrue(stack.isFull(), "Stack should be full after two pushes");

        int sizeBefore = stack.size();
        stack.push(dish3); // should not be added
        int sizeAfter = stack.size();

        assertEquals(sizeBefore, sizeAfter, "Size should not change when pushing onto a full stack");

        // Top should still be "two"
        Dish top = stack.peek();
        assertNotNull(top);
        assertEquals("two", top.getDescription(), "Top should remain the same after failed push");
    }

    @Test
    void peekOnEmptyStackReturnsNull() {
        DishStack stack = new DishStack();

        Dish top = stack.peek();
        assertNull(top, "Peeking an empty stack should return null");
        assertEquals(0, stack.size(), "Size should remain 0 after peeking empty stack");
    }
}
