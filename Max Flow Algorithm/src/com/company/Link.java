package com.company;

// Link Class
@SuppressWarnings("ALL")
public class Link {
    // Instance Variables
    private Node fromNode;
    private Node targetNode;
    private long capacity;
    private long flow;

    // Constructor
    public Link(Node fromNode, Node targetNode, long capacity) {
        this.fromNode = fromNode;
        this.targetNode = targetNode;
        this.capacity = capacity;
        this.flow = 0;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node fromNode) {
        this.fromNode = fromNode;
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }

    public long getCapacity() {
        return capacity;
    }

    // getter and setter methods for the instance variables
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getFlow() {
        return flow;
    }

    public void setFlow(long flow) {
        this.flow = flow;
    }

    // Get the other associated node for a given node
    public Node getOtherNode(Node n) {
        if (n == fromNode) { // if it is from the same node
            return targetNode; // return the target node
        } else {
            return fromNode; // return the fromnode
        }
    }

    // Get the residual capacity of the given node
    public long getResidualCapacity(Node n) {
        if (n == fromNode) { // if the node given is the from node
            return flow; // return the flow , since it becomes a backward edge
        } else {
            return capacity - flow; // return the flow - capacity, as it becomes a forward edge
        }
    }

    public void addResidualFlow(Node n, long Residualflow) { // add residual flow to the original graph
        if (n == fromNode) { // it becomes a backward edge
            System.out.print("The Residual flow to the Graph is :" + flow + "-" + Residualflow + " = ");
            flow -= Residualflow; // it will be the same node so subtract the flow by the residual flow and update it
            System.out.print(flow);
            System.out.println();

        } else { // it becomes a forward edge
            System.out.print("The Residual flow that goes to the flowNetwork is = ");
            flow += Residualflow; // since it's a different node add the flow by the residual flow and update it
            System.out.print(flow + " -> " + getFlow() + "/" + getCapacity() + " The Updated Capacities for the Augmenting Path = " + (getCapacity() - getFlow()));
            System.out.println();
        }
    }


}
