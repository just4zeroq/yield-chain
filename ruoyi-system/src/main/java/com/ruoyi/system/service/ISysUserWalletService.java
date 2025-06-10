package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysUserWallet;
import com.ruoyi.system.domain.vo.UserWalletVo;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public interface ISysUserWalletService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysUserWallet selectSysUserWalletById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysUserWallet 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysUserWallet> selectSysUserWalletList(SysUserWallet sysUserWallet);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysUserWallet 【请填写功能名称】
     * @return 结果
     */
    public int insertSysUserWallet(SysUserWallet sysUserWallet);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysUserWallet 【请填写功能名称】
     * @return 结果
     */
    public int updateSysUserWallet(SysUserWallet sysUserWallet);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysUserWalletByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysUserWalletById(Long id);

    public List<UserWalletVo> selectSysUserWalletByRole( Long roleId, String chainCode);
}
