package com.xdw.controller.advertisingController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdw.entity.Advertising;
import com.xdw.service.AdvertisingService;
import com.xdw.util.JsonView;
import com.xdw.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ProjectName xiao-dai-wang
 * @ClassName AdvertisingController
 * @Description TODO banner图web接口
 * @Author sanmu
 * @Date 2018/8/29 17:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("advertising")
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    /**
     * 添加banner图
     * @param advertising
     * @return
     */
    @RequestMapping("insertAdvertising")
    public JsonView insertAdvertising(Advertising advertising){
        JsonView jsonView = new JsonView();
        try {
            int i = advertisingService.insertAdvertising(advertising);
            if (i<=0){
                jsonView.setMessage("添加banner图失败!");
                jsonView.setCode(JsonView.ERROR);
                jsonView.setData(advertising);
                jsonView.setTodoCount(i);
                return jsonView;
            }
            jsonView.setMessage("添加banner图成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(advertising);
            jsonView.setTodoCount(i);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求服务器错误!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 根据id查看banner图
     * @param id 主键ID
     * @return
     */
    @RequestMapping("selectAdvertisingById")
    public JsonView selectAdvertisingById(Long id){
        JsonView jsonView = new JsonView();
        try {
            Advertising advertising = advertisingService.selectAdvertisingById(id);
            jsonView.setTodoCount(advertising==null?0:1);
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(advertising);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求服务器错误!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;}

    /**
     * 查看所有banner图
     * @param page 分页信息
     * @return
     */
    @RequestMapping("selectAdvertisingAll")
    public JsonView selectAdvertisingAll(PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<Advertising> advertisings = advertisingService.selectAdvertisingAll();
            PageInfo<Advertising> pageInfo = new PageInfo<>(advertisings);
            jsonView.setTodoCount(advertisings.size());
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求服务器错误!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;}

    /**
     * 修改banner图
     * @param advertising
     * @return
     */
    @RequestMapping("updateAdvertising")
    public JsonView updateAdvertising(Advertising advertising){
        JsonView jsonView = new JsonView();
        try {
            int i = advertisingService.updateAdvertising(advertising);
            if (i<=0){
                jsonView.setMessage("修改banner图失败!");
                jsonView.setCode(JsonView.ERROR);
                jsonView.setTodoCount(i);
                return jsonView;
            }
            jsonView.setMessage("修改banner图成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(advertising);
            jsonView.setTodoCount(i);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求服务器错误!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;}

    /**
     * 删除banner图
     * @param id 主键id
     * @return
     */
    @RequestMapping("deleteAdvertising")
    public JsonView deleteAdvertising(Long id){
        JsonView jsonView = new JsonView();
        try {
            int i = advertisingService.deleteAdvertising(id);
            if (i<=0){
                jsonView.setMessage("删除banner图失败!");
                jsonView.setCode(JsonView.ERROR);
                jsonView.setTodoCount(i);
                return jsonView;
            }
            jsonView.setMessage("修改banner图成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(i);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求服务器错误!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;}

}
