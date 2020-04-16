package test.com.mesakiiyui.springdatamysql.service.impl; 

import com.mesakiiyui.springdatamysql.Entity.Student;
import com.mesakiiyui.springdatamysql.SpringdatamysqlApplication;
import com.mesakiiyui.springdatamysql.service.StudentManageService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* StudentManageServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 19, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringdatamysqlApplication.class)
public class StudentManageServiceImplTest {

    @Autowired
    StudentManageService studentManageService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     *
     * Method: findStudentNoCriteria(Integer page, Integer size)
     *
     */
    @Test
    public void testfindStudentById() throws Exception {

        Page<Student> pageStudent = studentManageService.findStudentById(0,3, 901);
        System.out.println("hello");
        //TODO: Test goes here...
    }


    /**
    *
    * Method: findStudentNoCriteria(Integer page, Integer size)
    *
    */
    @Test
    public void testFindStudentNoCriteria() throws Exception {

        Page<Student> pageStudent = studentManageService.findStudentNoCriteria(0,4);
        System.out.println("hello");
    //TODO: Test goes here...
    }

    /**
    *
    * Method: findStudentCriteria(Integer page, Integer size, StudentQuery studentQuery)
    *
    */
    @Test
    public void testFindStudentCriteria() throws Exception {
    //TODO: Test goes here...
    }


} 
