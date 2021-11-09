package com.example.pro13_14;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Collections;

public class Field {
    Button[][] buttons = new Button[4][4];
    int size;
    int clicks = 0;
    GridPane field = new GridPane();

    public Field(int size) {
        this.size = size;
    }

    public GridPane buildField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int tempI = i;
                int tempJ = j;
                buttons[i][j] = new Button();
                buttons[i][j].setPrefWidth(30);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (buttons[tempI][tempJ].getText() == "") {
                            if (clicks % 2 == 0) {
                                buttons[tempI][tempJ].setText("+");
                                clicks += 1;
                                win();
                            } else {
                                buttons[tempI][tempJ].setText("-");
                                clicks += 1;
                                win();
                            }
                        }
                    }
                });
                field.add(buttons[i][j], i, j);
            }
        }
        return field;
    }

    public void win() {
        int k, k1;
        for (int i = 0; i < size; i++) {
            k = 0;
            for (int j = 0; j < size; j++) {
                if ((buttons[i][0].getText() == buttons[i][j].getText()) & (buttons[i][j].getText() != "")) {
                    k = k + 1;
                    if (k == size) {
                        field.getChildren().clear();
                        winnerDefine(buttons[i][j]);
                    }
                } else k = 0;
            }
        }
        for (int j = 0; j < size; j++) {
            k1 = 0;
            for (int i = 0; i < size; i++) {
                if ((buttons[0][j].getText() == buttons[i][j].getText()) & (buttons[i][j].getText() != "")) {
                    k1 += 1;
                    if (k1 == size) {
                        field.getChildren().clear();
                        winnerDefine(buttons[i][j]);
                    }
                } else k1 = 0;
            }
        }
        if (clicks == 16) {
            field.getChildren().clear();
            field.add(new Label("никто не победил!"), 0, 0);
        }
    }

    public void winnerDefine(Button button) {
        if (button.getText() == "+") {
            field.add(new Label("выиграл первый"), 0, 0);
            field.add(new Label("игрок!"), 0, 1);
        } else {
            field.add(new Label("выиграл второй"), 0, 0);
            field.add(new Label("игрок!"), 0, 1);
        }
    }
}
