
addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}

function login() {
    console.log("11")
    var user_Name = document.getElementById("user_name").value;
    var user_Password = document.getElementById("user_password").value;
    // if(user_Name==""){
    //     alert("请输入用户名！");
    //     return;
    // }

    var obj={
        user_name:user_Name,//这里面定义的变量名要跟数据库里面的字段相同
        user_password:user_Password
    }
    console.log(obj)
    $.ajax({
        url:"http://localhost:8080/popo_war_exploded/user/login",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
        type:"POST",//请求方式是get还是post,我这里用的是post
        contentType:"application/json",
        data:JSON.stringify(obj),//传递的参数
        dataType:"json",
        success:function(data){ //成功返回的回调函数
            if((data).loginInfo == "yes") {
                alert("登陆成功");
				window.localStorage.setItem('user',obj.user_name);
				window.location.href = "http://localhost:8080/popo_war_exploded/index.html";
                //打开新的窗口
                window.open("http://localhost:8080/popo_war_exploded/index.html");
            } else {
                alert("登录失败");
                window.location.href = "http://localhost:8080/popo_war_exploded/login.html";
                //打开新的窗口
                 window.open("http://localhost:8080/popo_war_exploded/login.html");
            }

        }
    });
	/*
	*/


}
