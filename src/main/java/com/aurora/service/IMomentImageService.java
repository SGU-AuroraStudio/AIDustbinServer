package com.aurora.service;

import com.aurora.domain.MomentImage;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/1 19:46
 * @Description
 */
public interface IMomentImageService {
    MomentImage selectByMomentIdAndImageNo(Integer momentId, Integer imageNo);

    boolean insert(MomentImage momentImage);
}
