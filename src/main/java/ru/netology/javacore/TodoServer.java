package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class TodoServer {

    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        out.println("Starting server at " + port + "...");

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try (Socket connection = serverSocket.accept();
                PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                String name = in.readLine();
                Todos todos1 = gson.fromJson(name, Todos.class);
                if (todos1.getType().equals("ADD")) {
                    todos.addTask(todos1.getTask());
                } else if (todos1.getType().equals("REMOVE")) {
                    todos.removeTask(todos1.getTask());
                }
                out.println(todos.getAllTasks());
            } catch (IOException e) {
                out.println(e.getMessage());
            }
        }
    }
}

