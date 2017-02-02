package com.googlecode.totallylazy.json;

//import com.googlecode.totallylazy.Mapper;
//import com.googlecode.totallylazy.Pair;
//import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.parser.Result;

import java.io.Reader;
import java.util.List;
import java.util.Map;

//import static com.googlecode.totallylazy.Unchecked.cast;

public class Json {
    public static String json(Object value) {
        throw new RuntimeException("DAN");
        //return JsonWriter.write(value, new StringBuilder()).toString();
    }
//
    public static <V> Map<String, V> map(String json) {
        throw new RuntimeException("DAN");
        //return Json.<V>parseMap(json).value();
    }
//
    public static <V> List<V> list(String json) {
        return Json.<V>parseList(json).value();
    }

    public static <V> Result<Map<String, V>> parseMap(String json) {
        throw new RuntimeException("DAN");
        //return cast(Grammar.OBJECT.parse(json));
    }
//
    public static <V> Result<List<V>> parseList(String json) {
        throw new RuntimeException("DAN");
        //return cast(Grammar.ARRAY.parse(json));
    }
//
    public static Result<Object> parseObject(String json) {
        throw new RuntimeException("DAN");
        //return Grammar.VALUE.parse(json);
    }

}
