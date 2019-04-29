import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Random
import java.util.TreeMap

class BinarySearchTreeIterationTest {

    private val value = 100
    private val expectedTree = TreeMap<Int, Int>()
    private val actualTree = BinarySearchTree<Int, Int>()
    private val random = Random()

    @Test
    fun iterateBamboo() {
        val keys = arrayOf(0, 1, 2, 3, 4, 5)

        // Building expected structure of tree
        for (key in keys)
            expectedTree[key] = value

        // Making tree using existing methods
        for (key in keys)
            actualTree[key] = value

        assertEquals(expectedTree.toString(), actualTree.toString())
    }

    @Test
    fun iterateFullTree() {
        val keys = arrayOf(
                               8,
                         4,          12,
                      2,    6,   10,     14,
                    1, 3, 5, 7, 9, 11, 13, 15
        )

        // Building expected structure of tree
        for (key in keys)
            expectedTree[key] = value

        // Making tree using existing methods
        for (key in keys)
            actualTree[key] = value

        assertEquals(expectedTree.toString(), actualTree.toString())
    }

    @Test
    fun iterateBentBamboo() {
        val keys = arrayOf(10, 3, 4, 9, 7, 6, 5)

        // Building expected structure of tree
        for (key in keys)
            expectedTree[key] = value

        // Making tree using existing methods
        for (key in keys)
            actualTree[key] = value

        assertEquals(expectedTree.toString(), actualTree.toString())
    }

    @Test
    fun iterateEmpty() {
        assertEquals(expectedTree.toString(), actualTree.toString())
    }

    @Test
    fun iterateOnlyRoot() {
        // Building expected structure of tree
        expectedTree[0] = value

        // Making tree using existing methods
        actualTree[0] = value

        assertEquals(expectedTree.toString(), actualTree.toString())
    }

    @Test
    fun iterateRandomStress() {
        val keys: MutableList<Int> = mutableListOf()
        for (index in 1..SIZE)
            keys.add(random.nextInt())

        // Building expected structure of tree
        for (key in keys)
            expectedTree[key] = value

        // Making tree using existing methods
        for (key in keys)
            actualTree[key] = value

        assertEquals(expectedTree.toString(), actualTree.toString())
    }

}
