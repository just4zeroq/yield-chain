package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysUserWallet;

/**
 * 钱包管理Service接口
 *
 * @author ruoyi
 * @date 2025-06-14
 */
public interface ISysUserWalletService
{
    /**
     * 查询钱包管理
     *
     * @param id 钱包管理主键
     * @return 钱包管理
     */
    public SysUserWallet selectSysUserWalletById(Long id);

    /**
     * 查询钱包管理列表
     *
     * @param sysUserWallet 钱包管理
     * @return 钱包管理集合
     */
    public List<SysUserWallet> selectSysUserWalletList(SysUserWallet sysUserWallet);

    /**
     * 新增钱包管理
     *
     * @param sysUserWallet 钱包管理
     * @return 结果
     */
    public int insertSysUserWallet(SysUserWallet sysUserWallet);

    /**
     * 修改钱包管理
     *
     * @param sysUserWallet 钱包管理
     * @return 结果
     */
    public int updateSysUserWallet(SysUserWallet sysUserWallet);

    /**
     * 批量删除钱包管理
     *
     * @param ids 需要删除的钱包管理主键集合
     * @return 结果
     */
    public int deleteSysUserWalletByIds(Long[] ids);

    /**
     * 删除钱包管理信息
     *
     * @param id 钱包管理主键
     * @return 结果
     */
    public int deleteSysUserWalletById(Long id);
}
