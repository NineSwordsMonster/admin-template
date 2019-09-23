package com.nine.app.dto.mapper.detail;

import com.nine.app.dto.RoleDTO;
import com.nine.app.entity.Role;
import com.nine.app.dto.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:03
 */
@Mapper(componentModel = "spring",
        uses = {PermissionMapper.class, MenuMapper.class,},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

}
