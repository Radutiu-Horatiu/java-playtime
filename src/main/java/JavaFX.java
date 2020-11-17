import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.Priority;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.util.ArrayList;
import java.util.List;

public class JavaFX extends Application {

    private int selectedIndex=-1;

    @Override
    public void start(Stage stage) throws Exception {
        Hamming h = new Hamming();
        Levenshtein l = new Levenshtein();
        CSVReader csv = new CSVReader();
        int numberThreads = 5;
        String word = "prodcerp";
        final List<String>[] results = new List[]{new ArrayList<>()};

        Scene scene = new Scene(new Group());
        stage.setTitle("JavaFx Demo");
        stage.setWidth(660);
        stage.setHeight(550);
        TextField wordTxt = new TextField();
        wordTxt.setPromptText("Word");
        TextField res = new TextField();
        res.setPromptText("Result");

        Button updateBtn = new Button("Find");
        updateBtn.setOnAction((ActionEvent e) -> {
            List<String> list = csv.read(1);
            List<csvThread> listThreads = new ArrayList<>();

            int nrThreads = 5;
            String search = wordTxt.getText();
            int chunk = list.size()/nrThreads;

            int i = 0;
            for (i = 0; i < nrThreads; i++) {
                csvThread thread = new csvThread(list.subList(i * chunk, (i + 1) * chunk), h,search);
                listThreads.add(thread);
                thread.start();
            }

            if (list.size() % nrThreads != 0) {
                csvThread thread = new csvThread(list.subList(i * chunk, list.size()), h,search);
                listThreads.add(thread);
                thread.start();
            }

            String minWord = "";
            double minDistance = Double.MAX_VALUE;
            for (csvThread thread: listThreads) {
                try {
                    thread.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if (thread.getMin() < minDistance) {
                    minDistance = thread.getMin();
                    minWord = thread.getMatch();
                }
            }

            res.setText(minWord);
        });

        HBox input_fields = new HBox();
        input_fields.getChildren().addAll(wordTxt, res);
        input_fields.setSpacing(3);
        HBox buttons = new HBox();
        buttons.getChildren().addAll(updateBtn);
        buttons.setSpacing(3);
        VBox myVBox = new VBox();
        myVBox.setSpacing(5);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(input_fields, buttons);
        ((Group) scene.getRoot()).getChildren().addAll(myVBox);
        stage.setScene(scene);
        stage.show();
    }

    public void run() {
        Application.launch();
    }
}
