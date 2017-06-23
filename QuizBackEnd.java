/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizbackend;

import java.util.Scanner;

/**
 *
 * @author KienBeo
 */
public class QuizBackEnd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("------ Single list ---------");
        SinglyLinked list = new SinglyLinked();
        int menu;
        do{
            System.out.println("-----");
            System.out.println("1. Input number for single list (append )");
            System.out.println("2. Remove tail ");
            System.out.println("3. Remove all number greater than input ");
            System.out.println("4. Exit ");
            System.out.println("Please choice one:  ");
            menu=in.nextInt();
            switch(menu)
            {
                case 1:
                    inputNumber(list,in);
                    break; 
                case 2:
                    removeTail(list);
                    break;
                case 3:
                    removeGreaterNumber(list, in);
                    break;
                case 4:{
                   System.out.println("Exit!");
                   System.exit(0);
               }
            }
        }
        while(menu != 0);
        in.close();
        return;
    
    }
    
    private static void inputNumber(SinglyLinked list, Scanner in){
        list.removeAll();
        System.out.println("Give me a size ");
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++){
            System.out.println("Give me a number ");
            int num = in.nextInt();
            list.add(num);
        }
        System.out.println("*******************");
        System.out.println("List number:  "+ list.toString());
        System.out.println("*******************");
    }
    
    private static void removeTail(SinglyLinked lst){
        int size = lst.size();
        lst.remove(size);
        
        System.out.println("*******************");
        System.out.println("List number:  "+ lst.toString());
        System.out.println("*******************");
    }
    
    private static void removeGreaterNumber(SinglyLinked list, Scanner in){
        System.out.println("Give me a number ");
        int num = in.nextInt();
        
        Node head = list.get(1);
        int loop = 1;
        while(head.getNext() != null){
            //System.out.println("So: "+head.getData() + " loop: "+ loop);
            if(Integer.parseInt(head.getData().toString()) > num){
                list.remove(loop);
            }else{
                loop++;
            }
            head = head.getNext();
        }
        Node tail = list.getTail();
        if(Integer.parseInt(tail.getData().toString()) > num){
            list.remove(list.size());
        }
        System.out.println("*******************");
        System.out.println("List number:  " + list.toString());
        System.out.println("*******************");
    }
}
