package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUserWallet;
import com.ruoyi.system.domain.vo.UserWalletVo;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public interface SysUserWalletMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysUserWalletById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysUserWalletByIds(Long[] ids);

    public List<UserWalletVo> selectSysUserWalletByRole(@Param("roleId") Long roleId, @Param("chainCode")String chainCode);
}
