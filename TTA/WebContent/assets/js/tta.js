var user=new Object();
var nullJsonObj=new Object();
nullJsonObj.na="na";
$(document).ready(function(){
    user = getUser();
    if (user!=null) {
    	loadMain();
    }
    else {
    	loadLogin();
    	return;
    }
    $("body").load(function(){
        var taskId=$.url.param('task');
        

    });
});

function loadTab(tabName){
    if (!$("#"+tabName)[0]){
        appendMainTab(tabName);
    }
    else $("#"+tabName).tab("show");
}

function closeTab(tabName) {
    $("#"+tabName).remove();
}

function loadModal(modalName){
    $("."+modalName).modal();
}

function setActiveSideBar(id){
	$(".nav-sidebar li").removeClass("active");
	$("#"+id).addClass("active");
}

function appendMainTab(tabName,show){
	show = show || true;
    $.get("parts/tab."+tabName+".html",function(data,status){
        if(status=="success") {
            $("#tablist").append(data);
            $('#'+tabName).on('shown.bs.tab', function (e) {
            	setActiveSideBar("li"+this.id);
            });
            if(show) $("#"+tabName).tab('show');
        }
        else
            alert("加载页失败："+tabName);
    });
}

function getUser(){
   var request=new Object();
   request.operation="getUser";
   request.jsonObject=nullJsonObj;
   var resp;
   $.ajax({
       type:"post",
       url:"Gate",
       data:{req:JSON.stringify(request)},
       async:false,
       success:function(data){
            resp=eval('('+data+')');
       }
   });
   if (resp==null) return null;
   return resp.entity;
}

function loadLogin(){
    $("body").load("parts/login.html");
}

function loadMain(){
    $("body").load("main.html");
}

function doLogin() {
    username=$("#username").val();
    password=$("#password").val();
    if (username=="" || password=="")
        alert ("用户名和密码不能为空");
    else {
        var requ= new Object();
        requ.operation="login";
        requ.jsonObject=new Object();
        requ.jsonObject.username=username;
        requ.jsonObject.password=password;
        $.post("Gate",{req:JSON.stringify(requ)},function(data,status){
            if (status=='success'){
                var resp=eval('('+data+')');
                if (resp.status==0)
                    window.location.href="";
                else alert(resp.status+" "+resp.message);
            }
            else {
                alert(status);
            }
        });
    }
}

function logout(){
    requ = new Object();
    requ.operation="logout";
    requ.jsonObject=nullJsonObj;
    $.ajax({
        type:"post",
        url:"Gate",
        data:{req:JSON.stringify(requ)},
        async:false,
        success:function(){
             window.location.href="";
        }
    });
}

function chkJsonStatus(jsonData){
    json=eval('('+jsonData+')');
    if (json.status==100){
        window.location.href="";
    }
    return json.status;
}