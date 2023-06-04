package rikkei.academy.service.province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Province;
import rikkei.academy.repository.IProvinceRepositoty;

import java.util.Optional;

@Service

public class ProvinceServiceIMPL implements IProvinceService {
    @Autowired
    private IProvinceRepositoty provinceRepositoty;


    @Override
    public Iterable<Province> findAll() {
        return provinceRepositoty.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepositoty.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepositoty.save(province);
    }

    @Override
    public void deleteById(Long id) {
        provinceRepositoty.deleteById(id);
    }

}
