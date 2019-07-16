package demo.sbhdhr.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.sbhdhr.ppmtool.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

}
