package com.xdw.controller.loandiscribe;

import com.xdw.service.LoandiscribeService;
import com.xdw.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("Loandiscribe")
public class LoandiscribeController {

    @Autowired
    private LoandiscribeService loandiscribeService;

     /**
     *贷款申请说明
     * @param loanDiscribe
     * @return
     */
     @RequestMapping("/insertLoandiscribe")
    public JsonView insertLoandiscribe(String loanDiscribe){
        JsonView jsonView = new JsonView();
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            if(loanDiscribe!=null&&loanDiscribe!=""){
                map.put("loanDiscribe",loanDiscribe);
                map.put("createTime",sdf.parse(sdf.format(new Date())));
            }
            int i = loandiscribeService.insertLoandiscribe(map);
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
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

}
