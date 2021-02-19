

function myFunction(){
    var mySelect = document.getElementById("mySelect");
    var options = mySelect.options;
    console.log("mySelect", mySelect);
    console.log("options", options);
    var selectedIndex = mySelect.selectedIndex;
    var selectedValue = options[selectedIndex].value;
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


