class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self, data):
        self.head = Node(data)

    # 헤더부터 탐색해 뒤에 새로운 노드 추가하기
    def append(self, data):
        current = self.head
        while current.next is not None:
            current = current.next
        current.next = Node(data)

    # 모든 노드 값 출력
    def print_all(self):
        current = self.head
        result = ''
        while current is not None:
            result = result + str(current.data)
            current = current.next
        return result

    # 노드 인덱스 알아내기
    def get_node(self, index):
        cnt = 0
        node = self.head
        while cnt < index:
            cnt += 1
            node = node.next
        return node

    # 삽입
    def add_node(self, index, value):
        new_node = Node(value)
        if index == 0:
            new_node.next = self.head
            self.head = new_node
            return
        node = self.get_node(index-1)
        next_node = node.next
        node.next = new_node
        new_node.next = next_node

    # 삭제
    def delete_node(self, index):
        if index == 0:
            self.head = self.head.next
            return
        node = self.get_node(index-1)
        node.next = node.next.next

    def count_node(self):
        count = 1
        current = self.head
        while current.next is not None:
            current = current.next
            count += 1
        return count


n = int(input())

for _ in range(n):
    num = input()
    ll = LinkedList(0)
    index = 1
    for x in num:
        if(x == "<"):
            index -= 1
            if(index == 0):
                index = 1
        elif(x == ">"):
            index += 1
            if(index > ll.count_node()):
                index -= 1
        elif(x == "-"):
            index -= 1
            ll.delete_node(index)
        else:
            ll.add_node(index, x)
            index += 1

    print(ll.print_all()[1:])
