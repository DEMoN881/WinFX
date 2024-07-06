# Windows DWM Library

![Example](https://github.com/DEMoN881/WinFX/blob/main/image.png?raw=true)


## Описание
Эта библиотека позволяет взаимодействовать с окнами операционных систем Windows 10 и 11 с помощью нативных системы. С её помощью можно изменять фреймы окон, добавлять эффект размытия (blur) в Windows 11 и многое другое!
Я планирую сделать библиотеку кроссплатформенной, если будет достаточно интереса. Пожалуйста, поддержите проект, нажав на звёздочку на GitHub  :). Ваше участие очень важно для меня!
## Description
This library allows you to interact with windows of Windows 10 and 11 operating systems using native systems. You can use it to change window frames, add a blur effect to Windows 11, and much more!
I plan to make the library cross-platform if there is enough interest. Please support the project by clicking on the asterisk on GitHub :). Your participation is very important to me!

## Возможности \/ Opportunities

- Установка темного режима окна.\/ Setting the dark window mode.
- Изменение цвета бордера окна.\/ Changing the color of the window border.
- Изменение цвета заголовка окна.\/ Change the color of the window title.
- Изменение цвета текста в рамке окна.\/ Change the color of the text in the window frame.
- Перерисовка окна для применения изменений.\/ Redrawing the window to apply the changes.
- Установка системного фона для Windows 11.\/ Installation of the system background for Windows 11.(blur)

## Примеры использования \/ Usage examples

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
           // WindowsDWM11.setSystemBackdropType(scene, WindowsDWM11.SYSTEMBACKDROP_TYPE_ACRYLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
```
![Example](https://raw.githubusercontent.com/DEMoN881/WinFX/main/imagesx.png)

```java
    @Override
    public void start(Stage stage) {

        VBox root = new VBox();
        Button button = new Button("cliiiiiiiiiiiiiiiiiick!");

        root.getChildren().add(button);
        root.setStyle("-fx-background-color: black;");
        Scene scene = new Scene(root, 320, 240);

        stage.setTitle("Hello!");
        stage.initStyle(StageStyle.UNIFIED); // unified mode
        stage.setScene(scene);
        stage.show();
        try {
            //Включения темного режима, чтобы отключить передайте в аргумент false \/ To turn on the dark mode, pass false to the argument
            WindowsDWM10.setUseImmersiveDarkMode(scene, true);

            // Установка цветов \/ Setting colors
            //WindowsDWM10.setBorderColor(scene, "#FF0000");
            //WindowsDWM10.setCaptionColor(scene, "#00FF00");
            WindowsDWM10.setTextColor(scene, "#0000FF");

            // Перерисовка окна (не обязательно) \/ Redrawing the window (optional)
            WindowsDWM10.redrawWindow(scene);

            // Пример использования методов для Windows 11 \/ An example of using methods for Windows 11
            WindowsDWM11.setSystemBackdropType(scene, WindowsDWM11.SYSTEMBACKDROP_TYPE_ACRYLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```
![Example](https://github.com/DEMoN881/WinFX/blob/main/blurImage.png?raw=true)
