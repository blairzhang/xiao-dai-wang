package com.xdw.controller.xdw_company_info;

import com.xdw.service.XdwCompanyInfoService;
import com.xdw.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("XdwCompanyInfo")
@RestController
public class XdwCompanyInfoController {

    @Autowired
    private XdwCompanyInfoService xdwCompanyInfoService;

    /**
     * 后台联系我们添加数据
     * @param companyName
     * @param companyAddress
     * @param companyURL
     * @return
     */
    @RequestMapping("/insertXdwCompanyInfo")
    public JsonView insertXdwCompanyInfo(String companyName,String companyAddress,String companyURL){
        JsonView jsonView = new JsonView();
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            if(companyName!=null&&companyName!=""){
                map.put("companyName",companyName);
            }if(companyAddress!=null&&companyAddress!=""){
                map.put("companyAddress",companyAddress);
            }if(companyURL!=null&&companyURL!=""){
                map.put("companyURL",companyURL);
            }
            map.put("createTime",sdf.parse(sdf.format(new Date())));
            int i = xdwCompanyInfoService.insertXdwCompanyInfo(map);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("添加成功");
            }else {
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("添加异常");
        }

        return jsonView;
    }
}
