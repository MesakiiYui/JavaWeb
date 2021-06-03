package functest.jsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONImpl {
    private static void JsonArrayImpl() {
        // 一个未转化的字符串
        String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]" ;
        // 首先把字符串转成 JSONArray  对象
        JSONArray json = new JSONArray(str);
        if(json.length()>0){
            for(int i=0;i<json.length();i++){
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = json.getJSONObject(i);
// 得到 每个对象中的属性值
                System.out.println(job.get("name")+"="+job.get("value")) ;
            }
        }
    }

    private static void JsonObjectImpl() {
        String str = "{ansArr:[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]}";
        JSONObject jsonObj = new JSONObject(str);
        System.out.println(jsonObj.toString());
    }

    public static void main(String[] args) {
        JsonArrayImpl();
        JsonObjectImpl();
    }



}
