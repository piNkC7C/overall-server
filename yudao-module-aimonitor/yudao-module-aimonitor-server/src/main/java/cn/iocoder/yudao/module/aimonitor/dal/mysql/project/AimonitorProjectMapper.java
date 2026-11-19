package cn.iocoder.yudao.module.aimonitor.dal.mysql.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectPageReqVO;
import cn.iocoder.yudao.module.aimonitor.dal.dataobject.project.AimonitorProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AimonitorProjectMapper extends BaseMapperX<AimonitorProjectDO> {

    /** 仅当前创建人（creator = 登录用户 id） */
    default PageResult<AimonitorProjectDO> selectPage(AimonitorProjectPageReqVO reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AimonitorProjectDO>()
                .eq(AimonitorProjectDO::getCreator, String.valueOf(userId))
                .likeIfPresent(AimonitorProjectDO::getBrandName, reqVO.getBrandName())
                .likeIfPresent(AimonitorProjectDO::getName, reqVO.getName())
                .eqIfPresent(AimonitorProjectDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AimonitorProjectDO::getCountry, reqVO.getCountry())
                .orderByDesc(AimonitorProjectDO::getId));
    }

    default AimonitorProjectDO selectByAlgorithmProjectId(String algorithmProjectId) {
        return selectOne(AimonitorProjectDO::getAlgorithmProjectId, algorithmProjectId);
    }

    /** 按品牌拉候选（忽略大小写），官网归一化后在 Service 比对（与算法 project_key 对齐） */
    default java.util.List<AimonitorProjectDO> selectListByBrandName(String brandName) {
        return selectList(new LambdaQueryWrapperX<AimonitorProjectDO>()
                .apply("LOWER(brand_name) = LOWER({0})", brandName)
                .orderByDesc(AimonitorProjectDO::getId));
    }

}
