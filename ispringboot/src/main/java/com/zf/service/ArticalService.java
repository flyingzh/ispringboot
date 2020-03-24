package com.zf.service;

import com.zf.pojo.Artical;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticalService {
    Page<Artical> findArticalList(Integer page, Integer size);

}
