package demo.sbhdhr.ppmtool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.sbhdhr.ppmtool.model.Project;
import demo.sbhdhr.ppmtool.model.ProjectTask;
import demo.sbhdhr.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Autowired
	private ProjectService projectService;
	
	
	public ProjectTask saveOrUpdateProjectTask(String projID,ProjectTask projectTask) {
		
		Project project = projectService.findByProjectIdentifier(projID);
		
		if(project!=null) {
		
			if(projectTask.getProject()==null) {
			
				project.setNoOfTasks(project.getNoOfTasks()+1);
				String seqString = project.getProjectIdentifier()+"-"+project.getNoOfTasks();
				
				
				projectTask.setProject(project);
				projectTask.setProjectSequence(seqString);
				
				
				project.getTasks().add(projectTask);
				
			}
		
		return projectTaskRepository.save(projectTask);
		}
		else {
			return null;
		}
	}


	public ProjectTask findByProjectSequence(String projectSequence) {
		return projectTaskRepository.findByProjectSequence(projectSequence);
	}


	public List<ProjectTask> findByProjectId(String projectId) {
		return projectTaskRepository.findByProjectId(projectId);
	}
}
