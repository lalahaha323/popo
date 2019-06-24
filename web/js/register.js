function check_email()
{
	var obj = document.getElementById("user_email").value;
    if(obj==""||!/^\w(\w*\.*)*@(\w+\.)+\w{2,4}$/.test(obj))
    {
			document.getElementById("f").innerHTML="<font color='red'>不合法</font>";
            return false;
    } else {
			document.getElementById("f").innerHTML="<font color='red'>合法</font>";
    }
    return true;
}


 function checkUser(){
	 var user = document.getElementById("user_name").value;
  var pattern= /^[a-zA-z]\w{3,15}$/;
  if(!pattern.test(user)){
     document.getElementById("ceshi").innerHTML="<font color='red'>不合法</font>";
                document.getElementById("submit").disabled = true;
  }else{
	 <!-- 输入合法-->
    document.getElementById("ceshi").innerHTML="<font color='white'>合法</font>";
                  document.getElementById("submit").disabled = false;
  }     
}
checkUser(document.getElementById("user_name"));




/*判断两次密码是否相同*/
  function validate() {
              var user_password= document.getElementById("user_password").value;
              var user_password2= document.getElementById("user_password2").value;
		<!-- 对比两次输入的密码 -->
              if(user_password == user_password2) {
                  document.getElementById("tishi").innerHTML="<font color='white'>两次密码相同</font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
              }
          }



addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}

function acquirecode() {
    var user_email= document.getElementById("user_email").value;
    var obj={
        user_email:user_email//这里面定义的变量名要跟数据库里面的字段相同
    }
    $.ajax({
        url:"http://localhost:8080/popo_war_exploded/mail/register",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
        type:"POST",//请求方式是get还是post,我这里用的是post
        contentType:"application/json",
        data:JSON.stringify(obj),//传递的参数
        dataType:"json",

        success:function(data){ //成功返回的回调函数

            console.log(data)
            if((data).mailInfo == "yes") {
                alert("成功获取验证码");
            } else {
                alert("获取验证码失败");
            }
        }
    });
}
function register() {
    var user_name= document.getElementById("user_name").value;
	var user_password= document.getElementById("user_password").value;
	var user_email= document.getElementById("user_email").value;
	var user_securityCode= document.getElementById("user_securityCode").value;

    var obj={
        user_email:user_email,//这里面定义的变量名要跟数据库里面的字段相同
		user_name:user_name,
		user_password:user_password,
		user_securityCode:user_securityCode
    }
    console.log(obj)
    $.ajax({
        url:"http://localhost:8080/popo_war_exploded/user/register",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
        type:"POST",//请求方式是get还是post,我这里用的是post
        contentType:"application/json",
        data:JSON.stringify(obj),//传递的参数
        dataType:"json",
        success:function(data){ //成功返回的回调函数


            if((data).msg == "注册失败") {
                alert("注册失败,用户名重复或者邮箱重复");
				window.location.href = "http://localhost:8080/popo_war_exploded/index.html";
                //打开新的窗口
                window.open("http://localhost:8080/popo_war_exploded/index.html");
            } else if((data).msg == "注册成功" ){
                alert("注册成功");
				window.location.href = "http://localhost:8080/popo_war_exploded/login.html";
                //打开新的窗口
                //window.open("http://localhost:8080/popo_war_exploded/login.html");
            } else {
				alter("验证码不一致");
				window.location.href = "http://localhost:8080/popo_war_exploded/index.html";
                //打开新的窗口
                window.open("http://localhost:8080/popo_war_exploded/index.html");
			}

        }
    });
}
