package edu.miracosta.cs113;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * BinarySearchTreeTest : Tester class for a binary search tree implementation.
 *
 * @author King
 * @version 1.0
 */
public class BinarySearchTreeTest {

    /** Data to populate a BinarySearchTree. */
    private static final String[] STRING_DATA = {"The", "quick", "brown", "fox", "jumps",
            "over", "the", "lazy", "dog"};

    /** Data for testing this BinarySearchTree's find failure. */
    private static final String FIND_FAIL_DATA = "DOG";

    /** A BinaryTree to contain String data. */
    private BinarySearchTree<String> strTree;

    /** Helper method to populate the BinarySearchTree. Relies upon a correct implementation of the add method. */
    @BeforeEach
    public void buildTreeWithAdd() {
        strTree = new BinarySearchTree<String>();
        for (String s : STRING_DATA) {
            assertTrue(strTree.add(s), "Method buildTree failed.");
        }
    }

    @Test
    public void testAddFailure() {
        assertFalse(
                strTree.add(STRING_DATA[0]), "Test add failed - the addition of a duplicate value has occurred.");
    }

    @Test
    public void testFind() {
        assertEquals(
                STRING_DATA[5], strTree.find(STRING_DATA[5]), "Test find failed - expected element not found in tree.");
    }

    @Test
    public void testFindFailure() {
        assertEquals(
                null, strTree.find(FIND_FAIL_DATA), "Test find failed - expected null.");
    }

    @Test
    public void testContains() {
        assertTrue(
                strTree.contains(STRING_DATA[4]), "Test contains failed - expected element should exist in this tree.");
    }

    @Test
    public void testContainsFailure() {
        assertFalse(
                strTree.contains(FIND_FAIL_DATA), "Test contains failed - given element should have not been added to this tree.");
    }

    @Test
    public void testRemove() {
        // Remove element
        assertTrue(
                strTree.remove(STRING_DATA[5]), "Test remove failed - an element that was added to this tree should be removed.");

        // Validate with contains
        assertFalse(
                strTree.contains(STRING_DATA[5]), "Test remove failed - an element that was added to this tree should be removed.");
    }

    @Test
    public void testRemoveFailure() {
        assertFalse(
                strTree.remove(FIND_FAIL_DATA), "Test remove failed - element intended for removal does not exist in this tree.");
    }

    @Test
    public void testDelete() {
        // Delete element
        assertEquals("Test delete failed - method should return data of removed element.",
                STRING_DATA[7], strTree.delete(STRING_DATA[7]));

        // Validate with contains
        assertFalse(
                strTree.contains(STRING_DATA[7]), "Test delete failed - an element that was added to this list should be deleted.");
    }

    @Test
    public void testDeleteFailure() {
        assertEquals(
                null, strTree.delete(FIND_FAIL_DATA), "Test delete failed - element intended for deletion does not exist in this tree.");
    }

    @Test
    public void testToString() {
        // TODO: =>
        // Validate simple toString constructed through an inorder traversal.

        System.out.println("Simple toString:\n\n" + strTree);
        System.out.println("Polymorphic toString:\n\n" + strTree.toString2());
    }


} // End of class BinarySearchTreeTest