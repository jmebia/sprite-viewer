package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Controller {

    @FXML private GridPane gridPane;

    @FXML private TextField textHeight;
    @FXML private TextField textWidth;
    @FXML private TextField textCol;

    @FXML private Canvas canvas;

    @FXML private Label labelCurrentIndex;
    @FXML private Label labelMaxIndex;

    @FXML private Button buttonPrev;
    @FXML private Button buttonNext;
    @FXML private Button buttonOpenFile;

    private ViewerModel vm;

    @FXML
    void openFile(ActionEvent e) {

        Stage stage = (Stage) gridPane.getScene().getWindow();

        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Spritesheet File");
        fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(stage);

        Image image = new Image(file.toURI().toString());

        vm = new ViewerModel(image, Integer.parseInt(textHeight.getText()), Integer.parseInt(textWidth.getText()),
                Integer.parseInt(textCol.getText()));

    }

    @FXML
    void nextView (ActionEvent e) {
        try {

            if (vm.getCurrentIndex() < vm.getMaxIndex())
                vm.setCurrentIndex(vm.getCurrentIndex() + 1);
            else
                vm.setCurrentIndex(vm.getMinIndex());

        } catch (NullPointerException exception) {

        }
    }

    @FXML
    void prevView (ActionEvent e) {
        try {

            if (vm.getCurrentIndex() > vm.getMinIndex())
                vm.setCurrentIndex(vm.getCurrentIndex() - 1);
            else
                vm.setCurrentIndex(vm.getMaxIndex());

        } catch (NullPointerException exception) {

        }
    }

}
