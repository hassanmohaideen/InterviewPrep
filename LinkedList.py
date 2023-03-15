class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

    def __init__(self, data, next, prev):
        self.data = data
        self.next = next
        self.prev = prev


class LinkedList:
    def __init__(self):
        self.head = None

    def __repr__(self):
        node = self.head
        nodes = []
        while node is not None:
            nodes.append(str(node.data))
            node = node.next
        nodes.append("None")
        return " -> ".join(nodes)


def linked_list_testing():
    linked_list = LinkedList()
    linked_list.head = Node(1, None, None)
    linked_list.head.next = Node(2, Node(3, None, None), None)
    print(linked_list)


if __name__ == "__main__":
    linked_list_testing()
