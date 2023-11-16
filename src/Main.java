import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> cls = TextContainer.class;
        Object obj = TextContainer.class.newInstance();
        if (cls.isAnnotationPresent(SaveTo.class)) {
            SaveTo sta = cls.getAnnotation(SaveTo.class);
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    int mods = method.getModifiers();
                    if (!Modifier.isPublic(mods)) method.setAccessible(true);
                    method.invoke(obj, sta.path());
                    break;
                }
            }
        }
    }
}
