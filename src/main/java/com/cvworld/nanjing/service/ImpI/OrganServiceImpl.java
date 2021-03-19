package com.cvworld.nanjing.service.ImpI;

import com.cvworld.nanjing.bean.Organ;
import com.cvworld.nanjing.dao.OrganDao;
import com.cvworld.nanjing.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganServiceImpl implements OrganService {

    @Autowired
    private OrganDao organDao;

    //查询所有机构
    @Override
    public List<Organ> findAll() {
        return organDao.findAll();
    }

    //查询所有机构
    @Override
    public Page<Organ> findAll(Pageable pageable) {
        return organDao.findAll(pageable);
    }

    //保存机构
    @Override
    public Organ saveOrgan(Organ organ) {
        return organDao.save(organ);
    }

    //查询搜索的机构
    @Override
    public Page<Organ> listOrgan(String query, Pageable pageable) {
        return organDao.findByQuery(query,pageable);
    }

    //通过id查询机构
    @Override
    public Organ findById(Long id) {
        return organDao.findOrganById(id);
    }

    //通过id删除机构
    @Override
    public void deleteById(Long id) {
        organDao.deleteById(id);
    }
}
