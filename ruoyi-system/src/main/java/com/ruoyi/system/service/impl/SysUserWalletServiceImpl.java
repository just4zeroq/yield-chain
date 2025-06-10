package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.vo.UserWalletVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserWalletMapper;
import com.ruoyi.system.domain.SysUserWallet;
import com.ruoyi.system.service.ISysUserWalletService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@Service
public class SysUserWalletServiceImpl implements ISysUserWalletService 
{
    @Autowired
    private SysUserWalletMapper sysUserWalletMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysUserWallet selectSysUserWalletById(Long id)
    {
        return sysUserWalletMapper.selectSysUserWalletById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysUserWallet 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysUserWallet> selectSysUserWalletList(SysUserWallet sysUserWallet)
    {
        return sysUserWalletMapper.selectSysUserWalletList(sysUserWallet);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysUserWallet 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysUserWallet(SysUserWallet sysUserWallet)
    {
        sysUserWallet.setCreateTime(DateUtils.getNowDate());
        return sysUserWalletMapper.insertSysUserWallet(sysUserWallet);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysUserWallet 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysUserWallet(SysUserWallet sysUserWallet)
    {
        sysUserWallet.setUpdateTime(DateUtils.getNowDate());
        return sysUserWalletMapper.updateSysUserWallet(sysUserWallet);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysUserWalletByIds(Long[] ids)
    {
        return sysUserWalletMapper.deleteSysUserWalletByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysUserWalletById(Long id)
    {
        return sysUserWalletMapper.deleteSysUserWalletById(id);
    }

    @Override
    public List<UserWalletVo> selectSysUserWalletByRole(Long roleId, String chainCode) {
        return sysUserWalletMapper.selectSysUserWalletByRole(roleId,chainCode);
    }
}
