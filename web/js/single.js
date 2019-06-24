addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}

function sendemail1() {
    var user_name = document.getElementById("user_name").value;
    var user_email = document.getElementById("user_email").value;
    var user_subject = document.getElementById("user_subject").value;
    var user_message = document.getElementById("user_message").value;
    var obj={
        user_name:user_name,
        user_email:user_email,
        user_subject:user_subject,
        user_message:user_message
    }
    console.log(obj)
    $.ajax({
        url:"http://localhost:8080/popo_war_exploded/mail/send",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
        type:"POST",//请求方式是get还是post,我这里用的是post
        contentType:"application/json",
        data:JSON.stringify(obj),//传递的参数
        dataType:"json",
        success:function(data){ //成功返回的回调函数
            console.log(data.msg);
            if((data).msg == "yes") {
                alert("发送邮件成功");
                window.location.href = "http://localhost:8080/popo_war_exploded/index.html";
                //打开新的窗口
                window.open("http://localhost:8080/popo_war_exploded/index.html");
            } else {
                alert("发送失败");
                window.location.href = "http://localhost:8080/popo_war_exploded/index.html";
                //打开新的窗口
                window.open("http://localhost:8080/popo_war_exploded/index.html");
            }

        }
    });
}
