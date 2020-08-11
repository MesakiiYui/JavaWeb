package com.mesakiiyui.springdatamysql.common.controller;

import com.mesakiiyui.springdatamysql.common.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path="/AdminLTE")
public class StudentController {

    /**  通过构造器注入---begin  **/
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    /** 通过构造器注入---end  **/
    @GetMapping(value="/index1")
    public String getIndex(Model model){
        return "index";
    }

    @GetMapping(value="/index2")
    public String getIndex2(Model model){
        return "index2";
    }

    @GetMapping(value="/index3")
    public String getIndex3(Model model){
        return "index3";
    }

    @GetMapping(value="/pages/widgets")
    public String getWidgets(Model model){
        return "pages/widgets";
    }

    @GetMapping(value="/pages/layout/top-nav")
    public String getTopNav(Model model){
        return "pages/layout/top-nav";
    }

    @GetMapping(value="/pages/layout/top-nav-sidebar")
    public String getNavSidebar(Model model){
        return "pages/layout/top-nav-sidebar";
    }

    @GetMapping(value="/pages/layout/boxed")
    public String getBoxed(Model model){
        return "pages/layout/boxed";
    }

    @GetMapping(value="/pages/layout/fixed-sidebar")
    public String getFixedSideBar(Model model){
        return "pages/layout/fixed-sidebar";
    }

    @GetMapping(value="/pages/layout/fixed-topnav")
    public String getFixedTopNav(Model model){
        return "pages/layout/fixed-topnav";
    }

    @GetMapping(value="/pages/layout/fixed-footer")
    public String getFixedFooter(Model model){
        return "pages/layout/fixed-footer";
    }

    @GetMapping(value="/pages/layout/collapsed-sidebar")
    public String getCollapsedSidebar(Model model){
        return "pages/layout/collapsed-sidebar";
    }

    @GetMapping(value="/pages/charts/chartjs")
    public String getChartJs(Model model){
        return "pages/charts/chartjs";
    }

    @GetMapping(value="/pages/charts/flot")
    public String getFlot(Model model){
        return "pages/charts/flot";
    }

    @GetMapping(value="/pages/charts/inline")
    public String getInline(Model model){
        return "pages/charts/inline";
    }

    @GetMapping(value="/pages/UI/general")
    public String getGeneral(Model model){
        return "pages/UI/general";
    }

    @GetMapping(value="/pages/UI/icons")
    public String getIcons(Model model){
        return "pages/UI/icons";
    }

    @GetMapping(value="/pages/UI/buttons")
    public String getButtons(Model model){
        return "pages/UI/buttons";
    }

    @GetMapping(value="/pages/UI/sliders")
    public String getSliders(Model model){
        return "pages/UI/sliders";
    }

    @GetMapping(value="/pages/UI/modals")
    public String getModals(Model model){
        return "pages/UI/modals";
    }

    @GetMapping(value="/pages/UI/navbar")
    public String getNavbar(Model model){
        return "pages/UI/navbar";
    }

    @GetMapping(value="/pages/UI/timeline")
    public String getTimeline(Model model){
        return "pages/UI/timeline";
    }

    @GetMapping(value="/pages/UI/ribbons")
    public String getRibbons(Model model){
        return "pages/UI/ribbons";
    }

    @GetMapping(value="/pages/forms/general")
    public String getFormGeneral(Model model){
        return "pages/forms/general";
    }

    @GetMapping(value="/pages/forms/advanced")
    public String getFormAdvanced(Model model){
        return "pages/forms/advanced";
    }

    @GetMapping(value="/pages/forms/editors")
    public String getFormEditors(Model model){
        return "pages/forms/editors";
    }

    @GetMapping(value="/pages/forms/validation")
    public String getFormValidation(Model model){
        return "pages/forms/validation";
    }

    @GetMapping(value="/pages/tables/simple")
    public String getTablesSimple(Model model){
        return "pages/tables/simple";
    }

    @GetMapping(value="/pages/tables/data")
    public String getTablesData(Model model){
        return "pages/tables/data";
    }

    @GetMapping(value="/pages/tables/jsgrid")
    public String getTablesJsgrid(Model model){
        return "pages/tables/jsgrid";
    }

    @GetMapping(value="/pages/calendar")
    public String getCalendar(Model model){
        return "pages/calendar";
    }

    @GetMapping(value="/pages/gallery")
    public String getGallery(Model model){
        return "pages/gallery";
    }

    @GetMapping(value="/pages/mailbox/mailbox")
    public String getMailBox(Model model){
        return "pages/mailbox/mailbox";
    }

    @GetMapping(value="/pages/mailbox/compose")
    public String getCompose(Model model){
        return "pages/mailbox/compose";
    }

    @GetMapping(value="/pages/mailbox/read-mail")
    public String getReadMail(Model model){
        return "pages/mailbox/read-mail";
    }

    @GetMapping(value="/pages/examples/invoice")
    public String getInvoice(Model model){
        return "pages/examples/invoice";
    }

    @GetMapping(value="/pages/examples/profile")
    public String getProfile(Model model){
        return "pages/examples/profile";
    }

    @GetMapping(value="/pages/examples/e_commerce")
    public String getECommerce(Model model){
        return "pages/examples/e_commerce";
    }

    @GetMapping(value="/pages/examples/projects")
    public String getProjects(Model model){
        return "pages/examples/projects";
    }

    @GetMapping(value="/pages/examples/project_add")
    public String getProjectAdd(Model model){
        return "pages/examples/project_add";
    }

    @GetMapping(value="/pages/examples/project_edit")
    public String getProjectEdit(Model model){
        return "pages/examples/project_edit";
    }

    @GetMapping(value="/pages/examples/project_detail")
    public String getProjectDetail(Model model){
        return "pages/examples/project_detail";
    }

    @GetMapping(value="/pages/examples/contacts")
    public String getContacts(Model model){
        return "pages/examples/contacts";
    }

    @GetMapping(value="/pages/examples/login")
    public String getLogin(Model model){
        return "pages/examples/login";
    }

    @GetMapping(value="/pages/examples/register")
    public String getRegister(Model model){
        return "pages/examples/register";
    }

    @GetMapping(value="/pages/examples/forgot-password")
    public String getForgotPassword(Model model){
        return "pages/examples/forgot-password";
    }

    @GetMapping(value="/pages/examples/recover-password")
    public String getRecoverPassword(Model model){
        return "pages/examples/recover-password";
    }

    @GetMapping(value="/pages/examples/lockscreen")
    public String getLockScreen(Model model){
        return "pages/examples/lockscreen";
    }

    @GetMapping(value="/pages/examples/legacy-user-menu")
    public String getLegacyUserMenu(Model model){
        return "pages/examples/legacy-user-menu";
    }

    @GetMapping(value="/pages/examples/language-menu")
    public String getLanguageMenu(Model model){
        return "pages/examples/language-menu";
    }

    @GetMapping(value="/pages/examples/404")
    public String get404(Model model){
        return "pages/examples/404";
    }

    @GetMapping(value="/pages/examples/500")
    public String get500(Model model){
        return "pages/examples/500";
    }

    @GetMapping(value="/pages/examples/pace")
    public String getPace(Model model){
        return "pages/examples/pace";
    }

    @GetMapping(value="/pages/examples/blank")
    public String getBlank(Model model){
        return "pages/examples/blank";
    }

    @GetMapping(value="/pages/examples/starter")
    public String getStarter(Model model){
        return "starter";
    }





}
