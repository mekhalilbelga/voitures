package com.hellokoding.ihm;

// cette classe est la représentation de toute ligne de tableau affichant des personnes
// on utilise donc cet objet graphique pour afficher une liste de Associes

public class PersonLine {
 
    private String firstNameCell;
    private String lastNameCell;
 
    public PersonLine() {
 
    }
 
    public PersonLine(String firstName, String lastName) {
        this.firstNameCell = firstName;
        this.lastNameCell = lastName;
    }
 
	// attention : avec getfirstNameCell => Exception evaluating SpringEL expression: "PersonLine.firstNameCell"
    public String getFirstNameCell() {
        return firstNameCell;
    }
 
    public void setFirstNameCell(String firstName) {
        this.firstNameCell = firstName;
    }
 
    public String getLastNameCell() {
        return lastNameCell;
    }
 
    public void setLastNameCell(String lastName) {
        this.lastNameCell = lastName;
    }
 
}