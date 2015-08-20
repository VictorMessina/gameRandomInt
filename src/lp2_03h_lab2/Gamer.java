package lp2_03h_lab2;

import java.io.Serializable;

/**
 *
 * @author cacique
 */
public class Gamer implements Serializable{
    
    private String name;
    private int max_score, last_score, current_score;

    public Gamer(String name, int max_score, int last_score, int current_score) {
        this.name = name;
        this.max_score = max_score;
        this.last_score = last_score;
        this.current_score = current_score;
    }

    public Gamer() {
    }
    
    public void incrementScore()
    {
        this.current_score++;
    }

    public int getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(int current_score) {
        this.current_score = current_score;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_score() {
        return max_score;
    }

    public void setMax_score(int max_score) {
        this.max_score = max_score;
    }

    public int getLast_score() {
        return last_score;
    }

    public void setLast_score(int last_score) {
        this.last_score = last_score;
    }

    @Override
    public String toString() {
        return "Gamer{" + "name=" + name + ", max_score=" + max_score + ", last_score=" + last_score + ", current_score=" + current_score + '}';
    } 
    
}
