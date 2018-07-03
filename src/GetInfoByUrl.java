import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetInfoByUrl {

    /**
     * 异步请求返回json
     * @param url
     * @return
     */
    public static JSONObject getInfoByurl(String url){
        JSONObject jsonObject=null;
        DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(url);
        try {
            HttpResponse httpResponse=defaultHttpClient.execute(httpGet);
            HttpEntity httpEntity=httpResponse.getEntity();
            String json=EntityUtils.toString(httpEntity);
            String jsonstr=new String(json.getBytes("ISO-8859-1"),"utf-8");
            jsonObject= JSON.parseObject(jsonstr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;

    }
}
