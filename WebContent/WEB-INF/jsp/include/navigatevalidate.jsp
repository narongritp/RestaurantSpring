<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.UserBean"%>
<%
	
	if(session.getAttribute(MYKEY.SES_USERLOGIN)!=null){
		UserBean user = (UserBean)session.getAttribute(MYKEY.SES_USERLOGIN);
		out.print(user.getUsername()+" : ");
		out.print("<a href='/RestaurantSpring/'>");
		out.print("<button>Home</button></a>&nbsp;&nbsp;");
		if(user.getType().equalsIgnoreCase(MYKEY.USER_RECIEVEORDERS)||
				user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN)){
			out.print("<a href='/RestaurantSpring/order-manage/manage-order'>");
			out.print("<button>View Order Session</button></a>&nbsp;&nbsp;");
		}
		if(user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN)){
			
		}
		if(user.getType().equalsIgnoreCase(MYKEY.USER_COOKER)||
				user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN)){
			
		}
		if(user.getType().equalsIgnoreCase(MYKEY.USER_WAITRESS)||
				user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN)){
			
		}
	}else{
		out.print("<script>alert(\"Please Login!\");window.location = \"/RestaurantSpring/\";</script>");
	}
%>
