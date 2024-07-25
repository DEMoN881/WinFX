package demonck.window.fx.windows;

import com.sun.jna.*;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.PointerByReference;
import demonck.window.exceptions.WindowsDWM10Exception;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class WindowsDWM10 {
    // Атрибуты DWM
    protected static final int DWMWA_USE_IMMERSIVE_DARK_MODE = 20;
    protected static final int DWMWA_BORDER_COLOR = 34;
    protected static final int DWMWA_CAPTION_COLOR = 35;
    protected static final int DWMWA_TEXT_COLOR = 36;



    /**
     * Установка темного режима.
     * Setting the dark mode.
     *
     * @param scene
     * @param useDarkMode
     *
     */
    public static void setUseImmersiveDarkMode(Scene scene, boolean useDarkMode) throws Exception {
        WinDef.HWND hWnd = getWindowHWND((Stage) scene.getWindow());

        int value = useDarkMode ? 1 : 0;
        WinNT.HRESULT result = DwmApi.INSTANCE.DwmSetWindowAttribute(hWnd,
                DWMWA_USE_IMMERSIVE_DARK_MODE, new PointerByReference(new WinDef.UINT_PTR(value).toPointer()), new NativeLong(NativeLong.SIZE));
        if (!SUCCEEDED(result)) {
            throw new WindowsDWM10Exception("The attribute could not be set DWM:  DWMWA_USE_IMMERSIVE_DARK_MODE");
        }
    }
    /**
     * Установка цвета бордера.
     * Setting the border color.
     *
     * @param scene
     * @param hexColor
     *
     */
    public static void setBorderColor(Scene scene, String hexColor) throws Exception {
        WinDef.HWND hWnd = getWindowHWND((Stage) scene.getWindow());

        Pointer color = parseHexColor(hexColor);
        WinNT.HRESULT result = DwmApi.INSTANCE.DwmSetWindowAttribute(hWnd,
                DWMWA_BORDER_COLOR, new PointerByReference(color), new NativeLong(NativeLong.SIZE));
        if (!SUCCEEDED(result)) {
            throw new WindowsDWM10Exception("The attribute could not be set DWM: DWMWA_BORDER_COLOR");
        }
    }
    /**
     * Установка цвета заголовка окна.
     * Setting the window title color.
     *
     * @param scene
     * @param hexColor
     *
     */
    public static void setCaptionColor(Scene scene, String hexColor) throws Exception {
        WinDef.HWND hWnd = getWindowHWND((Stage) scene.getWindow());

        Pointer color = parseHexColor(hexColor);
        WinNT.HRESULT result = DwmApi.INSTANCE.DwmSetWindowAttribute(hWnd,
                DWMWA_CAPTION_COLOR, new PointerByReference(color), new NativeLong(NativeLong.SIZE));
        if (!SUCCEEDED(result)) {
            throw new WindowsDWM10Exception("The attribute could not be set DWM: DWMWA_CAPTION_COLOR");

        }
    }

    /**
     * Установка цвета текста в рамке окна.
     * Setting the text color in the window frame.
     *
     * @param scene
     * @param hexColor
     *
     */
    public static void setTextColor(Scene scene, String hexColor) throws Exception {
        WinDef.HWND hWnd = getWindowHWND((Stage) scene.getWindow());

        Pointer color = parseHexColor(hexColor);
        WinNT.HRESULT result = DwmApi.INSTANCE.DwmSetWindowAttribute(hWnd,
                DWMWA_TEXT_COLOR, new PointerByReference(color), new NativeLong(NativeLong.SIZE));
        if (!SUCCEEDED(result)) {
            throw new WindowsDWM10Exception("The attribute could not be set DWM: DWMWA_TEXT_COLOR DWM");
        }
    }


    /**
     * Перерисовка окна для применения изменений.
     * Redrawing the window to apply the changes.
     *
     * @param scene
     *
     */
    public static void redrawWindow(Scene scene) throws Exception {
        WinDef.HWND hWnd = getWindowHWND((Stage) scene.getWindow());

        User32.INSTANCE.ShowWindow(hWnd, WinUser.SW_MINIMIZE);
        User32.INSTANCE.ShowWindow(hWnd, WinUser.SW_RESTORE);
    }

    protected interface DwmApi extends Library {
        DwmApi INSTANCE = Native.load("dwmapi", DwmApi.class);

        WinNT.HRESULT DwmSetWindowAttribute(WinDef.HWND hwnd, int dwAttribute, PointerByReference pvAttribute, NativeLong cbAttribute);

    }


    protected static boolean SUCCEEDED(WinNT.HRESULT hr) {
        return hr.longValue() >= 0;
    }

    private static Pointer parseHexColor(String hexColor) throws WindowsDWM10Exception {
        if (hexColor.startsWith("#")) {
            hexColor = hexColor.substring(1);
        }

        if (hexColor.length() != 6) {
            throw new WindowsDWM10Exception("Invalid HEX color format");
        }

        int decimalValue = (int) Long.parseLong(hexColor, 16);

        int red = (decimalValue >> 16) & 0xFF;
        int green = (decimalValue >> 8) & 0xFF;
        int blue = decimalValue & 0xFF;

        int bgrValue = (blue << 16) | (green << 8) | red;

        return new WinDef.UINT_PTR(bgrValue).toPointer();
    }


   protected static WinDef.HWND getWindowHWND(Stage stage) {
        WinDef.HWND hWnd = null;
        if (Platform.isWindows()) {
            try {
                hWnd = User32.INSTANCE.GetForegroundWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Unsupported platform.");
        }
        return hWnd;
    }


}

