package com.weboscrudos.softwaredocbuilder.repository;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPlataformaRepository extends JpaRepository<RolPlataformaModel,Long> {
}
