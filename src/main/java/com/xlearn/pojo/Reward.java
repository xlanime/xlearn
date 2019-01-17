package com.xlearn.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 奖品类
 */
@Data
public class Reward {
    private Integer rewardId;

    /**
     *    奖品名称
     */
    private String rewardName;

    /**
     * 奖品封面
     */
    private String rewardCover;

    /**
     * 奖品消耗
     */
    private Integer rewardConsume;

    /**
     * 奖品库存
     */
    private Integer rewardStock;

    private Date createTime;

    private Date updateTime;

    public Reward(Integer rewardId, String rewardName, String rewardCover, Integer rewardConsume, Integer rewardStock, Date createTime, Date updateTime) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.rewardCover = rewardCover;
        this.rewardConsume = rewardConsume;
        this.rewardStock = rewardStock;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Reward() {
        super();
    }

}