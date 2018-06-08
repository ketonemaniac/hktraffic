package net.ketone.hktraffic.repo;

import net.ketone.hktraffic.entity.TrafficMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficMessageRepository extends CrudRepository<TrafficMessage, String> {
}
