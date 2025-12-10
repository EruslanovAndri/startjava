import java.lang.reflect.Method;

public class Methods {
    public static String getMethodName() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return methodName;
    }
}