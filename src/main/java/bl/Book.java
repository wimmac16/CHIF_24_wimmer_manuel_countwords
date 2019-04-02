/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.HashMap;

/**
 *
 * @author mwimm
 */
public class Book {
    
    
    private String title;
    private String text;

    public Book(String title, String text) {
        this.title = title;
        this.text = text;
    }


    
    public HashMap<String,Integer> countWords(){
        String[] words =text.split("[^a-zA-Z]+");
        HashMap<String,Integer>countwords=new HashMap<>();

        for (String word : words) {
            if(!countWords().containsKey(word)){
                countwords.put(word, 1);
            }else{
                countwords.put(word, countwords.get(word)+1);
            }
        }
        return countwords;
    }
}
