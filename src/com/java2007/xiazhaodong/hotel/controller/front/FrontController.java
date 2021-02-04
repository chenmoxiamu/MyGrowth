package com.java2007.xiazhaodong.hotel.controller.front;

import com.alibaba.druid.util.StringUtils;
import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;
import com.java2007.xiazhaodong.hotel.entity.PageBean;
import com.java2007.xiazhaodong.hotel.service.DinnerTableService;
import com.java2007.xiazhaodong.hotel.service.FoodService;
import com.java2007.xiazhaodong.hotel.service.FoodTypeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 前台控制
 * @Author AzureSky_X
 * @Date 2021/1/27 15:38
 * @Version 1.0
 */
@WebServlet("/front")
public class FrontController extends BaseController {
    private DinnerTableService dinnerTableService = (DinnerTableService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.DinnerTableServiceImpl");
    private FoodService foodService = (FoodService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.FoodServiceImpl");
    private FoodTypeService foodTypeService = (FoodTypeService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.FoodTypeServiceImpl");

    /**
     * 根据传入id查找菜品信息
     * 查到数据后传递并展示给菜单详情.jsp
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findFoodById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String foodIdStr = request.getParameter("foodId");
        if(!StringUtils.isEmpty(foodIdStr)){
            int foodId = Integer.parseInt(foodIdStr);
            Food food = foodService.findById(foodId);
            //将菜品信息传递给jsp页面
            request.setAttribute("food", food);
            return ServletConstant.PRE_FORWARD +  "/front/detail/caixiangxi.jsp";
        } else {
            return "查无此菜";
        }

        }

    /**
     * 首页展示空闲的空间
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findTableByStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查询空闲的餐桌并将数据传递给jsp
        List<DinnerTable> tables=dinnerTableService.findByStatus(0);
        request.setAttribute("tables",tables);

        //加载菜类别列表
        HttpSession session = request.getSession();
        List<FoodType> types = (List<FoodType>) session.getAttribute("front_types");
        if(types == null || types.size() == 0) {
            types = foodTypeService.findAll();
            session.setAttribute("front_types", types);
        }

        return "forward:/front/index.jsp";
    }

    /**
     * 分页展示菜品数据
     * 每页6条记录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findFoodByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //保存餐桌id
        String tableId=request.getParameter("tableId");
        if (tableId!=null){
            request.getSession().setAttribute("tableId",Integer.parseInt(tableId));
        }
        //将查询条件封装成一个对象，因为将来可能还要添加别的条件
        Food food=new Food();

        String typeIdStr = request.getParameter("typeId");
        if (!StringUtils.isEmpty(typeIdStr)) {
            //不为空，封装条件到food实体中
            int typeId = Integer.parseInt(typeIdStr);
            if(typeId > 0) {
                food.setTypeId(typeId);
            }
        }
        String foodNameStr = request.getParameter("foodName");
        if(!StringUtils.isEmpty(foodNameStr)){
            //不为空，去掉前后空格，封装条件到food实体中
            food.setFoodName(foodNameStr.trim());
            request.setAttribute("foodName", food.getFoodName());
        }

        String pageNoStr = request.getParameter("pageNo");
        if (StringUtils.isEmpty(pageNoStr)) {
            pageNoStr = "1";
        }
        int pageNo = Integer.parseInt(pageNoStr);
        PageBean<Food> pageBean = foodService.findByPage(pageNo, PageBean.SIZE, food);
        request.setAttribute("pageBean", pageBean);
        return "forward:/front/detail/caidan.jsp";


    }




    }
