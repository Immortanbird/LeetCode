/*
* Design an iterator that supports the peek operation on a list in addition to the hasNext and the next operations.
* Implement the PeekingIterator class:
*       PeekingIterator(int[] nums) Initializes the object with the given integer array nums.
*       int next() Returns the next element in the array and moves the pointer to the next element.
*       bool hasNext() Returns true if there are still elements in the array.
*       int peek() Returns the next element in the array without moving the pointer.
* */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int temp = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}