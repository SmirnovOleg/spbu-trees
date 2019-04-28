import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import java.util.Random

class RedBlackTreeSearchTest {

    private val expectedAnswers = mutableMapOf<Int, Int>()
    private val actualTree = RedBlackTree<Int, Int>()
    private val random = Random()

    @Before
    fun createTreeForSearching() {
        while (expectedAnswers.size < 10000) {
            val key = random.nextInt()
            val value = random.nextInt()
            expectedAnswers[key] = value
            actualTree[key] = value
        }
    }

    @Test
    fun searchForAll() {
        for (key in expectedAnswers.keys)
            assertEquals(actualTree[key], expectedAnswers[key])
    }

    @Test
    fun searchForNonExistentKey() {
        for (key in 1..20000) {
            if ( ! (key in expectedAnswers.keys))
                assertNull(actualTree[key])
        }
    }

    @Test
    fun searchInEmptyTree() {
        val emptyTree = BinarySearchTree<Int, Int>()
        for (key in 1..10000)
            assertNull(actualTree[key])
    }

}
