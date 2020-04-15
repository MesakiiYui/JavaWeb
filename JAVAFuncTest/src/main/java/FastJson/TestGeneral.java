package FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class TestGeneral {
    public static void main(String[]  args) {
        RequestDTO<PersonDTO> requestDTO = new RequestDTO<PersonDTO>();
        requestDTO.setCaller("callerId");
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(11);
        personDTO.setName("张三");
        requestDTO.setParam(personDTO);

        String jsonString = JSON.toJSONString(requestDTO);
        System.out.println(jsonString);
        //这行是关键代码
        requestDTO = JSON.parseObject(jsonString, new TypeReference<RequestDTO<PersonDTO>>(){});


        System.out.println(requestDTO.getParam().getName());
    }
}
