package utils.csvReader;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @Author: jintienan
 * @Date: 2021/1/18 10:24
 */
@Slf4j
public class CSVReader {

    private void reader() throws Exception{
        try {
            // open file to read
            Scanner scanner = new Scanner(new File("D:\\data.txt"));
            File finalSqlFile = new File("D:\\finalSqlFile.sql");
            FileOutputStream finalSqlFileOS = new FileOutputStream(finalSqlFile);
            OutputStreamWriter finalSqlFileOSWriter = new OutputStreamWriter(finalSqlFileOS);
            // read until end of file (EOF)
            while (scanner.hasNextLine()) {
                String lineEle = scanner.nextLine();
                log.info(lineEle);
                String[] lineEleArr = lineEle.split("\\t");
                // INSERT INTO T_ACC_GOV_HOSPITAL
                //(hospital_id, hospital_code, hospital_name, city_name, district_name, hospital_level, hospital_rank, crt_user_id, crt_dttm, lastupt_user_id, lastupt_dttm, enable_flg)
                //VALUES
                //(SEQ_ACC_GOV_HOSPITAL_ID.NEXTVAL,null,null, null, null, null,null, -1, SYSDATE, SYSDATE, -1, '1');
                StringBuilder finalString = new StringBuilder();
                finalString.append("INSERT INTO T_ACC_GOV_HOSPITAL ");
                finalString.append("(hospital_id, hospital_code, hospital_name, province_name, city_name, district_name, hospital_level, hospital_rank, crt_user_id, crt_dttm, lastupt_user_id, lastupt_dttm, enable_flg)");
                finalString.append("VALUES");
                finalString.append("(SEQ_ACC_GOV_HOSPITAL_ID.NEXTVAL");// id
                finalString.append(",'");
                insertJudge(finalString, lineEleArr[0]);// code
                finalString.append("','");
                insertJudge(finalString, lineEleArr[1]);// code
                finalString.append("','");
                insertJudge(finalString, lineEleArr[2]);// code
                finalString.append("','");
                insertJudge(finalString, lineEleArr[3]);// code// city
                finalString.append("','");
                insertJudge(finalString, lineEleArr[4]);// code// district
                finalString.append("','");
                insertJudge(finalString, lineEleArr[5]);// code// 123
                finalString.append("','");
                insertJudge(finalString, lineEleArr[6]);// code// 甲乙丙
                finalString.append("',-1,SYSDATE,-1,SYSDATE,'1');");

                log.info("插入的数据为："+JSON.toJSONString(finalString.toString()));
                finalSqlFileOSWriter.write(finalString.toString());
                String newLine = System.getProperty("line.separator");
                finalSqlFileOSWriter.write(newLine);
            }

            // close the scanner
            scanner.close();
            finalSqlFileOSWriter.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            log.info(JSON.toJSONString(ex));
        }
    }

    private static void insertJudge(StringBuilder sb, String target){
        if("null".equals(target)){
            log.info("得到空值");
        }else{
            sb.append(target);
        }
    }

    public static void main(String[] rags)throws Exception{
        log.info("开始加载数据！");
        CSVReader csvReader = new CSVReader();
        try{
            csvReader.reader();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            log.info(JSON.toJSONString(ex));
        }

    }
}
