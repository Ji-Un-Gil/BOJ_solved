import sys
sys.setrecursionlimit(10**6)


class Node(object):
    def __init__(self, item, info):
        self.item = item
        self.info = info
        self.left = self.right = None


class BinaryTree(object):
    def __init__(self):
        self.root = None

    def insert_node(self, node):
        def check_parent(parent, child):
            if child.info[0] < parent.info[0]:
                if parent.left is None:
                    parent.left = child
                    return
                else:
                    check_parent(parent.left, child)
            else:
                if parent.right is None:
                    parent.right = child
                    return
                else:
                    check_parent(parent.right, child)

        check_parent(self.root, node)

    def preorder(self):
        result = []

        def _preorder(node):
            result.append(node.item)
            if node.left:
                _preorder(node.left)
            if node.right:
                _preorder(node.right)

        _preorder(self.root)
        return result

    def postorder(self):
        result = []

        def _postorder(node):
            if node.left:
                _postorder(node.left)
            if node.right:
                _postorder(node.right)
            result.append(node.item)

        _postorder(self.root)
        return result


def solution(node_info):
    if len(node_info) == 1:
        return [[1], [1]]

    binary_tree = BinaryTree()
    nodes = []

    for idx in range(len(node_info)):
        node = Node(idx+1, node_info[idx])
        nodes.append(node)
    nodes.sort(key=lambda x: (-x.info[1], x.info[0]))

    binary_tree.root = nodes[0]
    for i in range(1, len(nodes)):
        binary_tree.insert_node(nodes[i])

    return [binary_tree.preorder(), binary_tree.postorder()]