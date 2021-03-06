package org.seckill.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

  /** Handler执行完成之后调用这个方法 */
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc)
      throws Exception {
    //        HttpSession session = request.getSession();
    //        String userId = (String)session.getAttribute("user_id");
    //        System.out.println("afterCompletion-userId: " + userId);
    //        System.out.println("afterCompletion-session-id: " + request.getSession().getId());
  }

  /** Handler执行之后，ModelAndView返回之前调用这个方法 */
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    //        HttpSession session = request.getSession();
    //        String userId = (String)session.getAttribute("user_id");
    //        System.out.println("postHandle-userId: " + userId);
  }

  /** Handler执行之前调用这个方法 */
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 获取请求的URL
    String url = request.getRequestURI();
    System.out.println("url: " + url);
    // URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
    if (url.indexOf("/user/do_login") >= 0 || url.indexOf("/user/login") >= 0) {
      return true;
    }
    // 获取Session
    HttpSession session = request.getSession();
    Long userId = (Long) session.getAttribute("user_id");
    System.out.println("userId: " + userId);
    System.out.println("preHandle-session-id: " + request.getSession().getId());
    if (userId != null) {
      return true;
    }
    // 不符合条件的，跳转到登录界面
    response.sendRedirect("/user/login");
    //        request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, response);

    return false;
  }
}
