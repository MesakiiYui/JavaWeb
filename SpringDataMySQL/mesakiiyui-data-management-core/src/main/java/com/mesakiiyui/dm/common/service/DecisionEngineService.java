package com.mesakiiyui.dm.common.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: jintienan
 * @Date: 2020/12/16 15:15
 */
// 还有一种形式
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")  //该接口对应于应用id为MICROSERVICECLOUD-DEPT的微服务
//@FeignClient(url = "${decisionEngine.url}",name="engine")
public interface DecisionEngineService {
      @RequestMapping(value = "/",method = RequestMethod.GET)
      public String zhiHuGet();


//    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
//    public Dept get(@PathVariable("id") long id);
//
//
//    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
//    public List<Dept> list();
//
//
//    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
//    public boolean add(Dept dept);

}
