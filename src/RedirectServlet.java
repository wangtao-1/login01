import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取用户信息
 */
@WebServlet("/getCode")
public class RedirectServlet extends HttpServlet {

    public String access_token="login";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("code");
        String codeUrl="https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid="+EnterLogin.APPID+
                "&secret=" +EnterLogin.APPSECRET+
                "&code=" +code+
                "&grant_type=authorization_code";
        JSONObject codeJson=GetInfoByUrl.getInfoByurl(codeUrl);
        String access_token=codeJson.getString("access_token");
        String openid=codeJson.getString("openid");
        String userInfoUrl="https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" +access_token+
                "&openid=OPENID" +openid+
                "&lang=zh_CN";
        JSONObject UserInfo=GetInfoByUrl.getInfoByurl(userInfoUrl);
        String name=UserInfo.getString("nickname");
        String sex=UserInfo.getString("sex");
        System.out.println("姓名为："+name+"性别为："+sex);
        PrintWriter out=response.getWriter();
        out.print("姓名为："+name+"性别为："+sex);
    }
}
