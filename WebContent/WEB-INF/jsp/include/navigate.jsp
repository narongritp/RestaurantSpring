<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.UserBean"%>

<%
	int showMenu = -1;
	int type = -1;
	UserBean user = null;
	if(session.getAttribute(MYKEY.SES_USERLOGIN)!=null){
		user = (UserBean)session.getAttribute(MYKEY.SES_USERLOGIN);
		if(!user.getType().equalsIgnoreCase("-1")){
			out.print("Hi "+user.getUsername()+" // "+user.getType());
			showMenu = 1;
			if(user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN))type=1;
			else if(user.getType().equalsIgnoreCase(MYKEY.USER_RECIEVEORDERS))type=2;
			else if(user.getType().equalsIgnoreCase(MYKEY.USER_COOKER))type=3;
			else if(user.getType().equalsIgnoreCase(MYKEY.USER_WAITRESS))type=4;
			else if(user.getType().equalsIgnoreCase(MYKEY.USER_CASHIER))type=5;
		}else{
			out.print("<font color='red'> "+user.getUsername()+" has been expired! </font>");
		}
	}else{
		out.print("<script>window.location = \"/RestaurantSpring/login\";</script>");
	}
%>