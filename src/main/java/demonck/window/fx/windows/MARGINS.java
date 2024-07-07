package demonck.window.fx.windows;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public  class MARGINS extends Structure {
    public int cxLeftWidth;
    public int cxRightWidth;
    public int cyTopHeight;
    public int cyBottomHeight;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("cxLeftWidth", "cxRightWidth", "cyTopHeight", "cyBottomHeight");
    }
}