package fei.test.controller;

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
}

