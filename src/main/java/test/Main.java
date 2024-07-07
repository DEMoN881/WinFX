package test;


import demonck.window.fx.windows.WindowsDWM10;
import demonck.window.fx.windows.WindowsDWM11;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.HashSet;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 320, 240);

        Button button = new Button("asdasdasd");
        button.setLayoutY(0);
        root.getChildren().add(button);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        try {
            //Включения темного режима, чтобы отключить передайте в аргумент false \/ To turn on the dark mode, pass false to the argument
            WindowsDWM10.setUseImmersiveDarkMode(scene, true);

            // Установка цветов \/ Setting colors
            WindowsDWM10.setBorderColor(scene, "#FF0000");
            WindowsDWM10.setCaptionColor(scene, "#00FF00");
            WindowsDWM10.setTextColor(scene, "#0000FF");
            // Перерисовка окна (не обязательно) \/ Redrawing the window (optional)
            WindowsDWM10.redrawWindow(scene);

            // Пример использования методов для Windows 11 \/ An example of using methods for Windows 11
            // WindowsDWM11.setSystemBackdropType(scene, WindowsDWM11.SYSTEMBACKDROP_TYPE_ACRYLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
