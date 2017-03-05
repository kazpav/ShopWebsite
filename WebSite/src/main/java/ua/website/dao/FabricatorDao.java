package ua.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.website.entity.Fabricator;

public interface FabricatorDao extends JpaRepository<Fabricator, Integer>{

	Fabricator findByName(String name);

}
