package com.xdw.controller.userloanController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdw.entity.UserLoan;
import com.xdw.service.UserLoanService;
import com.xdw.util.JsonView;
import com.xdw.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName UserLoanController
 * @Description TODO 用户贷款表Controller
 * @Author sanmu
 * @Date 2018/8/29 11:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user/loan")
public class UserLoanController {
    @Autowired
    private UserLoanService userLoanService;

    /**
     * 贷款申请
     * @param userLoan
     * @return
     */
    @RequestMapping(value = "/insertUserLoanInfo",method = RequestMethod.POST)
    public JsonView insertUserLoanInfo(UserLoan userLoan){
        JsonView jsonView = new JsonView();
        try {
            int i = userLoanService.insertUserLoanInfo(userLoan);
            if (i<=0){
                jsonView.setMessage("申请贷款失败!");
                jsonView.setCode(JsonView.ERROR);
                jsonView.setData(userLoan);
                jsonView.setTodoCount(i);
                return jsonView;
            }
            jsonView.setMessage("申请贷款成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(userLoan);
            jsonView.setTodoCount(i);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("申请贷款异常!");
        }
        return jsonView;
    }

    /**
     * 按用户ID查询贷款申请
     * @param userId 贷款用户id
     * @return
     */
    @RequestMapping("/selectUserLoanByUserId")
    public JsonView selectUserLoanByUserId(Long userId, PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<UserLoan> userLoans = userLoanService.selectUserLoanByUserId(userId);
            PageInfo<UserLoan> pageInfo = new PageInfo<>(userLoans);
            jsonView.setTodoCount(userLoans.size());
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求数据失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按ID查询贷款申请
     * @param id 贷款信息id
     * @return
     */
    @RequestMapping("/selectUserLoanById")
    public JsonView selectUserLoanById(Long id){
        JsonView jsonView = new JsonView();
        try {
            UserLoan userLoan = userLoanService.selectUserLoanById(id);
            jsonView.setTodoCount(userLoan==null?0:1);
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(userLoan);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求数据失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按条件查询所有贷款信息
     * @param userLoan
     * @param page
     * @return
     */
    @RequestMapping("selectUserLoanAll")
    public JsonView selectUserLoanAll(UserLoan userLoan,PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<UserLoan> userLoans = userLoanService.selectUserLoanAll(userLoan);
            PageInfo<UserLoan> pageInfo = new PageInfo<>(userLoans);
            jsonView.setTodoCount(userLoans.size());
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求数据失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 审核贷款信息
     * @param userLoan
     * @return
     */
    @RequestMapping("updateUserLoanInfoById")
    public JsonView updateUserLoanInfoById(UserLoan userLoan){
        JsonView jsonView = new JsonView();
        try {
            int i = userLoanService.updateUserLoanInfoById(userLoan);
            if (i<=0){
                jsonView.setMessage("审核贷款失败!");
                jsonView.setCode(JsonView.ERROR);
                jsonView.setTodoCount(i);
                return jsonView;
            }
            jsonView.setMessage("审核贷款成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(userLoan);
            jsonView.setTodoCount(i);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求服务器错误!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
