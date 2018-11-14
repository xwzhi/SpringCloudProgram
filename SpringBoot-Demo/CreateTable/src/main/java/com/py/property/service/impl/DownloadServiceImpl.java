package com.py.property.service.impl;

import com.py.property.entity.Download;
import com.py.property.repository.DownloadDao;
import com.py.property.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName DownloadServiceImpl
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-11-02 17:11 星期五 property
 * @VERSION 1.0.0
 **/
@Service
@Transactional
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadDao downloadDao;

    @Override
    public void save(Download casesDownload) {
        downloadDao.save(casesDownload);
    }

    @Override
    public void delete(Download casesDownload) {
        downloadDao.delete(casesDownload);
    }

    @Override
    public Download getById(Integer id) {
        return downloadDao.getOne(id);
    }

    @Override
    public List<Download> findAll() {
        return downloadDao.findAll();
    }
}
