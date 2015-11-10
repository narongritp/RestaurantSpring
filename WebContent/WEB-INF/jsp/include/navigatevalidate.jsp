<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.UserBean"%>
<%
	int type = -1;
	UserBean user = null;
	if(session.getAttribute(MYKEY.SES_USERLOGIN)!=null){
		if(user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN))type=1;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_RECIEVEORDERS))type=2;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_COOKER))type=3;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_WAITRESS))type=4;
		user = (UserBean)session.getAttribute(MYKEY.SES_USERLOGIN);
		out.print(user.getUsername()+" : ");
		out.print("<a href='/RestaurantSpring/'>");
		out.print("<button>Home</button></a>&nbsp;&nbsp;");
		if(type==1||type==2){
			out.print("<a href='/RestaurantSpring/order-manage/manage-order'>");
			out.print("<button>View Order Session</button></a>&nbsp;&nbsp;");
		}
		if(type==1){
			
		}
		if(type==1||type==3){
			out.print("<a href='/RestaurantSpring/cooker/manage-order'>");
			out.print("<button>View Order Session</button></a>&nbsp;&nbsp;");
		}
		if(type==1||type==4){
			
		}
	}else{
		out.print("<script>alert(\"Please Login!\");window.location = \"/RestaurantSpring/\";</script>");
	}
%>
