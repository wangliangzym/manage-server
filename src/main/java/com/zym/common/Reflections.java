package com.zym.common;

import lombok.extern.slf4j.Slf4j;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @ClassName : Reflections
 * @Description :
 * @Author : Wang Liang
 * @Date: 2021-07-14 11:51
 */
@Slf4j
public class Reflections {

    private static final Pattern GET_PATTERN = Pattern.compile("^get[A-Z].*");
    private static final Pattern IS_PATTERN = Pattern.compile("^is[A-Z].*");

    private Reflections() {
    }

    public static String fnToFieldName(Fn fn) {
        Method method = null;
        try {
            method = fn.getClass().getDeclaredMethod("writeReplace");

            method.setAccessible(Boolean.TRUE);
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(fn);
            String getter = serializedLambda.getImplMethodName();
            if (GET_PATTERN.matcher(getter).matches()) {
                getter = getter.substring(3);
            } else if (IS_PATTERN.matcher(getter).matches()) {
                getter = getter.substring(2);
            }

            return Introspector.decapitalize(getter);
        } catch (NoSuchMethodException e) {
            log.error("ERROR:", e);
        } catch (IllegalAccessException e) {
            log.error("ERROR:", e);
        } catch (InvocationTargetException e) {
            log.error("ERROR:", e);
        }

        return null;
    }
}
