package com.company;

// Node class
@SuppressWarnings("ALL")
public class Node {
    // Instance Variables
    private int id;
    private String name;
    private boolean visited;

    // Constructor
    public Node(int id, String name) {
        this.id = id;
        this.name = name;

    }

    // getter and setter method for the instance variables
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
