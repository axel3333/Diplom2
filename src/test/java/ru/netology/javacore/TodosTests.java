package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTests {
    Todos todos = new Todos();
    Todos todos1 = new Todos();
    Todos todos2 = new Todos();

    @Test
    public void testAddTask() {
        boolean expected = true;
        todos.addTask("Alex");
        boolean result = todos.getList().contains("Alex");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRemoveTask() {
        boolean expected = false;
        todos1.addTask("Max");
        todos1.removeTask("Max");
        boolean result = todos1.getList().contains("Max");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetAllTasks() {
        String expected = "Alex Bobby Max ";
        todos2.addTask("Max");
        todos2.addTask("Alex");
        todos2.addTask("Bobby");
        String result = todos2.getAllTasks();

        Assertions.assertEquals(expected, result);
    }

    // ваши тесты для класса Todos
}
