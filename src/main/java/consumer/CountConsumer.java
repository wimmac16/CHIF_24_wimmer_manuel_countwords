
package consumer;

import Queue.MyQueue;
import bl.Book;




public class CountConsumer extends Thread{
    
    
    private MyQueue<Book>queue;

    public CountConsumer(MyQueue<Book> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
     
    }
    
    
}
