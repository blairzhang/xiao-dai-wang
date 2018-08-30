package com.xdw.controller;

import com.xdw.entity.Businessprofile;
import com.xdw.service.PcBusinessprofileService;
import com.xdw.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("PCBusinessprofileController")
@RestController
public class PCBusinessprofileController {

    @Autowired
    private PcBusinessprofileService pcBusinessprofileService;

    /**
     * pc端查询企业简介数据
     * @param status
     * @return(返回单个结果集，如果返回多个结果会抱错。)
     */
    @RequestMapping("/selectBusinessprofile")
    public JsonView selectBusinessprofile(int status){
        JsonView jsonView = new JsonView();
        try{
            if(status==1){
                Businessprofile businessprofile = pcBusinessprofileService.selectBusinessprofile(status);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(businessprofile);
                jsonView.setMessage("查询成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

}
