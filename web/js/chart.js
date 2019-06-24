
//加入购物车=================================================
//调用此函数时传入了this,声明参数来接收它,参数名不能叫this(关键字)
function add_shoppingcart(btn){
    //获取按钮的爷爷
    var tr = btn.parentNode.parentNode;
    //获取tr的所有孩子(tds)
    var tds = tr.getElementsByTagName("td");
    //获取第1个td的内容(商品名)
    var name = tds[0].innerHTML;
    //获取第2个td的内容(单价)
    var price = tds[1].innerHTML;
    //创建一个新的tr,设置内容,追加到tbody下
    var newtr = document.createElement("tr");
    newtr.innerHTML = '<td>'+name+'</td>'+
        '<td>'+price+'</td><td align="center">'+
        '<input type="button" value="-" onclick="decrease(this);"/> '+
        '<input type="text" size="3" readonly value="1"/> '+
        '<input type="button" value="+" onclick="increase(this);"/>'+
        '</td>'+
        '<td>'+price+'</td>'+
        '<td align="center"><input type="button" value="x" onclick="drop(this);"/></td>';//添加删除事件
    var tbody = document.getElementById("goods");
    tbody.appendChild(newtr);
    sum();
}
//加法 数量不能大于库存========================================
function increase(btn){
    //获取按钮的父亲
    var td2 = btn.parentNode;
    //获取td2内的文本框
    var text = td2.getElementsByTagName("input")[1];
    //获取文本框内值+1后写回文本框
    var amount = text.value;
    text.value = ++amount;
    //获取td2的哥哥td1,从中取出单价
    var td1 = td2.parentNode.getElementsByTagName("td")[1];
    var price = td1.innerHTML;
    //计算金额
    var mny = price*amount;
    //获取td2的弟弟td3,将金额写回td3
    var td3 = td2.parentNode.getElementsByTagName("td")[3];
    td3.innerHTML = mny;
    sum();
}
//减法 数量不能小于1 =================================================
function decrease(btn){
    //获取按钮的父亲td2
    var td2 = btn.parentNode;
    //获取td2的文本框
    var text = td2.getElementsByTagName("input")[1];
    //获取文本框的值-1写回文本框
    var amount = text.value;
    if(amount<1){
        text.value = 0;
    }
    if(amount>0){
        text.value = --amount;
    }
    //获取td2的哥哥td1,从中取回单价
    var td1 = td2.parentNode.getElementsByTagName("td")[1];
    var price = td1.innerHTML;
    //计算金额
    var mny = price*amount;
    //获取td2的弟弟td3,将金额写入td3
    var td3 = td2.parentNode.getElementsByTagName("td")[3];
    td3.innerHTML = mny;
    sum();
}
//删除tr行,而不是删除tr行中所有td====================
function drop(btn){
    var tr = btn.parentNode.parentNode;
    var tbody = document.getElementById("goods");
    tbody.removeChild(tr);
    sum();
}
//计算总金额
function sum() {
    //获取购物车内所有的数据行
    var tbody =
        document.getElementById("goods");
    var trs =
        tbody.getElementsByTagName("tr");
    //遍历这些行
    var s = 0;
    for(var i=0;i<trs.length;i++) {
        //获取每一行下第4个td的内容(金额)
        var mny =
            trs[i].getElementsByTagName("td")[3].innerHTML;
        //累加
        s += parseFloat(mny);
    }
    //将合计值写入合计列(id="total")
    var td =
        document.getElementById("total");
    td.innerHTML = s;
}
addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}