package com.company;

//Imports

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
// Flow Netwotk class
public class FlowNetwork {
    // Initialze instance variables
    private int numOfNodes;
    private int numOfLinks;
    private List<List<Link>> adjacencyList;

    // Constructor
    public FlowNetwork(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        this.numOfLinks = 0;
        this.adjacencyList = new ArrayList<>();
        // for loop to fill the adajceny list with the number of nodes
        for (int i = 0; i < numOfNodes; i++) {
            List<Link> linkArrayList = new ArrayList<>();
            this.adjacencyList.add(linkArrayList);
        }

    }
    // get number of nodes

    public int getNumOfNodes() {
        return numOfNodes;
    }

    // Get number of links
    public int getNumOfLinks() {
        return numOfLinks;
    }

    // add a link with two nodes
    public void addLink(Link link) {
        Node start = link.getFromNode(); // get the links start node
        Node end = link.getTargetNode(); // get the links end node
        this.adjacencyList.get(start.getId()).add(link); // get the start nodes id and add the link
        this.adjacencyList.get(end.getId()).add(link); // get the end nodes id and add the link

        numOfLinks++; // Increase the num of links
    }

    // remove a link with two nodes
    public void removeLink(Link link) {
        Node start = link.getFromNode(); // get the links start node
        Node end = link.getTargetNode(); // get the links end node
        //long capacity = link.getCapacity();
        for (Link l : getAdjacencyList(start)) { // run for loop for that number of links for that start node
            if (l.getTargetNode() == end) { // if it is equal to the end node
                this.adjacencyList.get(start.getId()).remove(l); // remove the link
                this.adjacencyList.get(end.getId()).remove(l); // remove the linlk
                break;
            }
        }
        numOfLinks--; // decrease the number of links


    }

    // Get the list of links for a particular node
    public List<Link> getAdjacencyList(Node n) {
        // return the list of links for that particular node
        return adjacencyList.get(n.getId());
    }


}
