package demo.sbhdhr.ppmtool.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.sbhdhr.ppmtool.model.ProjectTask;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

	ProjectTask findByProjectSequence(String projectSequence);

	@Query("SELECT pt FROM ProjectTask pt INNER JOIN Project p ON pt.project=p.id "
			+ "WHERE p.projectIdentifier=:projectId")
	List<ProjectTask> findByProjectId(@Param("projectId") String projectId);

}
