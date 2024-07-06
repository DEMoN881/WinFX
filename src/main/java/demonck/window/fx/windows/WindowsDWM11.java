package demonck.window.fx.windows;

import com.sun.jna.NativeLong;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import demonck.window.exceptions.WindowsDWM10Exception;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowsDWM11 extends WindowsDWM10{

    // Атрибуты DWM
    private static final int DWMWA_SYSTEMBACKDROP_TYPE = 38;

    public static final int SYSTEMBACKDROP_TYPE_ACRYLIC = 3;
    public static final int SYSTEMBACKDROP_TYPE_TAB = 4;

    public static void setSystemBackdropType(Scene scene, int backdropType) throws Exception {
        WinDef.HWND hWnd = getWindowHWND((Stage) scene.getWindow());

        WinNT.HRESULT result = DwmApi.INSTANCE.DwmSetWindowAttribute(hWnd,
                DWMWA_SYSTEMBACKDROP_TYPE, new PointerByReference(new WinDef.UINT_PTR(backdropType).toPointer()), new NativeLong(NativeLong.SIZE));
        if (!SUCCEEDED(result)) {
            throw new WindowsDWM10Exception("The attribute could not be set DWM:  DWMWA_SYSTEMBACKDROP_TYPE");
        }
    }
}
