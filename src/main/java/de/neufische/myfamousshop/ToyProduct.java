package de.neufische.myfamousshop;

public class ToyProduct implements Product {

    private int id;
    private String name;

    ToyProduct(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "[ "+name + ", id: " + id + " ]";
    }

    public int getId(){
        return id;
    }
}
