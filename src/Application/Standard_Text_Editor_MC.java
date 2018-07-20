package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static javafx.scene.paint.Color.LIME;
import static javafx.scene.paint.Color.WHITE;

public class Standard_Text_Editor_MC extends Application {

    @Override
    public void start(Stage ps) {
        try {
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/Standard_Text_Editor.fxml")));

            ps.setTitle("Standard Text Editor");
            ps.setScene(sc);
            ps.setResizable(false);
            ps.show();
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Text Editor");
            error.setContentText("Could not find the file \nError opening the Standard Text Editor");

            StringWriter sw = new StringWriter();
            new FileNotFoundException().printStackTrace(new PrintWriter(sw));

            JFXTextArea ta = new JFXTextArea(sw.toString());
            ta.setFocusColor(LIME);
            ta.setUnFocusColor(WHITE);

            error.getDialogPane().setExpandableContent(ta);
            error.showAndWait();
        }
    }

}