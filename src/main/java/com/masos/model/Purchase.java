package com.masos.model;

public class Purchase {
    private int number;
    private int personId;
    private int goodId;

    public Purchase(int number, int personId, int goodId){
        this.number = number;
        this.goodId = goodId;
        this.personId = personId;
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public int getPersonId() { return personId; }
    public void setPersonId(int personId) { this.personId = personId; }
    public int getGoodId() { return goodId; }
    public void setGoodId(int goodId) { this.goodId = goodId; }

    @Override
    public String toString(){
        return number + "; " + personId + "; " + goodId + "\n";
    }
}
