/*// string parameter null 여부 : null일 때 true return
function gfn_isNull(str) {
    if (str == null) return true;
    if (str == "NaN") return true;
    if (new String(str).valueOf() == "undefined") return true;   
    var chkStr = new String(str);
    if( chkStr.valueOf() == "undefined" ) return true;
    if (chkStr == null) return true;   
    if (chkStr.toString().length == 0 ) return true;  
    return false;
}


// form submit 함수
function ComSubmit(opt_formId) {
    this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
    this.url = "";
     
    if(this.formId == "commonForm"){
        $("#commonForm")[0].reset();
    }
     
    this.setUrl = function setUrl(url){
        this.url = url;
    };
     
    this.addParam = function addParam(key, value){
        $("#"+this.formId).append($("<input type='hidden' name='"+key+"' id='"+key+"' value='"+value+"' >"));
    };
     
    this.submit = function submit(){
        var frm = $("#"+this.formId)[0];
        frm.action = this.url;
        frm.method = "post";
        frm.submit();  
    };
}
*/

function ComSubmit(formId, url){
	$("#" + formId).attr({method : "post", action : url}).submit();
}

function TopMenuMove(url){
	$("#topMenu_Form").attr({method : "post", action : url}).submit();
}

function ComSubmitView(formId, url, view){
	var input = $("<input>").attr("type", "hidden").attr("name", "view").val(view);
	$("#" + formId).attr({method : "post", action : url}).append($(input)).submit();
}