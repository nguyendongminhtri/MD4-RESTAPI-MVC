package chinh.anh.repository;

import chinh.anh.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
Iterable<SmartPhone> findAllByProducerContaining(String producer);
}
