package chinh.anh.service;

import chinh.anh.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();
    Optional<SmartPhone> findById(Long id);
    void deleteById(Long id);
    SmartPhone save(SmartPhone smartPhone);
    Iterable<SmartPhone> findAllByProducerContaining(String producer);
}
