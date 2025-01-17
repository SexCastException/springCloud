package com.huazai.springcloud.alibaba.seata.storage.service.domain;

import lombok.Data;

/**
 * @author pyh
 * @date 2020/9/23 20:54
 */
@Data
public class Storage {
    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;

    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;

}
