package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Objects;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.OrderStatus;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysInvestOrderStep;
import com.ruoyi.system.domain.SysInvestProduct;
import com.ruoyi.system.domain.dto.OrderDTO;
import com.ruoyi.system.service.ISysInvestOrderStepService;
import com.ruoyi.system.service.ISysInvestOrderSubStepService;
import com.ruoyi.system.service.ISysInvestProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysInvestOrder;
import com.ruoyi.system.service.ISysInvestOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@RestController
@RequestMapping("/system/order")
public class SysInvestOrderController extends BaseController
{
    @Autowired
    private ISysInvestOrderService sysInvestOrderService;

    @Autowired
    private ISysInvestOrderStepService sysInvestOrderStepService;

    @Autowired
    private ISysInvestProductService sysInvestProductService;

    /**
     * 查询订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysInvestOrder sysInvestOrder)
    {
        startPage();
        List<SysInvestOrder> list = sysInvestOrderService.selectSysInvestOrderList(sysInvestOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInvestOrder sysInvestOrder)
    {
        List<SysInvestOrder> list = sysInvestOrderService.selectSysInvestOrderList(sysInvestOrder);
        ExcelUtil<SysInvestOrder> util = new ExcelUtil<SysInvestOrder>(SysInvestOrder.class);
        util.exportExcel(response, list, "订单管理数据");
    }

    /**
     * 获取订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/order/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") String orderId) {
        AjaxResult ajax = AjaxResult.success();

        if (StringUtils.isNotNull(orderId)) {
            SysInvestOrder order = sysInvestOrderService.selectSysInvestOrderByOrderId(orderId);
            ajax.put(AjaxResult.DATA_TAG, order);
            SysInvestOrderStep orderStep = new SysInvestOrderStep();
            orderStep.setOrderId(order.getOrderId());
            List<SysInvestOrderStep> sysInvestOrderStepList  = sysInvestOrderStepService.selectSysInvestOrderStepList(orderStep);
            ajax.put("steps", sysInvestOrderStepList);
        }
        return ajax;
    }

    /**
     * 新增订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInvestOrder sysInvestOrder)
    {
        return toAjax(sysInvestOrderService.insertSysInvestOrder(sysInvestOrder));
    }

    /**
     * 修改订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInvestOrder sysInvestOrder)
    {
        return toAjax(sysInvestOrderService.updateSysInvestOrder(sysInvestOrder));
    }

    /**
     * 删除订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysInvestOrderService.deleteSysInvestOrderByIds(ids));
    }

    /**
     * 删除订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list1")
    public AjaxResult getAllOrders(@PathVariable Long[] ids)
    {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        if (user.hasRole("trader")){

        }else if (user.hasRole("admin")){

        }
        return toAjax(sysInvestOrderService.deleteSysInvestOrderByIds(ids));
    }
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping(value="create_order")
    public AjaxResult createOrder(@RequestBody OrderDTO orderDTO)
    {
        AjaxResult validateResult = validateOrderDTO(orderDTO);
        if (validateResult != null) {
            return validateResult;
        }
        //订单转换
        SysInvestOrder order = orderDTO.convertToSysInvestOrder();
        String orderId = java.util.UUID.randomUUID().toString();
        order.setOrderId(orderId);
        sysInvestOrderService.insertSysInvestOrder(order);
        //子订单转换
        List<SysInvestOrderStep> subOrders = orderDTO.convertToSysInvestOrderStep(orderId);
        sysInvestOrderStepService.insertSysInvestOrderStepList(subOrders);
        //保存子订单
        return AjaxResult.success();
    }

    /**
     * 验证 OrderDTO 对象
     * @param orderDTO 订单数据传输对象
     * @return 如果验证失败返回包含错误信息的 AjaxResult，验证成功返回 null
     */
    private AjaxResult validateOrderDTO(OrderDTO orderDTO) {
        // 验证订单金额大于0
        if (orderDTO.getOrderAmount() <= 0) {
            return AjaxResult.error("订单金额必须大于0");
        }

        // 验证收益开始时间小于收益截至时间
        if (orderDTO.getOrderTime().compareTo(orderDTO.getOrderEndTime()) >= 0) {
            return AjaxResult.error("收益开始时间必须小于收益截至时间");
        }
        double marginValue = 0;
        // 验证保证金设置
        if (orderDTO.getMarginStep().getStepMode()=="rate") {
            if (orderDTO.getMarginStep().getStepValue() <= 0 || orderDTO.getMarginStep().getStepValue() >= 100) {
                return AjaxResult.error("保证金按比例设置时，范围必须大于0小于100");
            }
            marginValue = orderDTO.getOrderAmount() * orderDTO.getMarginStep().getStepValue() /100;
        } else {
            if (orderDTO.getMarginStep().getStepValue() <= 0 || orderDTO.getMarginStep().getStepValue()>= orderDTO.getOrderAmount()) {
                return AjaxResult.error("保证金按金额设置时，范围必须大于0小于订单金额");
            }
            marginValue = orderDTO.getMarginStep().getStepValue();
        }

        // 验证代币购买设置
        double totalTokenPurchase = 0;
        for (SysInvestOrderStep step : orderDTO.getSpotPerpStep()) {
            totalTokenPurchase += step.getStepValue();
        }
        if (totalTokenPurchase > orderDTO.getOrderAmount() - marginValue) {
            return AjaxResult.error("代币购买设置所有金额之和必须小于等于订单金额减去保证金后的值");
        }

        // 验证代币质押设置
        if (orderDTO.getStakeStep().getStepValue() <= 0) {
            return AjaxResult.error("代币质押设置必须大于0");
        }

        return null;
    }

    /**
     * 投资信息查询
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping(value = "/invest_summary")
    public AjaxResult getAllInvestInfo(SysInvestOrder sysInvestOrder) {
        AjaxResult ajax = AjaxResult.success();
        LoginUser user = getLoginUser();
        if(user.getUser().isInvestor()){
            sysInvestOrder.setBuyerId(user.getUserId());
        }else if(user.getUser().isTrader()){
            sysInvestOrder.setTraderId(user.getUserId());
        }
        List<SysInvestOrder> list = sysInvestOrderService.selectSysInvestOrderList(sysInvestOrder);
        List<SysInvestProduct> products =  sysInvestProductService.selectSysInvestProductList(null);
        ajax.put(AjaxResult.DATA_TAG,list);
        ajax.put("product",products);
        return ajax;
    }

    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @PostMapping(value = "/stake_token")
    public AjaxResult getAllInvestInfo(String orderId, Double amount) {

        LoginUser user = this.getLoginUser();
        SysInvestOrder order = sysInvestOrderService.selectSysInvestOrderByOrderId(orderId);
        if(user.getUser().isAdmin()|| Objects.equals(user.getUserId(), order.getBuyerId())){
            //获取产品信息
            SysInvestProduct sysInvestProduct = sysInvestProductService.selectSysInvestProductById(order.getProductId());
            //如果属于质押
            if(Objects.equals(order.getOrderStatus(), OrderStatus.STAKE_TOKEN.getCode())){

            }
        }else{
            return AjaxResult.error("无权限");
        }
        return null;
    }

}
