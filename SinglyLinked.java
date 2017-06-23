/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizbackend;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author KienBeo
 */

public class SinglyLinked {
    // reference to the head node.
    private Node head;
    private Node tail;
    private int listCount;

    // LinkedList constructor
    public SinglyLinked()
    {
        head = new Node(null);
        listCount = 0;
    }
    //append
    public void add(int data){
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
        tail = current;
        listCount++;
    }
    
    //append index
    public void add(int data, int index){
        Node temp = new Node(data);
        Node current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for(int i = 1; i < index && current.getNext() != null; i++)
        {
                current = current.getNext();
        }
        // set the new node's next-node reference to this node's next-node reference
        temp.setNext(current.getNext());
        // now set this node's next-node reference to the new node
        current.setNext(temp);
        listCount++;// increment the number of elements variable
    }

    //get node index
    public Node get(int index){
        // index must be 1 or higher
        if(index <= 0)
                return null;

        Node current = head.getNext();
        for(int i = 1; i < index; i++)
        {
            if(current.getNext() == null)
                    return null;

            current = current.getNext();
        }
        return current;
    }

    //remove by index
    public boolean remove(int index){
        
        // if the index is out of range, exit
        if(index < 1 || index > size())
                return false;

        Node current = head;
        for(int i = 1; i < index; i++)
        {
            if(current.getNext() == null)
                    return false;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; // decrement the number of elements variable
        return true;
    }

    //clear all
    public void removeAll(){
        head.setData(null);
        head.setNext(null);
    }
    
    //get list size
    public int size(){
        return listCount;
    }

    public Node getHead(){
        return head;
    }
    
    public Node getTail(){
        return tail;
    }       
    
    //object to string
    public String toString()
    {
        Node current = head.getNext();
        String output = "";
        while(current != null)
        {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }    
    
}