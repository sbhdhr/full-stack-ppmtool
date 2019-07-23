package demo.sbhdhr.ppmtool.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.sbhdhr.ppmtool.exceptions.ProjectIdException;
import demo.sbhdhr.ppmtool.model.Project;
import demo.sbhdhr.ppmtool.model.ProjectTask;
import demo.sbhdhr.ppmtool.services.MapValidationErrorService;
import demo.sbhdhr.ppmtool.services.ProjectTaskService;

@RestController
@RequestMapping("/api/task")
@CrossOrigin
public class ProjectTaskController {

	@Autowired
	private MapValidationErrorService mapValidService;

	@Autowired
	private ProjectTaskService projectTaskService;

	@PostMapping("/{projectId}")
	public ResponseEntity<?> createProjectTask(@PathVariable String projectId,
			@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
		
		ResponseEntity<?> errorMap = mapValidService.mapErrors(result);
		if (errorMap != null)
			return errorMap;

		ProjectTask newProjectTask = projectTaskService.saveOrUpdateProjectTask(projectId,projectTask);
		if(newProjectTask!=null) {
			return new ResponseEntity<ProjectTask>(newProjectTask, HttpStatus.CREATED);
		}else {
			throw new ProjectIdException("Project ID: " + projectId.toUpperCase() + " does not exist.");
		}
	}
	
	@GetMapping("/{projectSequence}")
	public ResponseEntity<?> getProjectTask(@PathVariable String projectSequence) {
		ProjectTask projectTask = projectTaskService.findByProjectSequence(projectSequence);
		if (projectTask == null) {
			throw new ProjectIdException("ProjectTask ID: " + projectSequence.toUpperCase() + " does not exist.");
		}

		return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
	}
	
	@GetMapping("/all/{projectId}")
	public ResponseEntity<?> getProjectTaskForProject(@PathVariable String projectId) {
		List<ProjectTask> projectTask = projectTaskService.findByProjectId(projectId);
		

		return new ResponseEntity<List<ProjectTask>>(projectTask, HttpStatus.OK);
	}

}
