package FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class JsonParse {
    private static String jsonStr = "{\"retCode\":\"1001\",\"ticketList\":\"[{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"酒后代驾\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"1\\\",\\\"startTime\\\":\\\"2019-09-06\\\",\\\"deadline\\\":\\\"2019-09-20\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"0\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"出险代步\\\",\\\"serviceType\\\":\\\"06\\\",\\\"presentSource\\\":\\\"7\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"4848490788245028062948485961\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-12\\\",\\\"deadline\\\":\\\"2019-11-22\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"P17_000d-6644-016e5efb8420\\\",\\\"plateNumber\\\":\\\"LLX21254\\\",\\\"presentCode\\\":\\\"3\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"1229\\\",\\\"presentName\\\":\\\"代为送检测试\\\",\\\"serviceType\\\":\\\"18\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"0\\\",\\\"partnerProductID\\\":\\\"200091\\\",\\\"concaveCode\\\":\\\"4949586757775709787849496668\\\",\\\"price\\\":\\\"40\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-06-20\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"c2abd1a2-08c9-40ef-91df-10fbf7441b1d\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"YXH_AWARD_3941\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"526\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"1229\\\",\\\"presentName\\\":\\\"代为送检测试\\\",\\\"serviceType\\\":\\\"18\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"0\\\",\\\"partnerProductID\\\":\\\"200091\\\",\\\"concaveCode\\\":\\\"5457591757575661795954576668\\\",\\\"price\\\":\\\"40\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-06-20\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"7fda90b4-41bd-4132-ac59-783f7cde1e59\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"YXH_AWARD_3942\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"526\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"1229\\\",\\\"presentName\\\":\\\"代为送检测试\\\",\\\"serviceType\\\":\\\"18\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"0\\\",\\\"partnerProductID\\\":\\\"200091\\\",\\\"concaveCode\\\":\\\"5356552063005999766053566768\\\",\\\"price\\\":\\\"40\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-06-20\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"59e007f5-d7c2-40ef-84ff-4ada2313afd6\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"YXH_AWARD_3943\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"526\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"1229\\\",\\\"presentName\\\":\\\"代为送检测试\\\",\\\"serviceType\\\":\\\"18\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"0\\\",\\\"partnerProductID\\\":\\\"200091\\\",\\\"concaveCode\\\":\\\"5657525775805479780656576868\\\",\\\"price\\\":\\\"40\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-06-20\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"fd4d1722-50de-47df-bfc7-6eeceb46d879\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"YXH_AWARD_3944\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"526\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"1229\\\",\\\"presentName\\\":\\\"代为送检测试\\\",\\\"serviceType\\\":\\\"18\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"0\\\",\\\"partnerProductID\\\":\\\"200091\\\",\\\"concaveCode\\\":\\\"5351465297184738858453516059\\\",\\\"price\\\":\\\"40\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-06-20\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"5e51843e-4acc-4c1f-94ae-630dae67226c\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"YXH_AWARD_3945\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"526\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2017-03-26\\\",\\\"deadline\\\":\\\"2017-04-04\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"LX3212\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-01\\\",\\\"deadline\\\":\\\"2019-11-01\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"LX3212\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2017-03-26\\\",\\\"deadline\\\":\\\"2019-11-01\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"LX3212\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2017-04-25\\\",\\\"deadline\\\":\\\"2019-11-01\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"LX3212\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2017-04-25\\\",\\\"deadline\\\":\\\"2017-05-04\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"LX3212\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-01\\\",\\\"deadline\\\":\\\"2019-11-10\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"LX3212\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381CTP17X112182L\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"酒后代驾\\\",\\\"serviceType\\\":\\\"07\\\",\\\"presentSource\\\":\\\"22\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-09-21\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"\\\",\\\"plateNumber\\\":\\\"沪ASF375\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081M\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"95\\\",\\\"allNum\\\":\\\"100\\\",\\\"registeredDate\\\":\\\"2010-04-27\\\",\\\"seatNum\\\":\\\"5\\\",\\\"carModel\\\":\\\"丰田TV6460GLX-I多用途乘用车\\\",\\\"vin\\\":\\\"LFMJW30F2A0053032\\\",\\\"familyName\\\":\\\"天津一汽丰田RAV4\\\",\\\"vehicleBrand\\\":\\\"天津一汽丰田\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"\\\",\\\"presentName\\\":\\\"金钥匙\\\",\\\"serviceType\\\":\\\"01\\\",\\\"presentSource\\\":\\\"0\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"5610 1376 1289 0530 1377 56102212\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"2\\\",\\\"startTime\\\":\\\"2019-10-08\\\",\\\"deadline\\\":\\\"2019-10-17\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"0009-272d-016daae34447\\\",\\\"plateNumber\\\":\\\"LXX315\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"ASHH381Y1417X119081N\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"4343\\\",\\\"repairCode\\\":\\\"345346\\\",\\\"isStart\\\":\\\"1\\\"},{\\\"presentId\\\":\\\"1230\\\",\\\"presentName\\\":\\\"\\\",\\\"serviceType\\\":\\\"01\\\",\\\"presentSource\\\":\\\"0\\\",\\\"partnerType\\\":\\\"\\\",\\\"partnerProductID\\\":\\\"\\\",\\\"concaveCode\\\":\\\"1024 9335 5202 6300 5993 10250676\\\",\\\"price\\\":\\\"\\\",\\\"status\\\":\\\"0\\\",\\\"startTime\\\":\\\"2019-11-10\\\",\\\"deadline\\\":\\\"2020-10-19\\\",\\\"useTime\\\":\\\"\\\",\\\"endTime\\\":\\\"\\\",\\\"orderId\\\":\\\"0002-606b-016e35b3d40e\\\",\\\"plateNumber\\\":\\\"\\\",\\\"presentCode\\\":\\\"\\\",\\\"policyNo\\\":\\\"\\\",\\\"providerId\\\":\\\"\\\",\\\"userId\\\":\\\"\\\",\\\"mobilePhone\\\":\\\"15021507392\\\",\\\"name\\\":\\\"陆.志豪\\\",\\\"idType\\\":\\\"1001\\\",\\\"idCode\\\":\\\"31011519930524641X\\\",\\\"subServiceType\\\":\\\"\\\",\\\"companyCode\\\":\\\"3010100\\\",\\\"departmentGroupCode\\\":\\\"310100\\\",\\\"frameNo\\\":\\\"\\\",\\\"canUseNum\\\":\\\"1\\\",\\\"allNum\\\":\\\"1\\\",\\\"registeredDate\\\":\\\"\\\",\\\"seatNum\\\":\\\"\\\",\\\"carModel\\\":\\\"\\\",\\\"vin\\\":\\\"\\\",\\\"familyName\\\":\\\"\\\",\\\"vehicleBrand\\\":\\\"\\\",\\\"channelCode\\\":\\\"\\\",\\\"repairCode\\\":\\\"\\\",\\\"isStart\\\":\\\"1\\\"}]\",\"retMessage\":\"success\"}\n";

    public static void main(String[] args) {
        JSONObject jsonObj = JSON.parseObject(jsonStr);

//        String ticketListStr = jsonObj.getString("ticketList");
//        ArrayList<Object> ticketList = JSON.parseObject(ticketListStr, ArrayList.class);
//        for(Object ticketEle : ticketList) {
//            System.out.println(ticketEle);
//        }
    }



}