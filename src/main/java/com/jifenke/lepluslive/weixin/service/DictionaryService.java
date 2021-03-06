package com.jifenke.lepluslive.weixin.service;

import com.jifenke.lepluslive.weixin.domain.entities.Dictionary;
import com.jifenke.lepluslive.weixin.repository.DictionaryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import javax.inject.Inject;

/**
 * Created by zhangwen on 2016/5/25.
 */
@Service
@Transactional(readOnly = true)
public class DictionaryService {

  @Inject
  private DictionaryRepository dictionaryRepository;

  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public Dictionary findDictionaryById(Long id) {

    return dictionaryRepository.findOne(id);
  }

  /**
   * 更新推荐商品时间戳
   */
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public void updateProductRecommend(Date date) {

    Dictionary dictionary = dictionaryRepository.findOne(5L);
    dictionary.setValue(String.valueOf(date.getTime()));
    dictionaryRepository.save(dictionary);
  }

  /**
   * 更新推荐商家时间戳
   */
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public void updateMerchantRecommend(Date date) {

    Dictionary dictionary = dictionaryRepository.findOne(6L);
    dictionary.setValue(String.valueOf(date.getTime()));
    dictionaryRepository.save(dictionary);
  }

}
