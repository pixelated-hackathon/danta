/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import java.util.HashMap;

/**
 *
 * @author Juan Carlos Rojas
 */
public class HashMapBuilder<T,K> {
    
    private final HashMap<T, K> paramList;
    private boolean ignoreNull = false;

    protected HashMapBuilder() {
        paramList = new HashMap<T,K>();
    }

    public HashMapBuilder<T,K> add(T paramName, K paramValue) {
        if (!ignoreNull || paramValue != null) {
            paramList.put(paramName, paramValue);
        }
        return this;
    }

    public HashMap<T, K> getParams() {
        return paramList;
    }

    public int size() {
        return paramList.size();
    }

    /**
     * @return the ignoreNull
     */
    public boolean isIgnoreNull() {
        return ignoreNull;
    }
    
    public HashMapBuilder<T,K> setIgnoreNull(boolean ignoreNull) {
        this.ignoreNull = ignoreNull;
        return this;
    }
    
    public static <T,K> HashMapBuilder<T,K> get(T paramName, K paramValue) {
        HashMapBuilder<T, K> builder = new HashMapBuilder<T,K>();
        builder.add(paramName, paramValue);
        return builder;
    }
}
