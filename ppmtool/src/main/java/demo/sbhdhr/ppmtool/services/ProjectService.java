package demo.sbhdhr.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.sbhdhr.ppmtool.exceptions.ProjectIdException;
import demo.sbhdhr.ppmtool.model.Project;
import demo.sbhdhr.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception ex) {

			throw new ProjectIdException(
					"Project ID: " + project.getProjectIdentifier().toUpperCase() + " already exists.");
		}

	}
	
	public Project findByProjectIdentifier(String projectIdentifier) {
		return projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
	}
	
	public Iterable<Project> findAll(){
		return projectRepository.findAll();
	}
	
	public void deleteProjectById(String projectIdentifier) {
		Project project = findByProjectIdentifier(projectIdentifier);
		if(project == null) {
			throw new ProjectIdException("Project ID: " + projectIdentifier.toUpperCase() + " doesnot exist.");
		}
		projectRepository.delete(project);
	}
}
