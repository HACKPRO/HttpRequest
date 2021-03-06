package cn.jianke.httprequest.httprequest.api;

import cn.jianke.httprequest.httprequest.ApiCallback;
import cn.jianke.httprequest.httprequest.InterfaceParameters;
import cn.jianke.httprequest.httprequest.JkApiCallback;
import cn.jianke.httprequest.httprequest.JkApiRequest;
import cn.jianke.httprequest.httprequest.httpresponse.BaseResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by pc on 2016/9/5.
 */
public class APiTest {
    // api
    private ApiStore mApiStore;

    /**
     * Constructor
     * @author leibing
     * @createTime 2016/08/30
     * @lastModify 2016/08/30
     * @param
     * @return
     */
    public APiTest() {
        // 初始化api
        mApiStore = JkApiRequest.getInstance().create(ApiStore.class,
                InterfaceParameters.REQUEST_HTTP_URL);
    }

    public void call(String phone, String loginName, String timestamp, String sign,
                     ApiCallback<BaseResponse> callback){
        Call<BaseResponse> mCall =  mApiStore.call(phone,loginName,timestamp,sign,"9","1");
        mCall.enqueue(new JkApiCallback<BaseResponse>(callback));
    }

    /**
     * @interfaceName: ApiStore
     * @interfaceDescription: 登录模块api接口
     * @author: leibing
     * @createTime: 2016/08/30
     */
    private interface ApiStore {

        @FormUrlEncoded
        @POST("HomePage/CallSend")
        Call<BaseResponse> call(
                @Field("phone") String phone,
                @Field("loginName") String loginName,
                @Field("timestamp") String timestamp,
                @Field("sign") String sign,
                @Field("versionCode") String versionCode,
                @Field("deviceType") String deviceType);
    }
}
