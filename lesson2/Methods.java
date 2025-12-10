import java.lang.reflect.Method;

public class Methods {
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}