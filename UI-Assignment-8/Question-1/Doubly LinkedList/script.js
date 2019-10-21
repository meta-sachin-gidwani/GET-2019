class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }
}

var linkedlist = new DoublyLinkedList();

function addNode() {
    var data = document.getElementById("input").value;
    if (data == "") {
        alert("Please add some element to be inserted");
    } else {
        var node = new Node(data);
        if (linkedlist.head == null) {
            linkedlist.head = node;
            linkedlist.tail = node;
        } else {
            node.prev = linkedlist.tail;
            linkedlist.tail.next = node;
            linkedlist.tail = node;
        }
        displayNode();
    }
}

function deleteNode() {
    var input = document.getElementById('input').value;
    var currentNode = linkedlist.head;
    while (currentNode) {
        if (currentNode.data === input) {
            if (currentNode == linkedlist.head && currentNode == linkedlist.tail) {
                linkedlist.head = null;
                linkedlist.tail = null;
            } else if (currentNode == linkedlist.head) {
                linkedlist.head = linkedlist.head.next;
                linkedlist.head.prev = null;
            } else if (currentNode == linkedlist.tail) {
                linkedlist.tail = linkedlist.tail.prev;
                linkedlist.tail.next = null;
            } else {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
            }
            displayNode();
            return 1;
        }
        currentNode = currentNode.next;
    }
    alert("Element not found!");
    return -1;
}

function displayNode() {
    document.getElementById("screen").innerHTML = "";
    if (linkedlist.head == null) {
        document.getElementById("showList").style.display = "none";
        return -1;
    }
    document.getElementById("showList").style.display = "block";
    var currentNode = linkedlist.head;
    while (currentNode.next) {
        document.getElementById("screen").innerHTML += currentNode.data + "&nbsp;";
        currentNode = currentNode.next;
    }
    document.getElementById("screen").innerHTML += currentNode.data;
    return 1;
}