package com.aurora.service;

import com.aurora.domain.MomentImage;

import java.util.List;

/**
 * @Author Yao
 * @Date 2021/4/1 19:46
 * @Description
 */
public interface IMomentImageService {
    List<MomentImage> selectByMomentId(Integer momentId);

    boolean insert(MomentImage momentImage);
}
