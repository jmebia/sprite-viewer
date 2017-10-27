package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;


public class Controller {

    @FXML private GridPane gridPane;

    @FXML private TextField textHeight;
    @FXML private TextField textWidth;
    @FXML private TextField textCol;
    @FXML private TextField textRow;

    @FXML private Canvas canvas;

    @FXML private Label labelCurrentIndex;
    @FXML private Label labelMaxIndex;

    @FXML private Button buttonPrev;
    @FXML private Button buttonNext;
    @FXML private Button buttonOpenFile;

    private ViewerModel vm;

    private GraphicsContext gc;

    @FXML
    void openFile(ActionEvent e) {

        gc = canvas.getGraphicsContext2D();

        Stage stage = (Stage) gridPane.getScene().getWindow();

        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Spritesheet File (jpg, png)");
        fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(stage);

        try {

            Image image = new Image(file.toURI().toString());

            vm = new ViewerModel(image, Integer.parseInt(textHeight.getText()), Integer.parseInt(textWidth.getText()),
                    Integer.parseInt(textCol.getText()));

            gc.setFill(Color.GRAY);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            gc.drawImage(vm.getSpritesheet(), vm.getCurrentIndex() * vm.getSpriteWidth(), 0, vm.getSpriteWidth(),
                    vm.getSpriteHeight(), 0, 0, vm.getSpriteWidth(), vm.getSpriteHeight());

        } catch (Exception exception) {
            exception.printStackTrace();
        }



    }

    @FXML
    void nextView (ActionEvent e) {
        try {

            if (vm.getCurrentIndex() < vm.getMaxIndex())
                vm.setCurrentIndex(vm.getCurrentIndex() + 1);
            else
                vm.setCurrentIndex(vm.getMinIndex());

        } catch (NullPointerException exception) {

            exception.printStackTrace();
        } finally {
            gc.setFill(Color.GRAY);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            gc.drawImage(vm.getSpritesheet(), vm.getCurrentIndex() * vm.getSpriteWidth(), 0, vm.getSpriteWidth(),
                    vm.getSpriteHeight(), 0, 0, vm.getSpriteWidth(), vm.getSpriteHeight());
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

            exception.printStackTrace();
        } finally {
            gc.setFill(Color.GRAY);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            gc.drawImage(vm.getSpritesheet(), vm.getCurrentIndex() * vm.getSpriteWidth(), 0, vm.getSpriteWidth(),
                    vm.getSpriteHeight(), 0, 0, vm.getSpriteWidth(), vm.getSpriteHeight());
        }
    }

}
