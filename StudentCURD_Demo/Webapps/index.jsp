<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtr HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtr">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生管理系统</title>
<script type="text/javascript">
function check(){
    var r=document.getElementsByName("like");  
    var likestr="";
    for(var i=0;i<r.length;i++){
        if(r[i].checked){
        	if(i==(r.length-1)){
        		likestr+=r[i].value;
        	}else{
        		likestr+=r[i].value+",";
        	}
       	}
    }
    document.getElementById("likesome").value=likestr;
    
    var saveform = document.getElementById("saveform");   
    for(var i=0;i<saveform.length;i++){               
          if(saveform.elements[i].value==""){         
                alert(saveform.elements[i].title+"不能为空！");
                saveform.elements[i].focus();             
                return ;
          }
    }
    
    saveform.submit();
}
window.onload=function(){
	    
} 
</script>
</head>
<body>
<form id="saveform" action="SaveStudent" method="post" enctype="multipart/form-data">
<table>
<tr><td>姓名</td><td><input id="name" title="姓名" name="name" type="text" ></td></tr>
<tr><td>性别</td><td>
<input type="radio" id="famale" name="sex" value="男" checked="true"/><label for="famale">男 </label> 
<input type="radio" id="male" name="sex" value="女"/><label for="male">女 </label> 
</td></tr>
<tr><td>出生日期</td><td><input id="birthday" title="出生日期" type="date" value="2017-11-13" name="birthday"></td></tr>
<tr><td>照片</td><td><input id="pic" title="照片" name="pic" type="file" ></td></tr>
<tr><td>兴趣爱好</td><td>
<input id="football" type="checkbox" name="like" value="足球"><label for="football">足球 </label>   
<input id="paiball" type="checkbox" name="like" value="排球"> <label for="paiball">排球</label>   
<input id="baskball" type="checkbox" name="like" value="篮球"> <label for="baskball">篮球</label>   
<input id="ppball" type="checkbox" name="like" value="兵乓球"> <label for="ppball">兵乓球</label>   
<input id="music" type="checkbox" name="like" value="音乐"> <label for="music">音乐</label>   
<input id="dance" type="checkbox" name="like" value="舞蹈"> <label for="dance">舞蹈</label>
<input id="likesome" type="hidden" name="likesome" value=""/>
</td></tr>

<tr><td>联系电话</td><td><input id="phone" title="联系电话" name="phone" type="text" ></td></tr>
<tr><td>家庭地址</td><td><input id="address" title="家庭地址" name="address" type="text" ></td></tr>
<tr><td>自我介绍</td><td><textarea id="aboutme" title="自我介绍" name="aboutme" rows="10" cols="50"></textarea></td></tr>
<tr><td></td><td><input type="button" value="保存" onclick="check()"/></td></tr>
</table>
</form>
</body>
</html>