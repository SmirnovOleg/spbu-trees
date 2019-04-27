import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import java.util.Random

class BinarySearchTreeSearchTest {

    private val values: MutableList<Int> = mutableListOf()
    private val keys = 1..1000
    private val nonExistentKeys = 1001..2000
    private val actualTree = BinarySearchTree<Int, Int>()
    private val random = Random()

    @Before
    fun createTreeForSearching() {
        for (key in keys) {
            values.add(random.nextInt())
            actualTree[key] = values.last()
        }
    }

    @Test
    fun searchForAll() {
        for (key in keys)
            assertEquals(actualTree[key], values[key - 1])
    }

    @Test
    fun searchForNonExistentKey() {
        for (key in nonExistentKeys)
            assertNull(actualTree[key])
    }

    @Test
    fun searchInEmptyTree() {
        val emptyTree = BinarySearchTree<Int, Int>()
        assertNull(emptyTree[keys.first])
    }

}