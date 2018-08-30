package com.xdw.controller;

import com.xdw.entity.XdwCompanyInfo;
import com.xdw.service.PcXdwCompanyInfoService;
import com.xdw.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PcXdwCompanyInfo")
public class PcXdwCompanyInfoController {

    @Autowired
    private PcXdwCompanyInfoService pcXdwCompanyInfoService;

    /**
     * pc端查询联系我们数据
     * @param status
     * @return（返回单个结果集，如果返回多个结果会抱错。）
     */
    @RequestMapping("/selectXdwCompanyInfo")
    public JsonView selectXdwCompanyInfo(Integer status){
        JsonView jsonView = new JsonView();
        try{
            if(status!=null){
                XdwCompanyInfo xdwCompanyInfo = pcXdwCompanyInfoService.selectXdwCompanyInfo(status);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(xdwCompanyInfo);
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
