/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-11 03:52:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nvdevelopers.dto.UserDetails;
import java.util.Iterator;
import java.util.List;
import com.nvdevelopers.service.FetchRecordsService;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Staff Leave Management System Admin</title>\n");
      out.write("\t<style>\n");
      out.write("\t\tbody {font-family: \"Lato\", sans-serif;}\n");
      out.write("\t\t\n");
      out.write("\t\t/* Style the tab */\n");
      out.write("\t\tdiv.tab {\n");
      out.write("\t\t\toverflow: hidden;\n");
      out.write("\t\t\tborder: 1px solid #ccc;\n");
      out.write("\t\t\tbackground-color: #f1f1f1; \n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t/* Style the buttons inside the tab*/\n");
      out.write("\t\tdiv.tab button {\n");
      out.write("\t\t\tbackground-color: inherit;\n");
      out.write("\t\t\tfloat: left;\n");
      out.write("\t\t\tborder: none;\n");
      out.write("\t\t\toutline: none;\n");
      out.write("\t\t\tcursor: pointer;\n");
      out.write("\t\t\tpadding: 14px 16px;\n");
      out.write("\t\t\ttransition: 0.3s;\n");
      out.write("\t\t\tfont-size: 17px;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t/*Change the background color of buttons on hover*/\n");
      out.write("\t\tdiv.tab button:hover {\n");
      out.write("\t\t\tbackground-color: #ddd;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t/*Create an active/current tablink class*/\n");
      out.write("\t\tdiv.tab button.active {\n");
      out.write("\t\t\tbackground-color: #ccc;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t/*Style the tab content*/\n");
      out.write("\t\t.tabcontent {\n");
      out.write("\t\t\tdisplay: none;\n");
      out.write("\t\t\tpadding: 6px 12px;\n");
      out.write("\t\t\tborder: 1px solid #ccc;\n");
      out.write("\t\t\tborder-top: none;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\ttable {\n");
      out.write("\t\t\tfont-family: arial, sans-serif;\n");
      out.write("\t\t\tborder-collapse: collapse;\n");
      out.write("\t\t\twidth: 100%;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\ttd, th {\n");
      out.write("\t\t\tborder: 1px solid #dddddd;\n");
      out.write("\t\t\ttext-align: left;\n");
      out.write("\t\t\tpadding: 8px;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\ttr:nth-child(even) {\n");
      out.write("\t\t\tbackground-color: #dddddd;\n");
      out.write("\t\t}\n");
      out.write("\t</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\tWelcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t<div class=\"tab\">\n");
      out.write("\t\t<button class=\"tablinks\" onclick=\"openCity(event, 'All Staff Details')\" id=\"defaultOpen\">All Staff Details</button>\n");
      out.write("\t\t<button class=\"tablinks\" onclick=\"openCity(event, 'Profile')\">Profile</button>\n");
      out.write("\t\t<button class=\"tablinks\" onclick=\"openCity(event, 'Logout')\">Logout</button>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"All Staff Details\" class=\"tabcontent\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th>Staff Id</th>\n");
      out.write("\t\t\t\t\t<th>Name</th>\n");
      out.write("\t\t\t\t\t<th>Email</th>\n");
      out.write("\t\t\t\t\t<th>Username</th>\n");
      out.write("\t\t\t\t\t<th>Contact no</th>\n");
      out.write("\t\t\t\t\t<th>Total Leaves</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t");

					FetchRecordsService fetchRecordsService = new FetchRecordsService();
					List user = fetchRecordsService.showAllRecords();
					
					Iterator it = user.listIterator();
					while (it.hasNext())
					{
						UserDetails userDetails = (UserDetails) it.next();
				
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( userDetails.getStaffId() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( userDetails.getName() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( userDetails.getEmail() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( userDetails.getUsername() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( userDetails.getContactno() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( userDetails.getTotalLeaves() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td class=\"action\">\n");
      out.write("\t\t\t\t\t\t<a href=\"\" class=\"grant\">Grant</a>\n");
      out.write("\t\t\t\t\t\t<a href=\"\" class=\"reject\">Reject</a>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t</table>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"Profile\" class=\"tabcontent\">\n");
      out.write("\t\tStaff Id:<br>\n");
      out.write("\t\t<input type=\"text\" name=\"id\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staffid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><br>\n");
      out.write("\t\tName:<br>\n");
      out.write("\t\t<input type=\"text\" name=\"name\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><br>\n");
      out.write("\t\tEmail:<br>\n");
      out.write("\t\t<input type=\"text\" name=\"email\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><br>\n");
      out.write("\t\tUsername:<br>\n");
      out.write("\t\t<input type=\"text\" name=\"username\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><br>\n");
      out.write("\t\tContact No:<br>\n");
      out.write("\t\t<input type=\"text\" name=\"contactno\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contactno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><br><br>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"Logout\" class=\"tabcontent\">\n");
      out.write("\t\t<form action=\"/Logout\" method=\"get\">\n");
      out.write("\t\t\t<input type=\"submit\" value=\"Logout\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<script>\n");
      out.write("\t\tfunction openCity(evt, cityName) {\n");
      out.write("\t\t\tvar i, tabcontent, tablinks;\n");
      out.write("\t\t\ttabcontent = document.getElementsByClassName(\"tabcontent\");\n");
      out.write("\t\t\tfor (i = 0; i < tabcontent.length; i++) {\n");
      out.write("\t\t\t\ttabcontent[i].style.display = \"none\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\ttablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("\t\t\tfor (i = 0; i < tablinks.length; i++) {\n");
      out.write("\t\t\t\ttablinks[i].className = tablinks[i].className.replace(\"active\", \"\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tdocument.getElementById(cityName).style.display = \"block\";\n");
      out.write("\t\t\tevt.currentTarget.className += \" active\";\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t//Get the element with id=\"defaultOpen\" and click on it\n");
      out.write("\t\tdocument.getElementById(\"defaultOpen\").click();\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}