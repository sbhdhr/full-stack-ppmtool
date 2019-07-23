package demo.sbhdhr.ppmtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<ProjectTask>(newProjectTask, HttpStatus.CREATED);
	}

}
