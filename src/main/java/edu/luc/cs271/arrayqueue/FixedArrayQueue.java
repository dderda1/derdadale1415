package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // Finished why do we need an explicit constructor? To initialize class properties

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = 0;
  }

  @Override
  public boolean offer(final E obj) {
    // Finished
    this.data; 
    if (rear >= capacity) {
      return false;
    }
    data[rear] = obj;
    rear = rear + 1;
    size++;
    return true;
  }

  @Override
  public E peek() {
    // Finished
    return data[front];
  }

  @Override
  public E poll() {
    // Finished
    E obj = data[front];
    data[front] = null;
    front++;
    size--;
    return obj;
  }

  @Override
  public boolean isEmpty() {
    // Finished
    
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
    
    return Arrays.asList();
  }
}
