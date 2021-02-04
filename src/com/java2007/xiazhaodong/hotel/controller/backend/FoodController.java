package com.java2007.xiazhaodong.hotel.controller.backend;

import com.alibaba.druid.util.StringUtils;
import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;
import com.java2007.xiazhaodong.hotel.service.FoodService;
import com.java2007.xiazhaodong.hotel.service.FoodTypeService;
import com.java2007.xiazhaodong.hotel.utils.FileUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 菜品业务控制层
 * @Author AzureSky_X
 * @Date 2021/1/23 17:24
 * @Version 1.0
 */
@WebServlet("/food")
@MultipartConfig
public class FoodController extends BaseController {
    private FoodService foodService = (FoodService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.FoodServiceImpl");
    private FoodTypeService foodTypeService = (FoodTypeService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.FoodTypeServiceImpl");

    public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Food> foods = foodService.findByName(keyword);
        //菜类别列表数据
        List<FoodType> types=foodTypeService.findAll();
        request.setAttribute("types",types);

        request.setAttribute("foods", foods);
        request.setAttribute("keyword", keyword);
        return ServletConstant.PRE_FORWARD+ "/backend/detail/food/food-list.jsp";
    }




    /**
     * 回显菜品数据
     * 1、查询菜别数据
     * 2、回显选中的菜类别，图片
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findById(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //System.out.println("-------这里是findById方法");
        //菜类别列表数据
        List<FoodType> types=foodTypeService.findAll();
        request.setAttribute("types",types);
        //获取菜品id
        String idStr=request.getParameter("id");
        int id=Integer.parseInt(idStr);
        //根据传入的id获取菜品数据
        Food food = foodService.findById(id);
        request.setAttribute("food",food);
        //图片回显的地址: http://localhost:8080/项目虚拟路径/files/uuid.jpg

        //图片回显的地址: http://localhost:8080/项目虚拟路径 + food.getImage()
        return ServletConstant.PRE_FORWARD+"/backend/detail/food/food-update.jsp";
    }

    /**
     * 添加菜品页面
     * 获取 菜类别列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String saveui(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<FoodType> types=foodTypeService.findAll();
        request.setAttribute("types",types);
        return ServletConstant.PRE_FORWARD+"/backend/detail/food/food-save.jsp";
    }


    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String fileName= FileUtil.upload(request);
        //如果文件名是空的，说明上传错误
        if (StringUtils.isEmpty(fileName)){
            //文件上传错误
            return "文件上传错误";

        }

        //封装参数，执行保存业务
        Map<String, String[]> parameterMap = request.getParameterMap();
        Food food=new Food();
        //获取用户输入的参数
        BeanUtils.populate(food,parameterMap);
        //把图片存为一个服务上的映射资源路径
        food.setImage(fileName);    //   /files/uuid.jpg  --> http://localhost:8080/项目虚拟路径/files/uuid.jpg
        foodService.update(food);
        return "更新成功";
    }
    /**
     * 保存
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ////文件上传
        //Part part=request.getPart("image");
        //System.out.println(part);
        ////获取选择文件的全名
        //String filename=part.getSubmittedFileName();
        ////获取选择文件的后缀名      .jsp
        //String suffixName=filename.substring(filename.lastIndexOf("."));
        //
        //String imagePath=request.getSession().getServletContext().getRealPath("/files/");
        //System.out.println("-->"+imagePath);
        ////生成新的文件名      uuid.jpg
        //String fileName= UUIDUtil.getFileName(suffixName);
        //File file=new File(imagePath,fileName);
        //if (file.getParentFile().exists()){
        //    file.getParentFile().mkdirs();
        //}
        //part.write(file.getPath());
        String fileName= FileUtil.upload(request);
        //如果文件名是空的，说明上传错误
        if (StringUtils.isEmpty(fileName)){
            //文件上传错误
            return "文件上传错误";

        }

        //封装参数，执行保存业务
        Map<String, String[]> parameterMap = request.getParameterMap();
        Food food=new Food();
        //获取用户输入的参数
        BeanUtils.populate(food,parameterMap);
        //把图片存为一个服务上的映射资源路径
        food.setImage(fileName);    //   /files/uuid.jpg  --> http://localhost:8080/项目虚拟路径/files/uuid.jpg
        foodService.save(food);
        return "增加成功";

    }

    /**
     * 删除菜品
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteFood(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String idStr = request.getParameter("id");
        int foodId = Integer.parseInt(idStr);
        foodService.deleteById(foodId);
        //重定向到查询接口
        return ServletConstant.PRE_REDIRECT+"/food?method=search";
    }




}
