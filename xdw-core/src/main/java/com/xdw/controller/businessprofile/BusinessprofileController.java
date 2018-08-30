package com.xdw.controller.businessprofile;

import com.xdw.service.BusinessprofileService;
import com.xdw.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台企业简介
 */
@RestController
@RequestMapping("Businessprofile")
public class BusinessprofileController {

    @Autowired
    private BusinessprofileService businessprofileService;

    /**
     * 后台企业简介添加数据
     * @param businessProfile
     * @return
     */
    @RequestMapping("/insertBusinessprofile")
    public JsonView insertBusinessprofile(String businessProfile){
        JsonView jsonView = new JsonView();
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            if(businessProfile!=null&&businessProfile!=""){
                map.put("businessProfile",businessProfile);

                map.put("createTime",sdf.parse(sdf.format(new Date())));
                int i = businessprofileService.insertBusinessprofile(map);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("添加成功");
                }else {
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("添加失败");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("添加异常");
        }
        return jsonView;
    }
}
