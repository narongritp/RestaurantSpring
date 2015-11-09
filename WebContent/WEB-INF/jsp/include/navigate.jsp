<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.UserBean"%>
<%
	
	if(session.getAttribute(MYKEY.SES_USERLOGIN)!=null){
		UserBean user = (UserBean)session.getAttribute(MYKEY.SES_USERLOGIN);
		out.print(user.getUsername()+" is logged in!");
	}else{
		out.print("not log in");
	}
%>