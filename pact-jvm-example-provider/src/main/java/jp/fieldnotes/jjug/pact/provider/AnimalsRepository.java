package jp.fieldnotes.jjug.pact.provider;

import jp.fieldnotes.jjug.pact.provider.domain.AnimalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository extends JpaRepository<AnimalsEntity, Long>{

    @Query(value = "select * from animals where type = :type", nativeQuery = true)
    List<AnimalsEntity> findByType(@Param("type") String type);

}
