package com.nine.app.mapper;

import java.util.List;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:02
 */
public interface EntityMapper<D, E> {

    /**
     * DTO转Entity
     *
     * @param dto
     *
     * @return
     */
    E toEntity(D dto);

    /**
     * Entity转DTO
     *
     * @param entity
     *
     * @return
     */
    D toDTO(E entity);

    /**
     * DTO集合转Entity集合
     *
     * @param dtoList
     *
     * @return
     */
    List<E> toEntityList(List<D> dtoList);

    /**
     * Entity集合转DTO集合
     *
     * @param entityList
     *
     * @return
     */
    List<D> toDTOList(List<E> entityList);
}
