/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import Queue.FullException;
import Queue.MyQueue;
import bl.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mwimm
 */
public class CountProducer implements Runnable{

    private MyQueue<Book>queue;

    public CountProducer(MyQueue<Book> queue) {
        this.queue = queue;
    }
    
    
    public String read(File f){
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
           String line;
            while ((line = br.readLine()) != null) {
                text += line;
            }
        } catch (Exception e) {
        }
        return text;
    }
    @Override
    public void run() {
        File[] file=new File("./src/files").listFiles();
        for (int i = 0; i < file.length; i++) {
            synchronized(queue){
                try {
                    queue.put(new Book(file[i].getName(),read(file[i])));
                    queue.notifyAll();
                } catch (FullException ex) {
                    try {
                        queue.wait();
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(CountProducer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    i--;
                }
            }
        }
    }
    
}
