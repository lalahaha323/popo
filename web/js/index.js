addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}

function showBread() {
    var obj={

    }
    $.ajax({
        url:"http://localhost:8080/popo_war_exploded/buybread/show",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
        type:"POST",//请求方式是get还是post,我这里用的是post
        contentType:"application/json",
        data:JSON.stringify(obj),//传递的参数
        dataType:"json",
        success:function(data){ //成功返回的回调函数
            console.log(data);
            window.localStorage.setItem('tianpin',JSON.stringify(data));
            window.location.href = "http://localhost:8080/popo_war_exploded/tianpin.html";
           window.open("http://localhost:8080/popo_war_exploded/tianpin.html");
        }
    });
}
