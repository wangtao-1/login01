import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证签名
 */
@WebServlet("/getlogin")
public class LoginsServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");
        //签名校验
        boolean flog=SignUtil.checkSignature(signature,timestamp,nonce);
        PrintWriter out=response.getWriter();
        if(flog){
            System.out.println("配置成功！！");
        }else{
            System.out.println("配置失败！！");
        }
        out.print(echostr);

    }
}
