/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2023-04-26 15:41:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.qna;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class show_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/include/header.jspf", Long.valueOf(1682265486301L));
    _jspx_dependants.put("/include/navigation.jspf", Long.valueOf(1682523676169L));
    _jspx_dependants.put("jar:file:/C:/Users/shinheeeul/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("file:/C:/Users/shinheeeul/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar", Long.valueOf(1682261620923L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>KUIT</title>\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"./css/styles.css\" rel=\"stylesheet\">\r\n");
      out.write(" </head>");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\" aria-label=\"Fourth navbar example\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"/\"> KUIT-JSP </a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarsExample04\" aria-controls=\"navbarsExample04\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarsExample04\">\r\n");
      out.write("            <ul class=\"navbar-nav me-auto mb-2 mb-md-0\">\r\n");
      out.write("                <li class=\"nav-item dropdown\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown04\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Home</a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\" aria-labelledby=\"dropdown04\">\r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Profile</a></li>\r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Settings</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <form>\r\n");
      out.write("                <input class=\"form-control\" type=\"text\" placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"navbar-default\">\r\n");
      out.write("    <header class=\"d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom\">\r\n");
      out.write("        <a href=\"/\" class=\"d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none\">\r\n");
      out.write("            <svg class=\"bi me-2\" width=\"40\" height=\"32\" role=\"img\" aria-label=\"Bootstrap\"><use xlink:href=\"#bootstrap\"/></svg>\r\n");
      out.write("        </a>\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav col-12 col-md-auto mb-2 justify-content-center mb-md-0\">\r\n");
      out.write("            <li><a href=\"/\" class=\"nav-link px-2 link-secondary\">Q&A</a></li>\r\n");
      out.write("            <li><a href=\"#\" class=\"nav-link px-2 link-dark\">FAQs</a></li>\r\n");
      out.write("            <li><a href=\"/user/list\" class=\"nav-link px-2 link-dark\">User List</a></li>\r\n");
      out.write("            <li><a href=\"#\" class=\"nav-link px-2 link-dark\">About</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-md-3 text-end\">\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("    <div class=\"container\" id=\"main\">\r\n");
      out.write("            <header class=\"qna-header\">\r\n");
      out.write("                <h2 class=\"qna-title\">객체지향에서 가장 중요하다고 생각하는 것이 무엇인가요?</h2>\r\n");
      out.write("            </header>\r\n");
      out.write("            <div class=\"content-main\">\r\n");
      out.write("                <article class=\"article\">\r\n");
      out.write("                    <div class=\"article-header\">\r\n");
      out.write("                        <div class=\"article-header-thumb\">\r\n");
      out.write("                            <img src=\"../img/picture.jpeg\" class=\"article-author-thumb\" alt=\"\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"article-header-text\">\r\n");
      out.write("                          <!-- 사용자 프로필 추가 할거면 span -> a 태그로 바꾸고 API 연결 -->\r\n");
      out.write("                            <span class=\"article-author-name\">김정우</span>\r\n");
      out.write("                            <span class=\"article-header-time\">\r\n");
      out.write("                              2023-03-09 23:11\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"article-doc\">\r\n");
      out.write("                        <p>객체지향의 특징 4가지</p>\r\n");
      out.write("                        <p>추상화</p>\r\n");
      out.write("                        <p>캡슐화</p>\r\n");
      out.write("                        <p>상속</p>\r\n");
      out.write("                        <p>다형성</p>\r\n");
      out.write("                        <p> ??? </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"article-util\">\r\n");
      out.write("                        <ul class=\"article-util-list\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                              <!-- 수정, 삭제 API 연결 필요 -->\r\n");
      out.write("                                <a class=\"link-modify-article\" href=\"/questions/423/form\">수정</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                              <!-- 수정, 삭제 API 연결 필요 -->\r\n");
      out.write("                                <form class=\"form-delete\" action=\"/questions/423\" method=\"POST\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"_method\" value=\"DELETE\">\r\n");
      out.write("                                    <button class=\"link-delete-article\" type=\"submit\">삭제</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a class=\"link-modify-article\" href=\"/\">목록</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </article>\r\n");
      out.write("  \r\n");
      out.write("                <div class=\"qna-comment\">\r\n");
      out.write("                    <div class=\"qna-comment-kuit\">\r\n");
      out.write("                        <p class=\"qna-comment-count\"><strong>2</strong>개의 의견</p>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <article class=\"article\" id=\"answer-1405\">\r\n");
      out.write("                                <div class=\"article-header\">\r\n");
      out.write("                                    <div class=\"article-header-thumb\">\r\n");
      out.write("                                        <img src=\"../img/picture.jpeg\" class=\"article-author-thumb\" alt=\"\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"article-header-text\">\r\n");
      out.write("                                        <span class=\"article-author-name\">정경은</span>\r\n");
      out.write("                                        <span class=\"article-header-time\">\r\n");
      out.write("                                           2023-03-09 23:15\r\n");
      out.write("                                        </span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"article-doc comment-doc\">\r\n");
      out.write("                                    <p>.</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"article-util\">\r\n");
      out.write("                                    <ul class=\"article-util-list\">\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                          <!-- 수정, 삭제 API 연결 필요 -->\r\n");
      out.write("                                            <a class=\"link-modify-article\" href=\"/questions/1/answers/1/form\">수정</a>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                          <!-- 수정, 삭제 API 연결 필요 -->\r\n");
      out.write("                                            <form class=\"delete-answer-form\" action=\"/questions/1/answers/1\" method=\"POST\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"_method\" value=\"DELETE\">\r\n");
      out.write("                                                <button type=\"submit\" class=\"delete-answer-button\">삭제</button>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </article>\r\n");
      out.write("                            <article class=\"article\" id=\"answer-1406\">\r\n");
      out.write("                                <div class=\"article-header\">\r\n");
      out.write("                                    <div class=\"article-header-thumb\">\r\n");
      out.write("                                        <img src=\"../img/picture.jpeg\" class=\"article-author-thumb\" alt=\"\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"article-header-text\">\r\n");
      out.write("                                        <span class=\"article-author-name\">정은아</span>\r\n");
      out.write("                                        <span class=\"article-header-time\">\r\n");
      out.write("                                          2023-03-09 23:20\r\n");
      out.write("                                        </span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"article-doc comment-doc\">\r\n");
      out.write("                                    <p>nuclear busy girl</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"article-util\">\r\n");
      out.write("                                    <ul class=\"article-util-list\">\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                          <!-- 수정, 삭제 API 연결 필요 -->\r\n");
      out.write("                                            <a class=\"link-modify-article\" href=\"/questions/1/answers/2/form\">수정</a>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                          <!-- 수정, 삭제 API 연결 필요 -->\r\n");
      out.write("                                            <form class=\"form-delete\" action=\"/questions/1/answers/2\" method=\"POST\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"_method\" value=\"DELETE\">\r\n");
      out.write("                                                <button type=\"submit\" class=\"delete-answer-button\">삭제</button>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </article>\r\n");
      out.write("                            <form class=\"submit-write\">\r\n");
      out.write("                                <div class=\"form-group\" style=\"padding:14px;\">\r\n");
      out.write("                                    <textarea class=\"form-control\" placeholder=\"Update your status\"></textarea>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <button class=\"btn btn-primary pull-right\" type=\"button\">답변하기</button>\r\n");
      out.write("                                <div class=\"clearfix\" />\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script src=\"../js/scripts.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f0_reused = false;
    try {
      _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f0.setParent(null);
      int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
      if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            ");
          if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("            ");
          if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      _jspx_th_c_005fchoose_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f0_reused = false;
    try {
      _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      // /include/navigation.jspf(42,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.user}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
      if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                <a href=\"/user/logout\" role=\"button\" class=\"btn btn-outline-primary me-2\">Log-Out</a>\r\n");
          out.write("                <a href=\"/user/updateForm?userId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" role=\"button\" class=\"btn btn-primary\" >개인정보수정</a>\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      _jspx_th_c_005fwhen_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    boolean _jspx_th_c_005fotherwise_005f0_reused = false;
    try {
      _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
      if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("                <!--<a href=\"/user/login.jsp\" type=\"button\" class=\"btn btn-outline-primary me-2\">Log-In</a>-->\r\n");
          out.write("                <a href=\"/user/loginForm\" type=\"button\" class=\"btn btn-outline-primary me-2\">Log-In</a>\r\n");
          out.write("                <a href=\"/user/form\" type=\"button\" class=\"btn btn-primary\">Sign-up</a>\r\n");
          out.write("\r\n");
          out.write("                <!--<a href=\"/user/form.jsp\" type=\"button\" class=\"btn btn-primary\">Sign-up</a>-->\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      _jspx_th_c_005fotherwise_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
    }
    return false;
  }
}
