# Windows DWM Library

![Example](https://github.com/DEMoN881/WinFX/blob/main/image.png?raw=true)


## Описание

Эта библиотека позволяет взаимодействовать с окнами операционных систем Windows 10 и 11 с помощью нативных методов Java. С её помощью можно изменять фреймы окон, добавлять эффект размытия (blur) в Windows 11 и многое другое!

## Возможности

- Установка темного режима окна.
- Изменение цвета бордера окна.
- Изменение цвета заголовка окна.
- Изменение цвета текста в рамке окна.
- Перерисовка окна для применения изменений.
- Установка системного фона для Windows 11.

## Примеры использования

```java

import demonck.window.fx.windows.WindowsDWM10;
import demonck.window.fx.windows.WindowsDWM11;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.HashSet;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        
        VBox root = new VBox();
        Scene scene = new Scene(root, 320, 240);
        
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
            WindowsDWM11.setSystemBackdropType(scene, WindowsDWM11.SYSTEMBACKDROP_TYPE_ACRYLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

![Example](https://github.com/DEMoN881/WinFX/blob/main/image.png?raw=true)
