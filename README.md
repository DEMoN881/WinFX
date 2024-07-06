# Windows DWM Library

![Пример скриншота](https://github.com/DEMoN881/WinFX/blob/main/image.png?raw=true)


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
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {
    public static void main(String[] args) {
        // Создание сцены и окна
        Stage stage = new Stage();
        Scene scene = new Scene(new Group(), 800, 600);
        stage.setScene(scene);

        try {
            // Установка темного режима
            WindowsDWM10.setUseImmersiveDarkMode(scene, true);
            
            // Установка цветов
            WindowsDWM10.setBorderColor(scene, "#FF0000");
            WindowsDWM10.setCaptionColor(scene, "#00FF00");
            WindowsDWM10.setTextColor(scene, "#0000FF");
            
            // Перерисовка окна
            WindowsDWM10.redrawWindow(scene);
            
            // Пример использования методов для Windows 11
            WindowsDWM11.setSystemBackdropType(scene, WindowsDWM11.SYSTEMBACKDROP_TYPE_ACRYLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.show();
    }
}

