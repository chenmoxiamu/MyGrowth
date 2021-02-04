package com.java2007.xiazhaodong.hotel.controller.backend;

import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Admin;
import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;
import com.java2007.xiazhaodong.hotel.service.DinnerTableService;
import com.java2007.xiazhaodong.hotel.service.FoodTypeService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author AzureSky_X
 * @Date 2021/1/29 15:02
 * @Version 1.0
 */
@WebServlet("/table")
public class FoodTableController  extends BaseController {
    //通过工厂类创建实例
    //private FoodTypeService foodTypeService=
    //        BeanFactory.getInstance("foodTypeService", FoodTypeServiceImpl.class);
    private DinnerTableService dinnerTableService = (DinnerTableService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.DinnerTableServiceImpl");

    /**
     * 搜索
     * 根据用户输入的关键字模糊查询
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String keyword = request.getParameter("keyword");
        List<DinnerTable> tables = dinnerTableService.findByName(keyword);
        request.setAttribute("tables", tables);
        request.setAttribute("keyword", keyword);
        return ServletConstant.PRE_FORWARD+ "/backend/detail/table/table-list.jsp";

    }

    /**
     * 删除餐桌
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String idStr = request.getParameter("id");
        int tableId = Integer.parseInt(idStr);
        String status=request.getParameter("status");

        dinnerTableService.deleteById(tableId);


        //重定向到查询接口
        return ServletConstant.PRE_REDIRECT+"/table?method=search";
    }


    /**
     * 增加新桌子
     * newTableName:新的桌名
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String saveTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取新桌名
        String newTableName = request.getParameter("newTableName");
        //获取创建者
        Admin admin= (Admin) request.getSession().getAttribute("loginAdmin");
        int adminId=Integer.parseInt(admin.getAdminId());
        //封装餐桌信息
        DinnerTable dinnerTable=new DinnerTable();

        dinnerTable.setCreateTime(new Date());
        dinnerTable.setTableName(newTableName);
        dinnerTable.setStatus("0");
        dinnerTable.setUpdateTime(new Date());
        dinnerTable.setCreateUser(adminId);
        //调用业务
        dinnerTableService.save(dinnerTable);

        //重定向到查询接口
        return ServletConstant.PRE_REDIRECT+"/table?method=search";
    }

    /**
     * 预订与退桌
     * 0：空闲   1：已预约
     * 点击预订要设置预订时间
     * 点击退桌要清空预订时间
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String reservetables(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收参数
        String status=request.getParameter("status");
        String idStr = request.getParameter("id");

        int id = Integer.parseInt(idStr);
        //调用业务 更改餐桌状态与预订时间
        dinnerTableService.updateTableStatus(status,id);

        //重定向到查询接口
        return ServletConstant.PRE_REDIRECT+"/table?method=search";

    }

    /**
     * ajax检测新增的桌名是否重复
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String checkTableName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收用户输入的餐桌名
        String newTableName=request.getParameter("newTableName");
        int result=dinnerTableService.checkTableName(newTableName);
        return String.valueOf(result);
    }

}
