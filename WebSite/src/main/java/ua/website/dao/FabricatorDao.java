package ua.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Fabricator;

public interface FabricatorDao extends JpaRepository<Fabricator, Integer>,JpaSpecificationExecutor<Fabricator>{

	Fabricator findByName(String name);

}
