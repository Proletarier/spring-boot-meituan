package com.meituan.waimai.repository;

import com.meituan.waimai.po.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository  extends JpaRepository<Dictionary, Integer> {
}
