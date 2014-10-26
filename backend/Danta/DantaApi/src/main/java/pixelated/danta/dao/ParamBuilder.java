/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.dao;

/**
 *
 * @author Juan Carlos Rojas
 */
public class ParamBuilder extends HashMapBuilder<String,Object> {

    @Override
    public ParamBuilder add(String paramName, Object paramValuem) {
        super.add(paramName, paramValuem);
        return this;
    }
    
    public static ParamBuilder get(boolean ignoreNull) {
        ParamBuilder builder = new ParamBuilder();
        return (ParamBuilder)builder.setIgnoreNull(ignoreNull);
    }

    public static ParamBuilder get() {
        return get(false);
    }

    public static ParamBuilder param(String paramName, Object paramValue) {
        ParamBuilder builder = new ParamBuilder();
        return (ParamBuilder)builder.add(paramName, paramValue);
    }

    
}
