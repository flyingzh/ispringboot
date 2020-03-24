package com.zf.service.impl;

import com.zf.mapper.ArticalMapper;
import com.zf.pojo.Artical;
import com.zf.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ArticalServiceImpl implements ArticalService {

    @Autowired
    private ArticalMapper articalMapper;

    @Override
    public Page<Artical> findArticalList(Integer page, Integer size) {
        Sort sort = Sort.by("id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Artical> all = articalMapper.findAll(pageable);
        return all;
    }
}
