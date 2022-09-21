package de.semasevim.IlService.repository;

import de.semasevim.IlService.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IlRepository extends MongoRepository<Il, String  > {
}
