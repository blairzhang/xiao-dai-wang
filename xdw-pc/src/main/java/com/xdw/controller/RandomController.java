package com.xdw.controller;

import com.xdw.util.JsonView;
import com.xdw.util.RandomUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/random")
@RestController
public class RandomController {


    /**
     * 生成四位的随机数（数字和字母）
     * @return
     */
    @RequestMapping("/random")
    public JsonView random(){
        JsonView jsonView = new JsonView();
        try{
            String stringRandom = RandomUtil.getStringRandom(4);
            if(stringRandom!=null && !("").equals(stringRandom)){
                jsonView.setMessage("随机数生成成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setMessage("随机数生成失败");
                jsonView.setCode(JsonView.ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("随机数生成异常");
        }
        return jsonView;
    }
}
