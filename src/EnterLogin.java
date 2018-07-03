import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 引导界面
 */
@WebServlet("/enter")
public class EnterLogin extends HttpServlet {
    public static String APPID="wx04b1790713e34394";
    public static String APPSECRET="af590c8354f67238481230b94e5de952";
    public static String redirectUrl="http://ourmodel.xin/getCode";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //引导路径
        String url="https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" +APPID+
                "&redirect_uri=" +redirectUrl+
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        response.sendRedirect(url);
    }
}
