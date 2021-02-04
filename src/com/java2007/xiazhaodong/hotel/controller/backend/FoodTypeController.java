package com.java2007.xiazhaodong.hotel.controller.backend;

import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;
import com.java2007.xiazhaodong.hotel.service.FoodTypeService;
import com.java2007.xiazhaodong.hotel.service.impl.FoodTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 菜单类别控制层
 * 继承了BaseController,而BaseController继承了HttpServlet
 * 该控制器就有了BaseController的service方法
 * @Author AzureSky_X
 * @Date 2021/1/22 19:52
 * @Version 1.0
 */
@WebServlet("/foodtype")
public class FoodTypeController extends BaseController {
    //通过工厂类创建实例
    //private FoodTypeService foodTypeService=
    //        BeanFactory.getInstance("foodTypeService", FoodTypeServiceImpl.class);
    private FoodTypeService foodTypeService =
            (FoodTypeService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.FoodTypeServiceImpl");

    /**
     * 搜索
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String keyword = request.getParameter("keyword");
        List<FoodType> types = foodTypeService.findByTypeName(keyword);
        request.setAttribute("types", types);
        request.setAttribute("keyword", keyword);

        return "forward:/backend/detail/foodtype/food-type-list.jsp";

    }

    /**
     * 删除
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {


        String idStr = request.getParameter("id");
        int typeId = Integer.parseInt(idStr);
        //如果该菜系下还有菜品则不能删除
        int result =foodTypeService.findByFoodTypeId(typeId);
        if (result==1){
            return "redirect:/foodtype?method=search";
        }
        foodTypeService.deleteByTypeId(typeId);
        //重定向到查询接口
        return "redirect:/foodtype?method=search";
    }

    /**
     * 回显
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findById(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        //重定向到查询接口
        FoodType foodType = foodTypeService.findByTypeId(id);
        request.setAttribute("type", foodType);
        return "forward:/backend/detail/foodtype/food-type-update.jsp";

    }

    /**
     * 增加
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String foodName = request.getParameter("foodName");
        foodTypeService.save(foodName);
        //重定向到查询接口
        return "redirect:/foodtype?method=search";

    }

    /**
     * 更新
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String[]> parameterMap = request.getParameterMap();
        FoodType foodType = new FoodType();

        BeanUtils.populate(foodType, parameterMap);

        foodTypeService.update(foodType);
        //重定向到查询接口
        return "redirect:/foodtype?method=search";

    }

    /**
     * ajax检测新增的菜类别名是否重复
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String checkFoodTypeName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收用户输入的菜类别名
        String newFoodTypeName=request.getParameter("newFoodTypeName");
        int result=foodTypeService.checkFoodTypeName(newFoodTypeName);
        return String.valueOf(result);
    }

    /**
     * 查看该菜系下是否还有菜品
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public int findFoodIsExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String typeIdStr= (String) request.getAttribute("typeId");
        int typeId=Integer.parseInt(typeIdStr);
        int result =foodTypeService.findByFoodTypeId(typeId);
        return result;

    }

    }
