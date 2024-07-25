package test;


import demonck.window.fx.windows.WindowsDWM10;
import demonck.window.fx.windows.WindowsDWM11;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Collection;
import java.util.HashSet;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

        stage.initStyle(StageStyle.UNIFIED);
        Button btn = new Button();
        btn.setText("Hello World");
        btn.setPadding(new Insets(10));
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");

        root.setPadding(new Insets(10));
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        scene.setFill(Paint.valueOf("black"));

        stage.setTitle("Custom Window Example");
        stage.setScene(scene);
        stage.show();

        // Применение настраиваемой рамки окна
        try {
            // Установка темного режима
            WindowsDWM10.setUseImmersiveDarkMode(scene, true);

            // Установка цвета бордера
         //   WindowsDWM10.setBorderColor(scene, "#FF0000"); // Красный цвет

            // Установка цвета заголовка окна
        //    WindowsDWM10.setCaptionColor(scene, "#00FF00"); // Зеленый цвет

            // Установка цвета текста в рамке окна
         //   WindowsDWM10.setTextColor(scene, "#0000FF"); // Синий цвет

            WindowsDWM11.setSystemBackdropType(scene,WindowsDWM11.SYSTEMBACKDROP_TYPE_NONE);
            WindowsDWM11.setWindowCornerPreference(scene, WindowsDWM11.WINDOW_CORNER_PREFERENCE_ROUND_SMALL);

            WindowsDWM10.redrawWindow(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
