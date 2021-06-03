$(function () {
    $.getJSON("./../data/interviewJVM.json", function (data) {
        console.log("data", data);
        var $jsontipJVM = $("#jvmContent");
        var strHtmlJVM = "";//存储数据的变量
        $jsontipJVM.empty();//清空内容
        var jvmIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'jvm'){
                jvmIndex += 1;
                strHtmlJVM += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+ jvmIndex+"\">" +
                    jvmIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+jvmIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipJVM.html(strHtmlJVM);//显示处理后的数据
    });

    $.getJSON("./../data/interviewNetWork.json", function (data) {
        console.log("data", data);
        var $jsontipNetWork = $("#newWWorkContent");
        var strHtmlNetWork = "";//存储数据的变量
        $jsontipNetWork.empty();//清空内容
        var netWorkIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'network'){
                netWorkIndex += 1;
                strHtmlNetWork += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+ netWorkIndex+"\">" +
                    netWorkIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+netWorkIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipNetWork.html(strHtmlNetWork);//显示处理后的数据
    });

    $.getJSON("./../data/interviewDS.json", function (data) {
        console.log("data", data);
        var $jsontipDataStruct = $("#dataStructContent");
        var strHtmlDataStruct = "";//存储数据的变量
        $jsontipDataStruct.empty();//清空内容
        var dataStructIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'dataStruct'){
                dataStructIndex += 1;
                strHtmlDataStruct += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+ dataStructIndex+"\">" +
                    dataStructIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+dataStructIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipDataStruct.html(strHtmlDataStruct);//显示处理后的数据
    });

    $.getJSON("./../data/interviewAlgorithm.json", function (data) {
        console.log("data", data);
        var $jsontipAlgorithm = $("#algorithmContent");
        var strHtmlAlgorithm = "";//存储数据的变量
        $jsontipAlgorithm.empty();//清空内容
        var algorithmIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'algorithm'){
                algorithmIndex += 1;
                strHtmlAlgorithm += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+ algorithmIndex+"\">" +
                    algorithmIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+algorithmIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipAlgorithm.html(strHtmlAlgorithm);//显示处理后的数据
    });

    $.getJSON("./../data/interviewDataBase.json", function (data) {
        console.log("data", data);
        var $jsontipDataBase = $("#dataBaseContent");
        var strHtmlDataBase = "";//存储数据的变量
        $jsontipDataBase.empty();//清空内容
        var dataBaseIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'dataBase'){
                dataBaseIndex += 1;
                strHtmlDataBase += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+dataBaseIndex+"\">" +
                    dataBaseIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+dataBaseIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipDataBase.html(strHtmlDataBase);//显示处理后的数据
    });

    $.getJSON("./../data/interviewSpring.json", function (data) {
        console.log("data", data);
        var $jsontipSpring = $("#springContent");
        var strHtmlSpring = "";//存储数据的变量
        $jsontipSpring.empty();//清空内容
        var springIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'spring'){
                springIndex += 1;
                strHtmlSpring += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+springIndex+"\">" +
                    springIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+springIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipSpring.html(strHtmlSpring);//显示处理后的数据
    });

    $.getJSON("./../data/interviewJavaBasic.json", function (data) {
        console.log("data", data);
        var $jsontipJavaBasic = $("#javaBasicContent");
        var strHtmlJavaBasic = "";//存储数据的变量
        $jsontipJavaBasic.empty();//清空内容
        var javaBasicIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'javaBasic'){
                javaBasicIndex += 1;
                strHtmlJavaBasic += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+javaBasicIndex+"\">" +
                    javaBasicIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+javaBasicIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipJavaBasic.html(strHtmlJavaBasic);//显示处理后的数据
    });

    $.getJSON("./../data/interviewAnnotation.json", function (data) {
        console.log("data", data);
        var $jsontipAnnotation = $("#annotationContent");
        var strHtmlAnnotation = "";//存储数据的变量
        $jsontipAnnotation.empty();//清空内容
        var annotationIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'annotation'){
                annotationIndex += 1;
                strHtmlAnnotation += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+annotationIndex+"\">" +
                    annotationIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+annotationIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipAnnotation.html(strHtmlAnnotation);//显示处理后的数据
    });

    $.getJSON("./../data/interviewMq.json", function (data) {
        console.log("data", data);
        var $jsontipMq = $("#mqContent");
        var strHtmlMq = "";//存储数据的变量
        $jsontipMq.empty();//清空内容
        var mqIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'mq'){
                mqIndex += 1;
                strHtmlMq += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+mqIndex+"\">" +
                    mqIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+mqIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipMq.html(strHtmlMq);//显示处理后的数据
    });

    $.getJSON("./../data/interviewConcurrency.json", function (data) {
        console.log("interviewConcurrency", data);
        var $jsontipConcurrency = $("#concurrencyContent");
        var strHtmlConcurrency = "";//存储数据的变量
        $jsontipConcurrency.empty();//清空内容
        var concurrencyIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'concurrency'){
                concurrencyIndex += 1;
                strHtmlConcurrency += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+concurrencyIndex+"\">" +
                    concurrencyIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+concurrencyIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\">" +
                    info.ans +
                    "</div></div></div></br>"
            }
        });
        $jsontipConcurrency.html(strHtmlConcurrency);//显示处理后的数据
    });

    $.getJSON("./../data/interviewSql.json", function (data) {
        console.log("sqldata", data);
        var $jsontipSql = $("#sqlContent");
        var strHtmlSql = "";//存储数据的变量
        $jsontipSql.empty();//清空内容
        var SqlIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'sql'){
                SqlIndex += 1;
                strHtmlSql += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse"+ SqlIndex+"\">" +
                    SqlIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+SqlIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\"><pre>" +
                    info.ans +
                    "</pre></div></div></div></br>"
            }
        });
        $jsontipSql.html(strHtmlSql);//显示处理后的数据
    }); 
    
    $.getJSON("./../data/interviewJavaBasicSkill.json", function (data) {
        console.log("data", data);
        var $jsontipJavaBasicSkill = $("#javaBasicSkillContent");
        var strHtmlJavaBasicSkill = "";//存储数据的变量
        $jsontipJavaBasicSkill.empty();//清空内容
        var JavaBasicSkillIndex = 0;
        $.each(data, function (index, info) {
            console.log(index, info);
            if(info.category === 'javaBasicSkill'){
                JavaBasicSkillIndex += 1;
                strHtmlJavaBasicSkill += "<div class=\"card\">" +
                    "<a class=\"card-link\" data-toggle=\"collapse\"   href=\"#collapse"+ JavaBasicSkillIndex+"\">" +
                    JavaBasicSkillIndex + ".  " + info.qes +
                    "</a>" +
                    "</div>" +
                    "<div id=\"collapse"+JavaBasicSkillIndex+"\" class=\"collapse\" data-parent=\"#accordion\">" +
                    "<div class=\"card-body\"><pre style='font-size: 13px'>" +
                    info.ans +
                    "</pre></div></div></div></br>"
            }
        });
        $jsontipJavaBasicSkill.html(strHtmlJavaBasicSkill);//显示处理后的数据
    });

})