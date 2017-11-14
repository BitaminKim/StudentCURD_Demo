<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//Dtr HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtr">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


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
    var updateform = document.getElementById("updateform");   
    for(var i=0;i<updateform.length;i++){               
          if(updateform.elements[i].value==""){         
                alert(updateform.elements[i].title+"不能为空！");
                updateform.elements[i].focus();             
                return ;
          }
    }
    updateform.submit();
}
window.onload=function(){
	var str="${user.likesome}";
	var like = str.split(",");
	for(var i=0;i<like.length;i++){
		$("[value = "+like[i]+"]:checkbox").attr("checked", true);
	}
} 

</script>

</head>
<body>
<form id="updateform" action="UpdateStudent" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${user.id}"/>
<table>
<tr><td>姓名</td><td><input title="姓名" id="name" name="name" type="text" value="${user.name}"></td></tr>
<tr><td>性别</td><td>
<c:if test="${user.sex=='男'}">
<input type="radio" name="sex" value="男" checked="true"/>男
<input type="radio" name="sex" value="女"/>女 
</c:if>
<c:if test="${user.sex=='女'}">
<input type="radio" name="sex" value="男"/>男
<input type="radio" name="sex" value="女" checked="true" />女
</c:if>
</td></tr>
<tr><td>出生日期</td><td><input id="birthday" title="出生日期" type="date" name="birthday" value="${user.birthday}"></td></tr>
<tr><td>照片</td><td><input id="pic" title="照片" name="pic" type="file" value="${user.pic}"></td></tr>
<tr><td>兴趣爱好</td><td>
<input id="football" type="checkbox" name="like" value="足球"><label for="football">足球 </label>   
<input id="paiball" type="checkbox" name="like" value="排球"> <label for="paiball">排球</label>   
<input id="baskball" type="checkbox" name="like" value="篮球"> <label for="baskball">篮球</label>   
<input id="ppball" type="checkbox" name="like" value="兵乓球"> <label for="ppball">兵乓球</label>   
<input id="music" type="checkbox" name="like" value="音乐"> <label for="music">音乐</label>   
<input id="dance" type="checkbox" name="like" value="舞蹈"> <label for="dance">舞蹈</label>   
<input id="likesome" type="hidden" name="likesome" value=""/>
</td></tr>

<tr><td>联系电话</td><td><input id="phone" title="联系电话" name="phone" type="text" value="${user.phone}"></td></tr>
<tr><td>家庭地址</td><td><input id="address" title="家庭地址" name="address" type="text" value="${user.address}"></td></tr>
<tr><td>自我介绍</td><td><textarea id="aboutme" title="自我介绍" name="aboutme" rows="10" cols="50">${user.aboutme}</textarea></td></tr>
<tr><td></td><td><input type="button" value="修改" onclick="check()"/></td></tr>

</table>
</form>
</body>

</html>