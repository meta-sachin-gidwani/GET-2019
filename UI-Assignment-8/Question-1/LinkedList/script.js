class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }
}

var linkedList = new LinkedList();

function addNode() {
    var data = document.getElementById("input").value;
    if (data == "") {
        alert("please enter a data");
    } else {
        var node = new Node(data);
        var currentNode;
        if (linkedList.head == null) {
            linkedList.head = node;
        } else {
            currentNode = linkedList.head;
            while (currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        linkedList.size++;
        displayList();
    }
}

function deleteNode() {
    var input = document.getElementById("input").value;
    if (input == "") {
        alert("please enter a data");
    } else {
        var currentNode = linkedList.head;
        var previousNode = null;
        while (currentNode != null) {
            if (currentNode.data == input) {
                if (previousNode == null) {
                    linkedList.head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                linkedList.size--;
                displayList();
                return 1;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
    alert("element not found");
    return -1;
}

function displayList() {
    document.getElementById("screen").innerHTML = "";
    if (linkedList.head == null) {
        document.getElementById("showList").style.display = "none";
        return -1;
    }
    document.getElementById("showList").style.display = "block";
    var currentNode = linkedList.head;
    while (currentNode.next) {
        document.getElementById("screen").innerHTML += currentNode.data + "&nbsp;";
        currentNode = currentNode.next;
    }
    document.getElementById("screen").innerHTML += currentNode.data;
    return 1;
}