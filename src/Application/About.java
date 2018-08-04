package Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class About {

    public void whatNew() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Application/WhatsNew.fxml"));

        stage.setTitle("Standard Text Editor - What's New");
        stage.setScene(new Scene(loader.load()));
        stage.setResizable(false);
        stage.show();
    }

}