/*
    @Authour - Aarthif Nawaz
    @Student ID - 2017313
    @UOW ID - w1715752
    @Purpose - This project is created in order to calculate the maxflow of a graph, each for given datasets
* */
// Main Package Name
package com.company;

// Imports

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main Class
@SuppressWarnings("ALL")
public class Main {
    // Values declared as static in order to get the ratio of the preceeding datasets
    private static double RATIO = 0;
    private static double RATIO_1 = 0;
    private static double RATIO_2 = 0;

    //Main methid
    public static void main(String[] args) {

        System.out.println("\n" +
                " __       __   ______   __    __        ________  __        ______   __       __ \n" +
                "|  \\     /  \\ /      \\ |  \\  |  \\      |        \\|  \\      /      \\ |  \\  _  |  \\\n" +
                "| $$\\   /  $$|  $$$$$$\\| $$  | $$      | $$$$$$$$| $$     |  $$$$$$\\| $$ / \\ | $$\n" +
                "| $$$\\ /  $$$| $$__| $$ \\$$\\/  $$      | $$__    | $$     | $$  | $$| $$/  $\\| $$\n" +
                "| $$$$\\  $$$$| $$    $$  >$$  $$       | $$  \\   | $$     | $$  | $$| $$  $$$\\ $$\n" +
                "| $$\\$$ $$ $$| $$$$$$$$ /  $$$$\\       | $$$$$   | $$     | $$  | $$| $$ $$\\$$\\$$\n" +
                "| $$ \\$$$| $$| $$  | $$|  $$ \\$$\\      | $$      | $$_____| $$__/ $$| $$$$  \\$$$$\n" +
                "| $$  \\$ | $$| $$  | $$| $$  | $$      | $$      | $$     \\\\$$    $$| $$$    \\$$$\n" +
                " \\$$      \\$$ \\$$   \\$$ \\$$   \\$$       \\$$       \\$$$$$$$$ \\$$$$$$  \\$$      \\$$\n" +
                "                                                                                 \n" +
                "                                                                                 \n" +
                "                                                                                 \n");
        //Get Inputs
        Scanner input = new Scanner(System.in);
        boolean game = false;
        while (!game) {
            // Console menu
            System.out.println("======================Max Flow Algorithm===============================");
            System.out.println("1. Run 1st Dataset");
            System.out.println("2. Run 2nd Dataset");
            System.out.println("3. Run 3rd Dataset");
            System.out.println("4. Run 4th Dataset");
            System.out.println("5. Modify the Algorithm ");
            System.out.println("6. Give Your Own Inputs");
            System.out.println("7. Exit");
            System.out.println("========================================================================");
            System.out.println();
            // Get User Input
            int choice = input.nextInt();
            // Switch case according to user input
            switch (choice) {
                case 1:
                    // Run the first dataset
                    first_dataSet();
                    break;
                case 2:
                    // Run the Second dataset
                    second_dataset();
                    break;
                case 3:
                    // Run the third dataset
                    third_dataset();
                    break;
                case 4:
                    // Run the fourth dataset
                    fourth_dataset();
                    break;
                case 5:
                    // Do any extra modifications needed
                    Modifications();
                    break;
                case 6:
                    // Give Your Own Inputs
                    Give_Your_Inputs();
                    break;
                case 7:
                    // End the Max Flow
                    System.out.println("Thanks for using Max Flow Algorithm ! ");
                    game = true;
                    break;
                default:
                    System.out.println("Wrong Input Entered ! ");

            }

        }


    }

    private static void first_dataSet() {
        System.out.println("The First Data Set - Taken From CourseWork");

        // Run the Stopwatch to execute the time taken
        Stopwatch timer = new Stopwatch();

        // Creating an Object of the flownetwork with number of nodes as 6
        FlowNetwork flowNetwork = new FlowNetwork(6);

        // Creating the node object
        Node node1 = new Node(0, "0");
        Node node2 = new Node(1, "1");
        Node node3 = new Node(2, "2");
        Node node4 = new Node(3, "3");
        Node node5 = new Node(4, "4");
        Node node6 = new Node(5, "5");

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);

        // Creating the links for the nodes
        flowNetwork.addLink(new Link(node1, node2, 10));
        flowNetwork.addLink(new Link(node1, node3, 8));
        flowNetwork.addLink(new Link(node2, node4, 5));
        flowNetwork.addLink(new Link(node2, node3, 5));
        flowNetwork.addLink(new Link(node3, node2, 4));
        flowNetwork.addLink(new Link(node4, node3, 7));
        flowNetwork.addLink(new Link(node3, node5, 10));
        flowNetwork.addLink(new Link(node4, node5, 6));
        flowNetwork.addLink(new Link(node5, node4, 10));
        flowNetwork.addLink(new Link(node4, node6, 3));
        flowNetwork.addLink(new Link(node5, node6, 14));

        // Creating the maxflow object passing the source node and sink node
        MaxFlow maxFlow = new MaxFlow(flowNetwork, node1, node6);
        System.out.println();

        // Get the maxflow of the flownetwork
        System.out.println("The Maximum flow for the 1st Residual Graph :" + maxFlow.getMaxFlow());
        RATIO = timer.elapsedTime();// Get the time takeen to execute the algorithm
        // Print the time in seconds
        System.out.println(timer.elapsedTime() + " Seconds");
        System.out.println();

        // Print the ratio of the algorithm
        System.out.println("The ratio of this dataset is :" + 0);
        // Print the log ratio of the algorithm
        System.out.println("The Log ratio of this dataset is :" + 0);
        // Print the number of nodes
        System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
        // Print the number of links for the algorithm
        System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());

        // print min-cut
        System.out.println();
        System.out.println("Nodes in the min cut set: ");
        for (int v = 0; v < nodes.size(); v++) {
            if (maxFlow.isInCut(v))
                System.out.print(nodes.get(v).getName() + " -> ");
            ;
        }
        System.out.println();
    }

    private static void second_dataset() {
        System.out.println("The Second Data Involves Bipartite Matching of Students to Companies");
        System.out.println();

        // Run the Stopwatch to execute the time taken
        Stopwatch timer = new Stopwatch();
        int N = 5;

        // Creating an Object of the flownetwork with number of nodes as 6
        FlowNetwork flowNetwork = new FlowNetwork(12);

        // Creating a list of Nodes that stores all the node objects
        List<Node> nodes = new ArrayList<>();
        // Add the nodes to the list
        nodes.add(new Node(0, "s"));

        nodes.add(new Node(1, "Apple"));
        nodes.add(new Node(2, "Google"));
        nodes.add(new Node(3, "Yahoo"));
        nodes.add(new Node(4, "Cisco"));
        nodes.add(new Node(5, "Alphabet "));

        nodes.add(new Node(6, "Aarthif"));
        nodes.add(new Node(7, "Hamdan"));
        nodes.add(new Node(8, "Firaz"));
        nodes.add(new Node(9, "Aasif"));
        nodes.add(new Node(10, "Rohit"));

        nodes.add(new Node(11, "t"));

        // Using the for loop create the links for the source nodesink nodes of same capacity
        for (int i = 0; i < N; i++) {
            flowNetwork.addLink(new Link(nodes.get(0), nodes.get(i + 1), 18));
            flowNetwork.addLink(new Link(nodes.get(i + 1 + N), nodes.get(11), 27));
        }
        // Create links for other flow network links
        flowNetwork.addLink(new Link(nodes.get(1), nodes.get(6), 17));
        flowNetwork.addLink(new Link(nodes.get(2), nodes.get(6), 17));

        flowNetwork.addLink(new Link(nodes.get(1), nodes.get(7), 14));
        flowNetwork.addLink(new Link(nodes.get(3), nodes.get(7), 14));

        flowNetwork.addLink(new Link(nodes.get(3), nodes.get(8), 13));
        flowNetwork.addLink(new Link(nodes.get(5), nodes.get(8), 13));

        flowNetwork.addLink(new Link(nodes.get(1), nodes.get(9), 15));
        flowNetwork.addLink(new Link(nodes.get(4), nodes.get(9), 15));

        flowNetwork.addLink(new Link(nodes.get(3), nodes.get(2), 14));
        flowNetwork.addLink(new Link(nodes.get(4), nodes.get(5), 14));

        flowNetwork.addLink(new Link(nodes.get(9), nodes.get(6), 13));
        flowNetwork.addLink(new Link(nodes.get(7), nodes.get(10), 13));

        MaxFlow maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(11));

        // Get the maxflow of the residual graph
        System.out.println("The Maximum flow for the 2nd Residual Graph :" + maxFlow.getMaxFlow());
        // Get the executed time to calculate the maxflow
        RATIO_1 = timer.elapsedTime();
        System.out.println(timer.elapsedTime() + " Seconds");
        System.out.println();
        // Get the ratio of the elapsed time
        System.out.println("The ratio of this dataset is :" + timer.elapsedTime() / RATIO);
        System.out.println();
        // Get the log ratio of the datasets
        System.out.println("The logratio of this dataset is :" + Math.log((timer.elapsedTime() / RATIO)) / Math.log(2));
        // Get the number of nodes
        System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
        // Get the number of links
        System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());

        // print min-cut
        System.out.println();
        System.out.println("Nodes in the min cut set: ");
        for (int v = 0; v < nodes.size(); v++) {
            if (maxFlow.isInCut(v))
                System.out.print(nodes.get(v).getName() + " -> ");
            ;
        }
        System.out.println();

    }

    private static void third_dataset() {

        System.out.println("The Third Data Set Involves Basketball team elimination ");
        System.out.println();

        // Starting the stopwatch
        Stopwatch timer = new Stopwatch();
        int N = 11;

        // Initializing the flownetwork with the number of nodes
        FlowNetwork flowNetwork = new FlowNetwork(24);

        // Create a node list
        List<Node> nodes = new ArrayList<>();
        // add all nodes
        nodes.add(new Node(0, "s"));

        nodes.add(new Node(1, "NYYBAL"));
        nodes.add(new Node(2, "TESBOS"));
        nodes.add(new Node(3, "FTYTOR"));
        nodes.add(new Node(4, "HYTCSO"));
        nodes.add(new Node(5, "BALBOS "));
        nodes.add(new Node(6, "ILOTOR"));
        nodes.add(new Node(7, "OSECSO"));
        nodes.add(new Node(8, "TORBAL"));
        nodes.add(new Node(9, "XYZBAL"));
        nodes.add(new Node(10, "URLBOS"));
        nodes.add(new Node(11, "TERTOR"));

        nodes.add(new Node(12, "TOR"));
        nodes.add(new Node(13, "CSO"));
        nodes.add(new Node(14, "TES"));
        nodes.add(new Node(15, "FTY"));
        nodes.add(new Node(16, "OSE"));
        nodes.add(new Node(17, "ILO"));
        nodes.add(new Node(18, "HYT"));
        nodes.add(new Node(19, "XYZ"));
        nodes.add(new Node(20, "URL"));
        nodes.add(new Node(21, "TER"));
        nodes.add(new Node(22, "TER"));

        nodes.add(new Node(23, "t"));

        // add all the links to the flownetwork
        for (int i = 0; i < N; i++) {
            flowNetwork.addLink(new Link(nodes.get(0), nodes.get(i + 1), 16));
            flowNetwork.addLink(new Link(nodes.get(i + 1), nodes.get(i + 1 + N), 13));
            flowNetwork.addLink(new Link(nodes.get(i + 1 + N), nodes.get(23), 20));
        }

        flowNetwork.addLink(new Link(nodes.get(1), nodes.get(13), 12));
        flowNetwork.addLink(new Link(nodes.get(2), nodes.get(12), 12));

        flowNetwork.addLink(new Link(nodes.get(3), nodes.get(15), 13));
        flowNetwork.addLink(new Link(nodes.get(4), nodes.get(14), 13));

        flowNetwork.addLink(new Link(nodes.get(5), nodes.get(17), 14));
        flowNetwork.addLink(new Link(nodes.get(6), nodes.get(16), 14));

        flowNetwork.addLink(new Link(nodes.get(7), nodes.get(19), 13));
        flowNetwork.addLink(new Link(nodes.get(8), nodes.get(18), 13));

        flowNetwork.addLink(new Link(nodes.get(9), nodes.get(21), 12));
        flowNetwork.addLink(new Link(nodes.get(10), nodes.get(20), 12));

        flowNetwork.addLink(new Link(nodes.get(11), nodes.get(12), 11));


        // Initialize the maxflow object with the flownetwork, source and sink
        MaxFlow maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(23));

        // Get the maxflow
        System.out.println("The Maximum flow for the 3rd Residual Graph :" + maxFlow.getMaxFlow());
        // Get the time taken to execute the algorithm
        RATIO_2 = timer.elapsedTime();
        // Get the time in seconds
        System.out.println(timer.elapsedTime() + " Seconds");

        System.out.println();
        // Get the ratio of this algorithm
        System.out.println("The ratio of this dataset is :" + timer.elapsedTime() / RATIO_1);
        System.out.println();
        // Get the log ratio of this algorithm
        System.out.println("The logratio of this dataset is :" + Math.log((timer.elapsedTime() / RATIO_1)) / Math.log(2));
        // Get the number of nodes and edges
        System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
        System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());

        // print min-cut
        System.out.println();
        System.out.println("Nodes in the min cut set: ");
        for (int v = 0; v < nodes.size(); v++) {
            if (maxFlow.isInCut(v))
                System.out.print(nodes.get(v).getName() + " -> ");
            ;
        }
        System.out.println();
    }

    private static void fourth_dataset() {
        System.out.println("The Fourth Data Set Involves on Module Selection ");
        System.out.println();

        Stopwatch timer = new Stopwatch();


        int N = 23;

        FlowNetwork flowNetwork = new FlowNetwork(48);

        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node(0, "s"));

        nodes.add(new Node(1, "A"));
        nodes.add(new Node(2, "B"));
        nodes.add(new Node(3, "C"));
        nodes.add(new Node(4, "D"));
        nodes.add(new Node(5, "E"));
        nodes.add(new Node(6, "F"));
        nodes.add(new Node(7, "G"));
        nodes.add(new Node(8, "H"));
        nodes.add(new Node(9, "I"));
        nodes.add(new Node(10, "J"));
        nodes.add(new Node(11, "K"));
        nodes.add(new Node(12, "L"));
        nodes.add(new Node(13, "M"));
        nodes.add(new Node(14, "N"));
        nodes.add(new Node(15, "O"));
        nodes.add(new Node(16, "P"));
        nodes.add(new Node(17, "Q"));
        nodes.add(new Node(18, "R"));
        nodes.add(new Node(19, "S"));
        nodes.add(new Node(20, "T"));
        nodes.add(new Node(21, "U"));
        nodes.add(new Node(22, "V"));
        nodes.add(new Node(23, "W"));

        nodes.add(new Node(24, "1"));
        nodes.add(new Node(25, "2"));
        nodes.add(new Node(26, "3"));
        nodes.add(new Node(27, "4"));
        nodes.add(new Node(28, "5"));
        nodes.add(new Node(29, "6"));
        nodes.add(new Node(30, "7"));
        nodes.add(new Node(31, "8"));
        nodes.add(new Node(32, "9"));
        nodes.add(new Node(33, "10"));
        nodes.add(new Node(34, "11"));
        nodes.add(new Node(35, "12"));
        nodes.add(new Node(36, "13"));
        nodes.add(new Node(37, "14"));
        nodes.add(new Node(38, "15"));
        nodes.add(new Node(39, "16"));
        nodes.add(new Node(40, "17"));
        nodes.add(new Node(41, "18"));
        nodes.add(new Node(42, "19"));
        nodes.add(new Node(43, "20"));
        nodes.add(new Node(44, "21"));
        nodes.add(new Node(45, "22"));
        nodes.add(new Node(46, "23"));

        nodes.add(new Node(47, "t"));


        for (int i = 0; i < N; i++) {
            flowNetwork.addLink(new Link(nodes.get(0), nodes.get(i + 1), 22));
            flowNetwork.addLink(new Link(nodes.get(i + 1), nodes.get(i + 1 + N), 13));
            flowNetwork.addLink(new Link(nodes.get(i + 1 + N), nodes.get(47), 25));
        }

        flowNetwork.addLink(new Link(nodes.get(1), nodes.get(25), 11));
        flowNetwork.addLink(new Link(nodes.get(2), nodes.get(24), 12));

        flowNetwork.addLink(new Link(nodes.get(3), nodes.get(27), 12));
        flowNetwork.addLink(new Link(nodes.get(4), nodes.get(26), 12));

        flowNetwork.addLink(new Link(nodes.get(5), nodes.get(29), 12));
        flowNetwork.addLink(new Link(nodes.get(6), nodes.get(28), 12));

        flowNetwork.addLink(new Link(nodes.get(7), nodes.get(31), 12));
        flowNetwork.addLink(new Link(nodes.get(8), nodes.get(30), 12));

        flowNetwork.addLink(new Link(nodes.get(9), nodes.get(33), 14));
        flowNetwork.addLink(new Link(nodes.get(10), nodes.get(32), 14));

        flowNetwork.addLink(new Link(nodes.get(11), nodes.get(35), 12));
        flowNetwork.addLink(new Link(nodes.get(12), nodes.get(34), 12));

        flowNetwork.addLink(new Link(nodes.get(13), nodes.get(37), 13));
        flowNetwork.addLink(new Link(nodes.get(14), nodes.get(36), 13));

        flowNetwork.addLink(new Link(nodes.get(15), nodes.get(39), 14));
        flowNetwork.addLink(new Link(nodes.get(16), nodes.get(38), 15));

        flowNetwork.addLink(new Link(nodes.get(17), nodes.get(41), 13));
        flowNetwork.addLink(new Link(nodes.get(18), nodes.get(40), 13));
        flowNetwork.addLink(new Link(nodes.get(19), nodes.get(45), 13));


        MaxFlow maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(47));

        System.out.println("The Maximum flow for the 4th Residual Graph :" + maxFlow.getMaxFlow());

        System.out.println(timer.elapsedTime() + " Seconds");

        System.out.println();
        System.out.println("The ratio of this dataset is :" + timer.elapsedTime() / RATIO_2);
        System.out.println();
        System.out.println("The logratio of this dataset is :" + Math.log((timer.elapsedTime() / RATIO_2)) / Math.log(2));
        RATIO = timer.elapsedTime();
        System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
        System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());

        // print min-cut
        System.out.println();
        System.out.println("Nodes in the min cut set: ");
        for (int v = 0; v < nodes.size(); v++) {
            if (maxFlow.isInCut(v))
                System.out.print(nodes.get(v).getName() + " -> ");
            ;
        }
        System.out.println();
    }

    private static void Give_Your_Inputs() {
        // Creating the scanner objects
        Scanner sc = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        ArrayList<Node> nodes = new ArrayList<>();
        // Get how many nodes you want
        System.out.println("Enter how many nodes you want : ");
        int input = sc.nextInt(); // Using this input we get how many nodes we want
        String value = "";
        // Run it through the for loop until u get the number of inputs
        for (int i = 0; i < input; i++) {
            if (i == 0) { // Enter the source node
                System.out.println("Enter Node Source : ");
                value = string.nextLine();
                Node node = new Node(0, value);
                nodes.add(node);
            } else if (i == (input - 1)) { // Enter the sink node
                System.out.println("Enter Node Sink : ");
                value = string.nextLine();
                Node node = new Node((input - 1), value);
                nodes.add(node);

            } else { // Enter the nodes
                System.out.println("Enter Node " + (i) + " : ");
                value = string.nextLine();
                Node node = new Node(i, value);
                nodes.add(node);
            }

        }
        // Initialize the flownetwork with the number of nodes in the list
        FlowNetwork flowNetwork = new FlowNetwork(nodes.size());
        String s = "";
        int node1 = 0;
        int node2 = 0;
        int capacity = 0;
        for (Node n : nodes) {
            s += n.getId() + " ";
        }
        // Get the input of how many edges needed
        System.out.println("Enter how many Edges you want : ");
        int edge = sc.nextInt();
        // Run it through the for loop for the number of edges needed
        for (int j = 1; j <= edge; j++) {
            // enter node 1
            System.out.println("Enter node number for edge " + j + " write either (" + s + ") :");
            node1 = sc.nextInt();
            // enter node 2
            System.out.println("Enter node number for edge " + j + " write either (" + s + ") :");
            node2 = sc.nextInt();
            // Enter the capacity value
            System.out.println("Enter Capacity : ");
            capacity = sc.nextInt();
            // add it to the flownetwork
            flowNetwork.addLink(new Link(nodes.get(node1), nodes.get(node2), capacity));

        }
        Stopwatch timer = new Stopwatch();
        MaxFlow maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(nodes.size() - 1));
        // Get the maxflow
        System.out.println("The Maximum Flow is " + maxFlow.getMaxFlow());

        // Get the time taken to execute the algorithm
        System.out.println(timer.elapsedTime() + " Seconds");
        // Get the number of nodes
        System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
        // Get the number of edges
        System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());

    }

    private static void Modifications() {
        // Initializing the variables
        List<Node> nodes;
        int choice;
        int N;
        MaxFlow maxFlow;
        FlowNetwork flowNetwork;
        long timeElapsed;
        Instant start;
        Instant finish;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter which dataset you want to modify(1,2,3,4) : ");
        int choices = scanner.nextInt(); // Choosing the dataset to be modified
        switch (choices) {
            case 1: // if it is the first dataset
                first_dataSet(); // Run the first dataset to get the original maxflow
                System.out.println();

                flowNetwork = new FlowNetwork(6); // Initialize the flownetwork with the number of ndoes

                Node node1 = new Node(0, "0");
                Node node2 = new Node(1, "1");
                Node node3 = new Node(2, "2");
                Node node4 = new Node(3, "3");
                Node node5 = new Node(4, "4");
                Node node6 = new Node(5, "5");

                nodes = new ArrayList<>();
                nodes.add(node1);
                nodes.add(node2);
                nodes.add(node3);
                nodes.add(node4);
                nodes.add(node5);
                nodes.add(node6);

                flowNetwork.addLink(new Link(node1, node2, 10));
                flowNetwork.addLink(new Link(node1, node3, 8));
                flowNetwork.addLink(new Link(node2, node4, 5));
                flowNetwork.addLink(new Link(node2, node3, 5));
                flowNetwork.addLink(new Link(node3, node2, 4));
                flowNetwork.addLink(new Link(node4, node3, 7));
                flowNetwork.addLink(new Link(node3, node5, 10));
                flowNetwork.addLink(new Link(node4, node5, 6));
                flowNetwork.addLink(new Link(node5, node4, 10));
                flowNetwork.addLink(new Link(node4, node6, 3));
                flowNetwork.addLink(new Link(node5, node6, 14));

                System.out.println("1. Delete");
                System.out.println("2. Change Capacity");
                choice = scanner.nextInt(); // Choose what needs to be modified
                if (choice == 1) { // If choice is to delete
                    System.out.println("Enter the Node ID 1 you want to delete");
                    int nodeId1 = scanner.nextInt(); // Enter the node id 1
                    System.out.println("Enter the Node ID 2 you want to delete");
                    int nodeId2 = scanner.nextInt(); // Enter node id 2
                    // Remove the link by accessing the remove method
                    flowNetwork.removeLink(new Link(nodes.get(nodeId1), nodes.get(nodeId2), 0));

                } else if (choice == 2) { // If it is to change the capacity
                    System.out.println("Enter the node ID 1 for the link you wish to change the capacity for");
                    int nodeId = scanner.nextInt(); // Get the node id 1
                    System.out.println("Enter the node ID 2 for the link you wish to change the capacity for");
                    int nodeId2 = scanner.nextInt(); // Get the node id 2
                    System.out.println("Enter the old Capacity ");
                    long capacity = scanner.nextLong(); // Get the old capacity value
                    System.out.println("Enter the new Capacity ");
                    long newCapacity = scanner.nextLong(); // Get the new capacity value
                    // Remove the link of those node id's and capacity
                    flowNetwork.removeLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), capacity));
                    // and add the link with the new capacity and
                    flowNetwork.addLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), newCapacity));

                }
                // Get the maxflow by initializing the object with the flownetwork , source and sink
                maxFlow = new MaxFlow(flowNetwork, node1, node6);
                System.out.println();
                Stopwatch timer = new Stopwatch();
                // Get the maxflow
                System.out.println("The Maximum flow for the 1st Residual Graph :" + maxFlow.getMaxFlow());
                // Get the time in seconds
                System.out.println(timer.elapsedTime() + " Seconds");
                // Get the number of nodes
                System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
                // Get the number of edges
                System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());
                break;
            case 2:
                // Appy the above to all the dataset as above
                second_dataset();
                System.out.println();

                start = Instant.now();
                N = 5;


                flowNetwork = new FlowNetwork(12);

                nodes = new ArrayList<>();

                nodes.add(new Node(0, "s"));

                nodes.add(new Node(1, "Apple"));
                nodes.add(new Node(2, "Google"));
                nodes.add(new Node(3, "Yahoo"));
                nodes.add(new Node(4, "Cisco"));
                nodes.add(new Node(5, "Alphabet "));

                nodes.add(new Node(6, "Aarthif"));
                nodes.add(new Node(7, "Hamdan"));
                nodes.add(new Node(8, "Firaz"));
                nodes.add(new Node(9, "Aasif"));
                nodes.add(new Node(10, "Rohit"));

                nodes.add(new Node(11, "t"));

                for (int i = 0; i < N; i++) {
                    flowNetwork.addLink(new Link(nodes.get(0), nodes.get(i + 1), 8));
                    flowNetwork.addLink(new Link(nodes.get(i + 1 + N), nodes.get(11), 17));
                }

                flowNetwork.addLink(new Link(nodes.get(1), nodes.get(6), 7));
                flowNetwork.addLink(new Link(nodes.get(2), nodes.get(6), 7));

                flowNetwork.addLink(new Link(nodes.get(1), nodes.get(7), 4));
                flowNetwork.addLink(new Link(nodes.get(3), nodes.get(7), 4));

                flowNetwork.addLink(new Link(nodes.get(3), nodes.get(8), 3));
                flowNetwork.addLink(new Link(nodes.get(5), nodes.get(8), 3));

                flowNetwork.addLink(new Link(nodes.get(1), nodes.get(9), 5));
                flowNetwork.addLink(new Link(nodes.get(4), nodes.get(9), 5));

                flowNetwork.addLink(new Link(nodes.get(3), nodes.get(2), 4));
                flowNetwork.addLink(new Link(nodes.get(4), nodes.get(5), 4));

                flowNetwork.addLink(new Link(nodes.get(9), nodes.get(6), 3));
                flowNetwork.addLink(new Link(nodes.get(7), nodes.get(10), 3));

                System.out.println("1. Delete");
                System.out.println("2. Change Capacity");
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Enter the Node ID 1 you want to delete");
                    int nodeId1 = scanner.nextInt();
                    System.out.println("Enter the Node ID 2 you want to delete");
                    int nodeId2 = scanner.nextInt();
                    flowNetwork.removeLink(new Link(nodes.get(nodeId1), nodes.get(nodeId2), 0));

                } else if (choice == 2) {
                    System.out.println("Enter the node ID 1 for the link you wish to change the capacity for");
                    int nodeId = scanner.nextInt();
                    System.out.println("Enter the node ID 2 for the link you wish to change the capacity for");
                    int nodeId2 = scanner.nextInt();
                    System.out.println("Enter the old Capacity ");
                    long capacity = scanner.nextLong();
                    System.out.println("Enter the new Capacity ");
                    long newCapacity = scanner.nextLong();
                    flowNetwork.removeLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), capacity));
                    flowNetwork.addLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), newCapacity));

                }

                maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(11));
                Stopwatch timer1 = new Stopwatch();
                System.out.println("The Maximum flow for the 2nd Residual Graph :" + maxFlow.getMaxFlow());
                System.out.println(timer1.elapsedTime() + " Seconds");
                System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
                System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());
                break;
            case 3:
                third_dataset();
                System.out.println();

                start = Instant.now();
                N = 11;


                flowNetwork = new FlowNetwork(24);

                nodes = new ArrayList<>();

                nodes.add(new Node(0, "s"));

                nodes.add(new Node(1, "NYYBAL"));
                nodes.add(new Node(2, "TESBOS"));
                nodes.add(new Node(3, "FTYTOR"));
                nodes.add(new Node(4, "HYTCSO"));
                nodes.add(new Node(5, "BALBOS "));
                nodes.add(new Node(6, "ILOTOR"));
                nodes.add(new Node(7, "OSECSO"));
                nodes.add(new Node(8, "TORBAL"));
                nodes.add(new Node(9, "XYZBAL"));
                nodes.add(new Node(10, "URLBOS"));
                nodes.add(new Node(11, "TERTOR"));

                nodes.add(new Node(12, "TOR"));
                nodes.add(new Node(13, "CSO"));
                nodes.add(new Node(14, "TES"));
                nodes.add(new Node(15, "FTY"));
                nodes.add(new Node(16, "OSE"));
                nodes.add(new Node(17, "ILO"));
                nodes.add(new Node(18, "HYT"));
                nodes.add(new Node(19, "XYZ"));
                nodes.add(new Node(20, "URL"));
                nodes.add(new Node(21, "TER"));
                nodes.add(new Node(22, "TER"));

                nodes.add(new Node(23, "t"));

                for (int i = 0; i < N; i++) {
                    flowNetwork.addLink(new Link(nodes.get(0), nodes.get(i + 1), 6));
                    flowNetwork.addLink(new Link(nodes.get(i + 1), nodes.get(i + 1 + N), 3));
                    flowNetwork.addLink(new Link(nodes.get(i + 1 + N), nodes.get(23), 10));
                }

                flowNetwork.addLink(new Link(nodes.get(1), nodes.get(13), 2));
                flowNetwork.addLink(new Link(nodes.get(2), nodes.get(12), 2));

                flowNetwork.addLink(new Link(nodes.get(3), nodes.get(15), 3));
                flowNetwork.addLink(new Link(nodes.get(4), nodes.get(14), 3));

                flowNetwork.addLink(new Link(nodes.get(5), nodes.get(17), 4));
                flowNetwork.addLink(new Link(nodes.get(6), nodes.get(16), 4));

                flowNetwork.addLink(new Link(nodes.get(7), nodes.get(19), 3));
                flowNetwork.addLink(new Link(nodes.get(8), nodes.get(18), 3));

                flowNetwork.addLink(new Link(nodes.get(9), nodes.get(21), 2));
                flowNetwork.addLink(new Link(nodes.get(10), nodes.get(20), 2));

                flowNetwork.addLink(new Link(nodes.get(11), nodes.get(12), 1));

                System.out.println("1. Delete");
                System.out.println("2. Change Capacity");
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Enter the Node ID 1 you want to delete");
                    int nodeId1 = scanner.nextInt();
                    System.out.println("Enter the Node ID 2 you want to delete");
                    int nodeId2 = scanner.nextInt();
                    flowNetwork.removeLink(new Link(nodes.get(nodeId1), nodes.get(nodeId2), 0));

                } else if (choice == 2) {
                    System.out.println("Enter the node ID 1 for the link you wish to change the capacity for");
                    int nodeId = scanner.nextInt();
                    System.out.println("Enter the node ID 2 for the link you wish to change the capacity for");
                    int nodeId2 = scanner.nextInt();
                    System.out.println("Enter the old Capacity ");
                    long capacity = scanner.nextLong();
                    System.out.println("Enter the new Capacity ");
                    long newCapacity = scanner.nextLong();
                    flowNetwork.removeLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), capacity));
                    flowNetwork.addLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), newCapacity));

                }


                maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(23));
                Stopwatch stopwatch = new Stopwatch();
                System.out.println("The Maximum flow for the 3rd Residual Graph :" + maxFlow.getMaxFlow());

                System.out.println(stopwatch.elapsedTime() + " Seconds");
                System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
                System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());
                break;
            case 4:
                fourth_dataset();
                System.out.println();

                start = Instant.now();

                N = 23;

                flowNetwork = new FlowNetwork(48);

                nodes = new ArrayList<>();

                nodes.add(new Node(0, "s"));

                nodes.add(new Node(1, "A"));
                nodes.add(new Node(2, "B"));
                nodes.add(new Node(3, "C"));
                nodes.add(new Node(4, "D"));
                nodes.add(new Node(5, "E"));
                nodes.add(new Node(6, "F"));
                nodes.add(new Node(7, "G"));
                nodes.add(new Node(8, "H"));
                nodes.add(new Node(9, "I"));
                nodes.add(new Node(10, "J"));
                nodes.add(new Node(11, "K"));
                nodes.add(new Node(12, "L"));
                nodes.add(new Node(13, "M"));
                nodes.add(new Node(14, "N"));
                nodes.add(new Node(15, "O"));
                nodes.add(new Node(16, "P"));
                nodes.add(new Node(17, "Q"));
                nodes.add(new Node(18, "R"));
                nodes.add(new Node(19, "S"));
                nodes.add(new Node(20, "T"));
                nodes.add(new Node(21, "U"));
                nodes.add(new Node(22, "V"));
                nodes.add(new Node(23, "W"));

                nodes.add(new Node(24, "1"));
                nodes.add(new Node(25, "2"));
                nodes.add(new Node(26, "3"));
                nodes.add(new Node(27, "4"));
                nodes.add(new Node(28, "5"));
                nodes.add(new Node(29, "6"));
                nodes.add(new Node(30, "7"));
                nodes.add(new Node(31, "8"));
                nodes.add(new Node(32, "9"));
                nodes.add(new Node(33, "10"));
                nodes.add(new Node(34, "11"));
                nodes.add(new Node(35, "12"));
                nodes.add(new Node(36, "13"));
                nodes.add(new Node(37, "14"));
                nodes.add(new Node(38, "15"));
                nodes.add(new Node(39, "16"));
                nodes.add(new Node(40, "17"));
                nodes.add(new Node(41, "18"));
                nodes.add(new Node(42, "19"));
                nodes.add(new Node(43, "20"));
                nodes.add(new Node(44, "21"));
                nodes.add(new Node(45, "22"));
                nodes.add(new Node(46, "23"));

                nodes.add(new Node(47, "t"));


                for (int i = 0; i < N; i++) {
                    flowNetwork.addLink(new Link(nodes.get(0), nodes.get(i + 1), 12));
                    flowNetwork.addLink(new Link(nodes.get(i + 1), nodes.get(i + 1 + N), 3));
                    flowNetwork.addLink(new Link(nodes.get(i + 1 + N), nodes.get(47), 15));
                }

                flowNetwork.addLink(new Link(nodes.get(1), nodes.get(25), 1));
                flowNetwork.addLink(new Link(nodes.get(2), nodes.get(24), 2));

                flowNetwork.addLink(new Link(nodes.get(3), nodes.get(27), 2));
                flowNetwork.addLink(new Link(nodes.get(4), nodes.get(26), 2));

                flowNetwork.addLink(new Link(nodes.get(5), nodes.get(29), 2));
                flowNetwork.addLink(new Link(nodes.get(6), nodes.get(28), 2));

                flowNetwork.addLink(new Link(nodes.get(7), nodes.get(31), 2));
                flowNetwork.addLink(new Link(nodes.get(8), nodes.get(30), 2));

                flowNetwork.addLink(new Link(nodes.get(9), nodes.get(33), 4));
                flowNetwork.addLink(new Link(nodes.get(10), nodes.get(32), 4));

                flowNetwork.addLink(new Link(nodes.get(11), nodes.get(35), 2));
                flowNetwork.addLink(new Link(nodes.get(12), nodes.get(34), 2));

                flowNetwork.addLink(new Link(nodes.get(13), nodes.get(37), 3));
                flowNetwork.addLink(new Link(nodes.get(14), nodes.get(36), 3));

                flowNetwork.addLink(new Link(nodes.get(15), nodes.get(39), 4));
                flowNetwork.addLink(new Link(nodes.get(16), nodes.get(38), 5));

                flowNetwork.addLink(new Link(nodes.get(17), nodes.get(41), 3));
                flowNetwork.addLink(new Link(nodes.get(18), nodes.get(40), 3));
                flowNetwork.addLink(new Link(nodes.get(19), nodes.get(45), 3));

                System.out.println("1. Delete");
                System.out.println("2. Change Capacity");
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Enter the Node ID 1 you want to delete");
                    int nodeId1 = scanner.nextInt();
                    System.out.println("Enter the Node ID 2 you want to delete");
                    int nodeId2 = scanner.nextInt();
                    flowNetwork.removeLink(new Link(nodes.get(nodeId1), nodes.get(nodeId2), 0));

                } else if (choice == 2) {
                    System.out.println("Enter the node ID 1 for the link you wish to change the capacity for");
                    int nodeId = scanner.nextInt();
                    System.out.println("Enter the node ID 2 for the link you wish to change the capacity for");
                    int nodeId2 = scanner.nextInt();
                    System.out.println("Enter the old Capacity ");
                    long capacity = scanner.nextLong();
                    System.out.println("Enter the new Capacity ");
                    long newCapacity = scanner.nextLong();
                    flowNetwork.removeLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), capacity));
                    flowNetwork.addLink(new Link(nodes.get(nodeId), nodes.get(nodeId2), newCapacity));

                }

                maxFlow = new MaxFlow(flowNetwork, nodes.get(0), nodes.get(47));
                Stopwatch timer2 = new Stopwatch();
                System.out.println("The Maximum flow for the 4th Residual Graph :" + maxFlow.getMaxFlow());
                System.out.println(timer2.elapsedTime() + " Seconds");
                System.out.println("The Number Of Nodes " + flowNetwork.getNumOfNodes());
                System.out.println("The Number Of Edges " + flowNetwork.getNumOfLinks());
                break;
            default:
                System.out.println("There is no dataset as such");
        }


    }
}
