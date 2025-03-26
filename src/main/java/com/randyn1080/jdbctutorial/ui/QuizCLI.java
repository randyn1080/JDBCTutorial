package com.randyn1080.jdbctutorial.ui;

import com.randyn1080.jdbctutorial.model.*;
import com.randyn1080.jdbctutorial.service.QuizService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class QuizCLI {

    private final QuizService quizService;
    private final Scanner scanner;
    private User currentUser;

    public QuizCLI() {
        this.quizService = new QuizService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the SQL Practice Quiz!");

        // First, get or create user
        handleUserLogin();

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    startQuiz();
                    break;
                case 2:
                    viewTopics();
                    break;
                case 3:
                    // View user's quiz history
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using SQL Practice Quiz!");
        scanner.close();
    }

    private void handleUserLogin() {
        // TODO: Implement user login/registration
    }

    private void displayMainMenu() {
        // TODO: Implement main menu display
    }

    private void startQuiz() {
        // TODO: Implement quiz logic
    }

    private void viewTopics() {
        // TODO: Implement topic viewing
    }

    public static void main(String[] args) {
        new QuizCLI().start();
    }
}