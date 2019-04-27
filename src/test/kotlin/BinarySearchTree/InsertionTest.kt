import org.junit.Assert.assertEquals
import org.junit.Test

class BinarySearchTreeInsertionTest {

    private val value = 100
    private val expectedTree = BinarySearchTree<Int, Int>()
    private val actualTree = BinarySearchTree<Int, Int>()

    @Test
    fun insertRootCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        // Making tree using existing methods
        actualTree[0] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertRootLeftCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val leftNode = BinaryNode(-100, value)
        leftNode.parent = expectedTree.root
        expectedTree.root!!.left = leftNode

        // Making tree using existing methods
        for (key in arrayOf(0, -100))
            actualTree[key] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertRootRightCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val rightNode = BinaryNode(100, value)
        rightNode.parent = expectedTree.root
        expectedTree.root!!.right = rightNode

        // Making tree using existing methods
        for (key in arrayOf(0, 100))
            actualTree[key] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertRootLeftLeftCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val leftNode = BinaryNode(-100, value)
        leftNode.parent = expectedTree.root
        expectedTree.root!!.left = leftNode

        val nextLeftNode = BinaryNode(-200, value)
        nextLeftNode.parent = expectedTree.root!!.left
        expectedTree.root!!.left!!.left = nextLeftNode

        // Making tree using existing methods
        for (key in arrayOf(0, -100, -200))
            actualTree[key] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertRootLeftRightCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val leftNode = BinaryNode(-100, value)
        leftNode.parent = expectedTree.root
        expectedTree.root!!.left = leftNode

        val nextRightNode = BinaryNode(-50, value)
        nextRightNode.parent = expectedTree.root!!.left
        expectedTree.root!!.left!!.right = nextRightNode

        // Making tree using existing methods
        for (key in arrayOf(0, -100, -50))
            actualTree[key] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertRootRightLeftCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val rightNode = BinaryNode(100, value)
        rightNode.parent = expectedTree.root
        expectedTree.root!!.right = rightNode

        val nextLeftNode = BinaryNode(50, value)
        nextLeftNode.parent = expectedTree.root!!.right
        expectedTree.root!!.right!!.left = nextLeftNode

        // Making tree using existing methods
        for (key in arrayOf(0, 100, 50))
            actualTree[key] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertRootRightRightCase() {
        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val rightNode = BinaryNode(100, value)
        rightNode.parent = expectedTree.root
        expectedTree.root!!.right = rightNode

        val nextRightNode = BinaryNode(200, value)
        nextRightNode.parent = expectedTree.root!!.right
        expectedTree.root!!.right!!.right = nextRightNode

        // Making tree using existing methods
        for (key in arrayOf(0, 100, 200))
            actualTree[key] = value

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun insertByScenario() {
        // Tree structure:
        //................0.................
        //......-100..............100.......
        //..-200...............50.....200...
        //......-150...............150...300
        //......................125.........

        // Node with number i has sons with numbers (2*i) and (2*i + 1)
        // Root has number 1
        // Also method will insert the same keys one more time

        // Building expected structure of tree
        expectedTree.root = BinaryNode(0, value)

        val node2 = BinaryNode(-100, value)
        node2.parent = expectedTree.root
        expectedTree.root!!.left = node2

        val node3 = BinaryNode(100, value)
        node3.parent = expectedTree.root
        expectedTree.root!!.right = node3

        val node4 = BinaryNode(-200, value)
        node4.parent = expectedTree.root!!.left
        expectedTree.root!!.left!!.left = node4

        val node6 = BinaryNode(50, value)
        node6.parent = expectedTree.root!!.right
        expectedTree.root!!.right!!.left = node6

        val node7 = BinaryNode(200, value)
        node7.parent = expectedTree.root!!.right
        expectedTree.root!!.right!!.right = node7

        val node9 = BinaryNode(-150, value)
        node9.parent = expectedTree.root!!.left!!.left
        expectedTree.root!!.left!!.left!!.right = node9

        val node14 = BinaryNode(150, value)
        node14.parent = expectedTree.root!!.right!!.right
        expectedTree.root!!.right!!.right!!.left = node14

        val node15 = BinaryNode(300, value)
        node15.parent = expectedTree.root!!.right!!.right
        expectedTree.root!!.right!!.right!!.right = node15

        val node28 = BinaryNode(125, value)
        node28.parent = expectedTree.root!!.right!!.right!!.left
        expectedTree.root!!.right!!.right!!.left!!.left = node28


        // Making tree using existing methods
        // Trying to insert one key twice
        for (key in arrayOf(0, 100, -100, 50, -200, 200, 150, 125, -150, 300)) {
            actualTree[key] = value
            actualTree[key] = value
        }

        assertEquals(expectedTree, actualTree)
    }

}