package com.nine.app.mapper.detail;

import com.nine.app.dto.PermissionDTO;
import com.nine.app.entity.Permission;
import com.nine.app.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:03
 */
@Mapper(componentModel = "spring",
        uses = {},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
