package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserWalletMapper;
import com.ruoyi.system.domain.SysUserWallet;
import com.ruoyi.system.service.ISysUserWalletService;

/**
 * 钱包管理Service业务层处理
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@Service
public class SysUserWalletServiceImpl implements ISysUserWalletService
{
    @Autowired
    private SysUserWalletMapper sysUserWalletMapper;

    /**
     * 查询钱包管理
     *
     * @param id 钱包管理主键
     * @return 钱包管理
     */
    @Override
    public SysUserWallet selectSysUserWalletById(Long id)
    {
        return sysUserWalletMapper.selectSysUserWalletById(id);
    }

    /**
     * 查询钱包管理列表
     *
     * @param sysUserWallet 钱包管理
     * @return 钱包管理
     */
    @Override
    public List<SysUserWallet> selectSysUserWalletList(SysUserWallet sysUserWallet)
    {
        return sysUserWalletMapper.selectSysUserWalletList(sysUserWallet);
    }

    /**
     * 新增钱包管理
     *
     * @param sysUserWallet 钱包管理
     * @return 结果
     */
    @Override
    public int insertSysUserWallet(SysUserWallet sysUserWallet)
    {
        sysUserWallet.setCreateTime(DateUtils.getNowDate());
        return sysUserWalletMapper.insertSysUserWallet(sysUserWallet);
    }

    /**
     * 修改钱包管理
     *
     * @param sysUserWallet 钱包管理
     * @return 结果
     */
    @Override
    public int updateSysUserWallet(SysUserWallet sysUserWallet)
    {
        sysUserWallet.setUpdateTime(DateUtils.getNowDate());
        return sysUserWalletMapper.updateSysUserWallet(sysUserWallet);
    }

    /**
     * 批量删除钱包管理
     *
     * @param ids 需要删除的钱包管理主键
     * @return 结果
     */
    @Override
    public int deleteSysUserWalletByIds(Long[] ids)
    {
        return sysUserWalletMapper.deleteSysUserWalletByIds(ids);
    }

    /**
     * 删除钱包管理信息
     *
     * @param id 钱包管理主键
     * @return 结果
     */
    @Override
    public int deleteSysUserWalletById(Long id)
    {
        return sysUserWalletMapper.deleteSysUserWalletById(id);
    }
}
