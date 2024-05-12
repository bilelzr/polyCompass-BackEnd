package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.Module;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    Optional<Module> findModuleByCode(String code);

    Optional<Module> findModuleByLibelle(String libelle);


    @Query("SELECT m from Module m  join m.formationList f  where f.uuid= :uuidFormation ")
    List<Module> findModuleByFormation(@Param("uuidFormation") UUID uuidFormation);


    @Query(value = "select distinct m.* from module m " +
            "inner join public.formation_module fm on m.module_pk = fm.module_id " +
            "inner join public.formation f on fm.formation_id = f.formation_pk " +
            "inner join public.class c on f.formation_pk = c.formation_pk " +
            "where c.uuid = :uuidClass", nativeQuery = true)
    List<Module> findModuleByClass(@Param("uuidClass") UUID uuidClass);

    @Query("SELECT m from Module  m where m.code in :codes ")
    List<Module> findModuleByCodeInList(@Param("codes") List<String> code);
}
