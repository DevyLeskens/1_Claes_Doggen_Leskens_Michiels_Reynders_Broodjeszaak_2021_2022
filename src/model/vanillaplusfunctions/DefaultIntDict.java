package model.vanillaplusfunctions;


import java.util.HashMap;


public class DefaultIntDict<K, Integer> extends HashMap<K, Integer> {

    Integer defaultvalue;
    public DefaultIntDict(Integer defaultvalue) {
        this.defaultvalue = defaultvalue;
    }
    public Integer safeGet(Object key) {
        Integer returnValue = super.get(key);
        if (returnValue == null) {
            this.put((K) key,defaultvalue);
            return defaultvalue;
        }
        return returnValue;
    }
}
