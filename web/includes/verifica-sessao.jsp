<%
    if(request.getSession().getAttribute("status_login") == null ||
            !request.getSession().getAttribute("status_login").equals("ok")){
        session.removeAttribute("status_login");
        response.sendRedirect("./index.jsp");
    }
%>