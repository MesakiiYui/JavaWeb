

function myFunction(){
    var mySelect = document.getElementById("mySelect");
    var options = mySelect.options;
    console.log("mySelect", mySelect);
    console.log("options", options);
    var selectedIndex = mySelect.selectedIndex;
    var selectedValue = options[selectedIndex].value;
    alert("options.length:"+options.length);
    alert("selectedValue:"+selectedValue);
    var numMap = new Map();
    var charMap = new Map();
    var charRegex = new RegExp('^[A-Za-z]+$');
    var numRegex = new RegExp('^[0-9]*$');
    for(var i = 0; i < options.length; i ++){
        if(charRegex.test(options[i].value)){
            charMap.set(options[i].value, options[i].text);
        }else if(numRegex.test(options[i].value)){
            numMap.set(options[i].value, options[i].text);
        }
    }
    mySelect.innerHTML = "";
    charMap.forEach(function(key, value){
        mySelect.options.add(new Option(key,value));
    });
    numMap.forEach(function(key, value){
        mySelect.options.add(new Option(key,value));
    });
    for(var j = 0; j < options.length; j ++){
        if(selectedValue == options[j].value){
            mySelect[j+1].selected = true;
            break;
        }
    }
}
function changeOrder() {
    var mySelect = document.getElementById("mySelect");
    var options = mySelect.options;
    // 假设选中的是index为3的值
    var ansMap = new Map();
    ansMap.set(options[0].value, options[0].text);
    var targetIndex;
    for(var i = 0; i < options.length; i++){
        if("x" == options[i].value){
            targetIndex = i;
            ansMap.set(options[i].value, options[i].text);
            break;
        }
    }
    for(var i = 0; i < options.length; i++){
        if(i != targetIndex && i != 0){
            ansMap.set(options[i].value, options[i].text);
        }
    }
    mySelect.innerHTML = "";
    ansMap.forEach(function(key, value){
        mySelect.options.add(new Option(key,value));
    });
    mySelect[3].selected = true;
}

function getSelectVal() {
    var mySelect = document.getElementById("mySelect");
    alert(mySelect.value);
}


