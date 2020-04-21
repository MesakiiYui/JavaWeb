<<<<<<< HEAD:SpringDataMySQL/src/main/java/com/mesakiiyui/springdatamysql/controller/CityController.java
package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.Entity.City;
import com.mesakiiyui.springdatamysql.Repo.CityRepository;
import com.mesakiiyui.springdatamysql.view.RespModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

//2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
//3)如果需要返回json或者xml或者自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
@Controller    // This means that this class is a Controller
@RequestMapping(path="/City") // This means URL's start with /demo (after Application path)
public class CityController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CityRepository cityRepository;


    @PostMapping(path = "/addOneCity") // Map ONLY POST Requests
    public @ResponseBody
    String addNewCity(@RequestParam String name
            , @RequestParam String countryCode, @RequestParam String district, @RequestParam Integer population) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        City c = new City();
        c.setName(name);
        c.setCountryCode(countryCode);
        c.setDistrict(district);
        c.setPopulation(population);
        cityRepository.save(c);
        return "Saved";
    }

    @ResponseBody
    @GetMapping(path = "/allCity")
    public Iterable<City> getAllCities() {
        // This returns a JSON or XML with the users
        return cityRepository.findAll();
    }


    /**
     * 添加一个城市
     *
     * @param name
     * @param countryCode
     * @param district
     * @param population
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/addCity")
    public City cityAdd(@RequestParam("name") String name,
                        @RequestParam("countryCode") String countryCode,
                        @RequestParam("district") String district,
                        @RequestParam("population") Integer population) {
        City city = new City();
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);

        return cityRepository.save(city);
    }

    /**
     * 查询一个城市
     *
     * @param ID
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/findCity/{ID}")
    public City cityFindOne(@PathVariable("ID") Integer ID) {
        return cityRepository.findById(ID).orElse(null);
    }

    /**
     * 删除一个城市
     *
     * @param ID
     */
    @ResponseBody
    @DeleteMapping(value = "/delCity/{ID}")
    public void personDelete(@PathVariable("ID") Integer ID) {
        cityRepository.deleteById(ID);
    }

    /**
     * 更新一个城市
     *
     * @param ID
     * @param name
     * @param countryCode
     * @param district
     * @param population
     * @return
     */
    @ResponseBody
    @PutMapping(value = "/updateCity/{ID}")
    public City personUpdate(@PathVariable("ID") Integer ID,
                             @RequestParam("name") String name,
                             @RequestParam("countryCode") String countryCode,
                             @RequestParam("district") String district,
                             @RequestParam("population") Integer population) {
        City city = new City();
        city.setID(ID);
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);
        return cityRepository.save(city);


    }

    // 全量查询
    @GetMapping(value="/table")
    public String getCityTable(Model model){
        Iterable<City> cityList = cityRepository.findAll();
        model.addAttribute("cityList", cityList);

        return "city-single-table";
    }

}
=======
package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.Entity.City;
import com.mesakiiyui.springdatamysql.Repo.CityRepository;
import com.mesakiiyui.springdatamysql.view.RespModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/City") // This means URL's start with /demo (after Application path)
public class PageController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CityRepository cityRepository;

    // 测试来在p17的respModel
    @ResponseBody
    @RequestMapping(value = "list/callSummaryType", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public RespModel listCallSummaryType(@RequestBody String reqModel) {

        return null;
    }

    @PostMapping(path = "/addOneCity") // Map ONLY POST Requests
    public @ResponseBody
    String addNewCity(@RequestParam String name
            , @RequestParam String countryCode, @RequestParam String district, @RequestParam Integer population) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        City c = new City();
        c.setName(name);
        c.setCountryCode(countryCode);
        c.setDistrict(district);
        c.setPopulation(population);
        cityRepository.save(c);
        return "Saved";
    }

    @ResponseBody
    @GetMapping(path = "/allCity")
    public Iterable<City> getAllCities() {
        // This returns a JSON or XML with the users
        return cityRepository.findAll();
    }


    /**
     * 添加一个城市
     *
     * @param name
     * @param countryCode
     * @param district
     * @param population
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/addCity")
    public City cityAdd(@RequestParam("name") String name,
                        @RequestParam("countryCode") String countryCode,
                        @RequestParam("district") String district,
                        @RequestParam("population") Integer population) {
        City city = new City();
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);

        return cityRepository.save(city);
    }

    /**
     * 查询一个城市
     *
     * @param ID
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/findCity/{ID}")
    public City cityFindOne(@PathVariable("ID") Integer ID) {
        return cityRepository.findById(ID).orElse(null);
    }

    /**
     * 删除一个城市
     *
     * @param ID
     */
    @ResponseBody
    @DeleteMapping(value = "/delCity/{ID}")
    public void personDelete(@PathVariable("ID") Integer ID) {
        cityRepository.deleteById(ID);
    }

    /**
     * 更新一个城市
     *
     * @param ID
     * @param name
     * @param countryCode
     * @param district
     * @param population
     * @return
     */
    @ResponseBody
    @PutMapping(value = "/updateCity/{ID}")
    public City personUpdate(@PathVariable("ID") Integer ID,
                             @RequestParam("name") String name,
                             @RequestParam("countryCode") String countryCode,
                             @RequestParam("district") String district,
                             @RequestParam("population") Integer population) {
        City city = new City();
        city.setID(ID);
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);
        return cityRepository.save(city);


    }

    @GetMapping(value="/table")
    public String getCityTable(Model model){
        Iterable<City> cityList = cityRepository.findAll();
        model.addAttribute("cityList", cityList);

        return "compact-table";
    }

}
>>>>>>> 88753f20a8c6141a51d913abc17cf0994eb3a2b4:SpringDataMySQL/src/main/java/com/mesakiiyui/springdatamysql/controller/PageController.java