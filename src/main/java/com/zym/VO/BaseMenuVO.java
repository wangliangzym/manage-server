package com.zym.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : BaseMenuVO
 * @Description :
 * @Author : Wang Liang
 * @Date: 2021-07-14 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseMenuVO {

    private Integer id;
    private String name;
    private String icon;
    private String path;
    private Integer parentId;
    private Integer level;
    @Builder.Default
    private List<BaseMenuVO> childList = new ArrayList<>();

}
