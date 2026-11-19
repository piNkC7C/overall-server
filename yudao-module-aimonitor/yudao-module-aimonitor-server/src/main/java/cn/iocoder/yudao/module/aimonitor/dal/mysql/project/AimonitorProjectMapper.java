package cn.iocoder.yudao.module.aimonitor.dal.mysql.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectPageReqVO;
import cn.iocoder.yudao.module.aimonitor.dal.dataobject.project.AimonitorProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AimonitorProjectMapper extends BaseMapperX<AimonitorProjectDO> {

    default PageResult<AimonitorProjectDO> selectPage(AimonitorProjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AimonitorProjectDO>()
                .likeIfPresent(AimonitorProjectDO::getBrandName, reqVO.getBrandName())
                .likeIfPresent(AimonitorProjectDO::getName, reqVO.getName())
                .eqIfPresent(AimonitorProjectDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AimonitorProjectDO::getCountry, reqVO.getCountry())
                .orderByDesc(AimonitorProjectDO::getId));
    }

    default AimonitorProjectDO selectByAlgorithmProjectId(String algorithmProjectId) {
        return selectOne(AimonitorProjectDO::getAlgorithmProjectId, algorithmProjectId);
    }

}
