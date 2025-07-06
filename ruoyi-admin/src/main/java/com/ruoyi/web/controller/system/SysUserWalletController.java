package com.ruoyi.web.controller.system;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.utils.BinanceUtil;
import com.ruoyi.system.domain.dto.WalletBalanceParamDTO;
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
import com.ruoyi.system.domain.SysUserWallet;
import com.ruoyi.system.service.ISysUserWalletService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 钱包管理Controller
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@RestController
@RequestMapping("/system/wallet")
public class SysUserWalletController extends BaseController
{
    @Autowired
    private ISysUserWalletService sysUserWalletService;

    /**
     * 查询钱包管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:wallet:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUserWallet sysUserWallet)
    {
        startPage();
        List<SysUserWallet> list = sysUserWalletService.selectSysUserWalletList(sysUserWallet);
        return getDataTable(list);
    }

    /**
     * 导出钱包管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:wallet:export')")
    @Log(title = "钱包管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserWallet sysUserWallet)
    {
        List<SysUserWallet> list = sysUserWalletService.selectSysUserWalletList(sysUserWallet);
        ExcelUtil<SysUserWallet> util = new ExcelUtil<SysUserWallet>(SysUserWallet.class);
        util.exportExcel(response, list, "钱包管理数据");
    }

    /**
     * 获取钱包管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:wallet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysUserWalletService.selectSysUserWalletById(id));
    }

    /**
     * 新增钱包管理
     */
    @PreAuthorize("@ss.hasPermi('system:wallet:add')")
    @Log(title = "钱包管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserWallet sysUserWallet)
    {
        return toAjax(sysUserWalletService.insertSysUserWallet(sysUserWallet));
    }

    /**
     * 修改钱包管理
     */
    @PreAuthorize("@ss.hasPermi('system:wallet:edit')")
    @Log(title = "钱包管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserWallet sysUserWallet)
    {
        return toAjax(sysUserWalletService.updateSysUserWallet(sysUserWallet));
    }

    /**
     * 删除钱包管理
     */
    @PreAuthorize("@ss.hasPermi('system:wallet:remove')")
    @Log(title = "钱包管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysUserWalletService.deleteSysUserWalletByIds(ids));
    }

    /**
     * 获取钱包管理详细信息
     */
    @GetMapping(value = "/get_wallet_balance")
    public AjaxResult getWalletBalance(WalletBalanceParamDTO walletBalanceParamDTO ) throws IOException {
        SysUserWallet sysUserWallet = new SysUserWallet();
        sysUserWallet.setUserId(walletBalanceParamDTO.getUserId());
        sysUserWallet.setWalletAddress(walletBalanceParamDTO.getWalletAddress());
        sysUserWallet.setWalletStatus(0);
        List<SysUserWallet>  wallets = sysUserWalletService.selectSysUserWalletList(sysUserWallet);

        if(wallets.size()==0){
            return AjaxResult.error("钱包不存在");
        }else{
            SysUserWallet wallet = wallets.get(0);
            BinanceUtil b = new BinanceUtil(wallet.getApiKey());
           Double e = b.getBalance(walletBalanceParamDTO.getSignedParam(),walletBalanceParamDTO.getSymbol());
           return success(e);
        }
//        return success("e");
    }
    @PostMapping (value = "/buy_symbol")
    public AjaxResult buySymbol(@RequestBody  WalletBalanceParamDTO walletBalanceParamDTO ) throws IOException {
        SysUserWallet sysUserWallet = new SysUserWallet();
        sysUserWallet.setUserId(walletBalanceParamDTO.getUserId());
        sysUserWallet.setWalletAddress(walletBalanceParamDTO.getWalletAddress());
        sysUserWallet.setWalletStatus(0);
        List<SysUserWallet>  wallets = sysUserWalletService.selectSysUserWalletList(sysUserWallet);

        if(wallets.size()==0){
            return AjaxResult.error("钱包不存在");
        }else{
            SysUserWallet wallet = wallets.get(0);
            BinanceUtil tradeClient = new BinanceUtil(wallet.getApiKey());
            tradeClient.buySymbol(walletBalanceParamDTO.getSignedParam());
            return success("2");
        }
//        return success("e");
    }

}
