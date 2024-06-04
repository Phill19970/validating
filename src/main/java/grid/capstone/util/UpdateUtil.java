package grid.capstone.util;

import java.util.function.Consumer;

public class UpdateUtil {

    public static <T> void UpdateTool(T value, Consumer<T> setter) {
        if (value != null) {
            setter.accept(value);
        }
    }

}
