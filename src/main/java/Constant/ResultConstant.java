package Constant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ResultConstant {
    private String code;
    private Object data;

    public ResultConstant(String f,Object o){
        this.code = f;
        this.data = o;
    }


}
