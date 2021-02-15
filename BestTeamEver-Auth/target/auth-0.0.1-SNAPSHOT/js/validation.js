
function switchOff(onOff,input,errSelector,message){
    if(onOff == false){
        $(errSelector).text(message);
        $(input).addClass("error_input");
        $(errSelector).addClass("error_message");
    }else{
        $(errSelector).text("");
        $(input).removeClass("error_input");
        $(errSelector).removeClass("error_message");
    }
}

function checkEmpty(input,errSelector){
    var val = $(input).val();
    if($.trim(val) == ""){
        switchOff(false,input,errSelector,"The input can not be empty");
        return false;
    }else{
        switchOff(true,input,errSelector);
        return true;
    }   
}

function checkLength(input,errSelector) {
    if(!checkEmpty(input,errSelector)){
        return false;
    }else{
        var val = $(input).val();
        if (val.length < 6) {
            switchOff(false, input, errSelector, "Password has at least 6 chacters");
            return false;
        }else{
            switchOff(true, input, errSelector);
            return true;
        }
    }
}

function checkPassword(input, input2, errSelector) {
    if (!checkLength(input, errSelector)) {
        return false;
    }else{
        var val1 = $(input).val();
        var val2 = $(input2).val();
        if (val1 !== val2) {
            switchOff(false, input, errSelector, "The Password You Entered does not match");
            return false;
        }else{
            switchOff(true, input, errSelector);
            return true;
        }
    }
}
function checkDateOfBirth(input, errSelector){
    if (!checkEmpty(input, errSelector)) {
        return false;
    }else{
        var val = $(input).val();
        var regex = /^(?:0[1-9]|[12]\d|3[01])([\/.-])(?:0[1-9]|1[012])\1(?:19|20)\d\d$/;
        if (!regex.test(val)) {
            switchOff(false, input, errSelector, "This date of birth is not valid");
            return false;
        }else{
            switchOff(true, input, errSelector);
            return true;
        }
    }
}


function checkPhoneNumber(input, errSelector){
    if (!checkEmpty(input, errSelector)) {
        return false;
    }else{
        var val = $(input).val();
        var regex = /^\D?(\d{3})\D?\D?(\d{3})\D?(\d{4})$/;
        if (!regex.test(val)) {
            switchOff(false, input, errSelector, "This phone number is not valid");
            return false;
        }else{
            switchOff(true, input, errSelector);
            return true;
        }
    }
}

function checkEmail(input, errSelector) {
    if (!checkEmpty(input, errSelector)) {
        return false;
    }else{
        var val = $(input).val();
        var regex = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if (!regex.test(val)) {
            switchOff(false, input, errSelector, "This email address does not valid");
            return false;
        }else{
            switchOff(true, input, errSelector);
            return true;
        }
    }
}


function checkPrice(input, errSelector){
    if(!checkEmpty(input,errSelector)){
        return false;
    }else{
        var val = $(input).val();
        var regex = /^[1-9]\d*.\d{2}$/;
        if(!regex.test(val)){
            switchOff(false,input,errSelector,"价格必须是只含两位小数的正数");
            return false;
        }else{
            switchOff(true,input,errSelector);
            return true;
        }        
    }    
}

function checkFile(input,errSelector){
    if(!checkEmpty(input,errSelector)){
        return false; 
    }
    var val = $(input).val().toLowerCase();
    if(val.length < 4){
        switchOff(false,input,errSelector,"请选择有效图片");
        return false;   
    }
    
    var suffix = val.substring(val.length-3);
    
    if( suffix =="jpg" || suffix == "png" ||suffix=="gif"){
        switchOff(true,input,errSelector);
        return true;        
    }else{
        switchOff(false,input,errSelector,"请选择有效图片");
        return false;         
    }
}

function checkId(input,errSelector){
    if(!checkEmpty(input,errSelector)){
        return false;
    }    
    var val = $(input).val();
    var regex = /^[1-9]\d*$/;
    if(!regex.test(val)){
        switchOff(false,input,errSelector,"ID只可以为正整数");
        return false;
    }else{
        switchOff(true,input,errSelector);
        return true;
    }
}

function checkCategoryId(input,errSelector){
    if(!checkEmpty(input,errSelector)){
        return false; 
    }    
    var val = $(input).val();
    var regex = /^[1-9]\d*$/;
    if(!regex.test(val)){
        switchOff(false, input,errSelector,"Id必须为正整数");
        return false;
    }else{
        switchOff(true,input,errSelector);
        return true;
    }
}




