package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.System.exit;
import static javafx.scene.paint.Color.LIME;
import static javafx.scene.paint.Color.WHITE;

public class Standard_Text_Editor_Ct implements Initializable {

    @FXML
    private JFXTextArea stuff;

    private Stage stage = new Stage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] font = {"Comic Sans MS", "Arial", "Consolas", "System", "Courier New", "Script"};

        int fontValue = new Random().nextInt(6);

        Font fontDecided = new Font(font[fontValue], 16);
        stuff.setFont(fontDecided);
    }

    public void open() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            String path = file.getAbsolutePath();

            if ((!file.exists() | file.exists()) && path.endsWith(".mp4") | path.endsWith(".mp3") | path.endsWith(".exe") | path.endsWith(".dmg") | path.endsWith(".tar") | path.endsWith(".zip") |
                    path.endsWith(".jpg") | path.endsWith(".pdf") | path.endsWith(".png") | path.endsWith(".bmp") | path.endsWith(".gif")) {

                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setTitle("Standard Text Editor");
                error.setHeaderText(null);
                error.setContentText("The file you have specified is not unable to read.\nPlease specify a valid file to read.");
                error.showAndWait();
            } else if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String line = reader.readLine();

                while (line != null) {
                    stuff.setText(stuff.getText() + line + "\n");
                    line = reader.readLine();
                }
            }
        }
    }

    public void keyboardFunctioning(KeyEvent keyEvent) throws IOException {
        switch (keyEvent.getCode()) {
            case F2:
                open();
                break;

            case F3:
                Clear();
                break;

            case F1:
                About();
                break;

            case ESCAPE:
                Alert exit = new Alert(Alert.AlertType.CONFIRMATION);
                exit.setTitle("Standard Text Editor");
                exit.setHeaderText(null);
                exit.setContentText("Are you sure, you want to exit?");

                ButtonType yes = new ButtonType("Yes");
                ButtonType no = new ButtonType("No");
                exit.getButtonTypes().setAll(yes, no);

                Optional<ButtonType> confirmation = exit.showAndWait();

                if (confirmation.get() == yes) {
                    System.exit(0);
                } else {
                    // Nothing happens here
                }
                break;
        }
    }

    public void About() {
        try {
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/About.fxml")));

            stage.setTitle("Standard Text Editor - About");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Text Editor");
            error.setContentText("Could not find the file \nError opening the file");

            StringWriter sw = new StringWriter();
            new FileNotFoundException()
                    .printStackTrace(new PrintWriter(sw));

            String notFoundException = sw.toString();

            JFXTextArea ta = new JFXTextArea(notFoundException);
            ta.setFocusColor(LIME);
            ta.setUnFocusColor(WHITE);

            error.getDialogPane().setExpandableContent(ta);
            error.showAndWait();
        }
    }

    public void Clear() {
        Alert clear = new Alert(Alert.AlertType.CONFIRMATION);

        clear.setTitle("Standard Text Editor");
        clear.setHeaderText(null);
        clear.setContentText("Are you sure, you want to clear your stuff?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        clear.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> op = clear.showAndWait();

        if(op.get() == yes) {
            stuff.setText("");
        }
    }

    public void Exit() {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

        exit.setTitle("Standard Text Editor");
        exit.setHeaderText("Exit?");
        exit.setContentText("Are you sure, you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        exit.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> op = exit.showAndWait();

       if(op.get() == yes) {
           exit(0);
       }
    }
}