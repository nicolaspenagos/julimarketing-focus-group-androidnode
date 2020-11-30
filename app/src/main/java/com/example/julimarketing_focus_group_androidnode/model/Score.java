/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.julimarketing_focus_group_androidnode.model;

public class Score {

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String id;
    private int score;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public Score(){

    }

    public Score(String id, int score){
        this.id = id;
        this.score = score;
    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
