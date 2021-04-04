package com.aurora.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/4/4 11:17
 * @Description
 */
public class Utils {
    /**
     * Obj对象转Map对象
     * @param obj 要转的对象
     * @return Map对象
     */
    public static Map<String, Object> ObjToMap(Object obj){
        Map<String,Object> reMap = new HashMap<>();
        if (obj == null)
            return null;
        try {
            Class<?> objClass = obj.getClass();
            while(objClass != null){
                Field[] fields = objClass.getDeclaredFields();
                for (Field field : fields) {
                    try {
                        Field f = objClass.getDeclaredField(field.getName());
                        f.setAccessible(true);
                        Object o = f.get(obj);
                        reMap.put(field.getName(), o);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                objClass = objClass.getSuperclass();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return reMap;
    }
}
