package functest.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

/**
 * SerializerFeature常用属性
 *
 * 名称	含义
 * QuoteFieldNames	输出key时是否使用双引号,默认为true
 * UseSingleQuotes	使用单引号而不是双引号,默认为false
 * WriteMapNullValue	是否输出值为null的字段,默认为false
 * WriteEnumUsingToString	Enum输出name()或者original,默认为false
 * UseISO8601DateFormat	Date使用ISO8601格式输出，默认为false
 * WriteNullListAsEmpty	List字段如果为null,输出为[],而非null
 * WriteNullStringAsEmpty	字符类型字段如果为null,输出为”“,而非null
 * WriteNullNumberAsZero	数值字段如果为null,输出为0,而非null
 * WriteNullBooleanAsFalse	Boolean字段如果为null,输出为false,而非null
 * SkipTransientField	如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true
 * SortField	按字段名称排序后输出。默认为false
 * WriteTabAsSpecial	把\t做转义输出，默认为false不推荐设为true
 * PrettyFormat	结果是否格式化,默认为false
 * WriteClassName	序列化时写入类型信息，默认为false。反序列化是需用到
 * DisableCircularReferenceDetect	消除对同一对象循环引用的问题，默认为false
 * WriteSlashAsSpecial	对斜杠’/’进行转义
 * BrowserCompatible	将中文都会序列化为 转斜杠uXXXX 格式，字节数会多一些，但是能兼容IE 6，默认为false
 * WriteDateUseDateFormat	全局修改日期格式,默认为false。
 * DisableCheckSpecialChar	一个对象的字符串属性中如果有特殊字符如双引号，将会在转成json时带有反斜杠转移符。如果不需要转义，可以使用这个属性。默认为false
 * BeanToArray	将对象转为array输出
 */
public class SerializerFeatureTest {
    public static void main(String[] args) {
        User user = new User();
        user.setId(11L);
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(
                user,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.UseSingleQuotes,
                SerializerFeature.WriteClassName
        );

        System.out.println(jsonString);

    }
}
