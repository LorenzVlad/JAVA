package com.example.fsm;

public class FiniteStateMachine {
    private String state;

    public FiniteStateMachine() {
        // Початковий стан
        this.state = "S";
    }

    public void reset() {
        // Скидання стану
        this.state = "S";
    }

    public void transition(char input) {
        // Логіка переходів між станами
        switch (state) {
            case "S":
                if (input == 'T') state = "1";
                break;
            case "1":
                if (input == 'E') state = "2";
                else if (input == 'T') state = "1";
                else state = "S";
                break;
            case "2":
                if (input == 'S') state = "3";
                else if (input == 'T') state = "1";
                else
                    state = "S";
                break;
            case "3":
                if (input == 'T') state = "F";
                else if (input == 'T') state = "1";
                else state = "S";
                break;
            case "F":
                // Кінцевий стан, залишаємо автомат у цьому стані
                break;
            default:
                throw new IllegalStateException("Невідомий стан: " + state);
        }
    }

    public String process(String input) {
        // Обробка рядка символів
        for (char c : input.toCharArray()) {
            transition(c);
        }
        return state;
    }

    public String getState() {
        return state;
    }
}
