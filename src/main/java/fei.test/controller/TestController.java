package fei.test.controller;

import Constant.ResultConstant;
import com.alibaba.fastjson.JSON;
import com.generator.dao.mapper.UserMapper;
import com.generator.model.User;
import com.generator.model.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")

public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/userList",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object list(
                       ){
        List<User> map = new ArrayList<>();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo("001");
        map = userMapper.selectByExample(userExample);

        Map result = new HashMap();
        result.put("res",map);
        logger.debug(map.toString());
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    @ResponseBody
    public Object login(
            @RequestParam(value = "userName",required = true) String userName,
            @RequestParam(value = "password",required = true) String password

    ){

        Map<String,Object> result = new HashMap<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> listName = userMapper.selectByExample(userExample);
        logger.debug(String.valueOf(listName.size()));
        if( listName.size() == 0){
            result.put("code","2");
            result.put("msg","未注册用户");
            return JSON.toJSONString(result);
        }
        else {
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
            List<User> list = userMapper.selectByExample(userExample1);

            if (list.size() == 0) {
                result.put("code", "1");
                result.put("msg", "用户名或密码错误");
                return JSON.toJSONString(result);
            }
            else{
                result.put("code","0");
                result.put("msg","登录成功");
                return JSON.toJSONString(result);
            }
        }
    }
}

