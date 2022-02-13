package de.neufische.myfamousshop;

public class ClothProduct implements Product {

    private int id;
    private String name;

    ClothProduct(String name, int id){
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
