package app;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {


    @FXML private TextField textHeight;
    @FXML private TextField textWidth;
    @FXML private TextField textCol;

    @FXML private Canvas canvas;

    @FXML private Label labelCurrentIndex;
    @FXML private Label labelMaxIndex;

    @FXML private Button buttonPrev;
    @FXML private Button buttonNext;
    @FXML private Button buttonOpenFile;

}
