<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.UserBean"%>
<%
	int type = -1;
	UserBean user = null;
	if(session.getAttribute(MYKEY.SES_USERLOGIN)!=null){
		user = (UserBean)session.getAttribute(MYKEY.SES_USERLOGIN);
		if(user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN))type=1;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_RECIEVEORDERS))type=2;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_COOKER))type=3;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_WAITRESS))type=4;
		else if(user.getType().equalsIgnoreCase(MYKEY.USER_CASHIER))type=5;
		
		out.print(user.getUsername()+" : ");
		out.print("<a href='/RestaurantSpring/'>");
		out.print("<button>Home</button></a>&nbsp;&nbsp;");
		if(type==1){
			out.print("<br><br><strong>Admin : </strong>");
			out.print("<a href='/RestaurantSpring/admin/manage-user'>");
			out.print("<button>Manage User</button></a>&nbsp;&nbsp;");
			out.print("<a href='/RestaurantSpring/admin/manage-foodmenu'>");
			out.print("<button>Manage Food</button></a>&nbsp;&nbsp;");
			out.print("<a href='/RestaurantSpring/order-manage/view-listorder'>");
			out.print("<button>Manage Order</button></a>&nbsp;&nbsp;");
		}
		else if(type==1||type==2){
			out.print("<br><br><strong>Recieve Orders : </strong>");
			out.print("<a href='/RestaurantSpring/order-manage/manage-order'>");
			out.print("<button>View Order Session</button></a>&nbsp;&nbsp;");
			
		}
		else if(type==1||type==3){
			out.print("<br><br><strong>Cooker : </strong>");
			out.print("<a href='/RestaurantSpring/cooker/view-orderlist'>");
			out.print("<button>View List Order</button></a>&nbsp;&nbsp;");
		}
		else if(type==1||type==4){
			out.print("<br><br><strong>Waitress : </strong>");
			out.print("<a href='/RestaurantSpring/waitress/view-orderlist'>");
			out.print("<button>View List Order</button></a>&nbsp;&nbsp;");
		}
		else if(type==1||type==5){
			out.print("<br><br><strong>Cashier : </strong>");
			out.print("<a href='/RestaurantSpring/cashier/view-orderlist'>");
			out.print("<button>View List Order</button></a>&nbsp;&nbsp;");
		}
	}else{
		out.print("<script>alert(\"Please Login!\");window.location = \"/RestaurantSpring/login\";</script>");
	}
%>
