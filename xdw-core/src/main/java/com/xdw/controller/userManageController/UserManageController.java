package com.xdw.controller.userManageController;

import com.github.pagehelper.PageInfo;
import com.xdw.entity.UserRegist;
import com.xdw.service.UserManageService;
import com.xdw.util.JsonView;
import com.xdw.util.MD5Util;
import com.xdw.util.PageRequest;
import com.xdw.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/coreUserManage")
@RestController
public class UserManageController {
    @Autowired
    private UserManageService userManageService;


    /**
     * 分页查询所有用户的信息
     * @param userName
     * @param startTime
     * @param endTime
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectAllUserByPage")
    public JsonView selectAllUserByPage(String userName, Date startTime, String endTime, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            Map userMap = new HashMap();
            if(userName!=null && !("").equals(userName)){
                map.put("userName",userName);
            }
            if(startTime!=null){
                map.put("startTime",startTime);
            }
            if(endTime!=null){
                map.put("endTime",endTime);
            }
            PageInfo<UserVo> pageInfo = userManageService.selectUserByPage(map, pageRequest);
            if(pageInfo.getList().size()>0){
                userMap.put("pageInfo",pageInfo);
                userMap.put("userCount",pageInfo.getSize());
                jsonView.setMessage("返回数据成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(userMap);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("暂无用户信息数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 修改（重置密码，注销）
     * @param userRegist
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public JsonView updateUserInfo(UserRegist userRegist){
        JsonView jsonView = new JsonView();
        try{
            if(userRegist.getPassword()!=null && !("").equals(userRegist.getPassword())){
                userRegist.setPassword(MD5Util.MD5(userRegist.getPassword()));
            }
            userRegist.setUpdateTime(new Date());
            Integer i = userManageService.updateUserInfo(userRegist);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("修改成功");
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("修改异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }
}
