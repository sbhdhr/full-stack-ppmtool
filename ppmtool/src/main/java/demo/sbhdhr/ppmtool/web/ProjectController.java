package demo.sbhdhr.ppmtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.sbhdhr.ppmtool.model.Project;
import demo.sbhdhr.ppmtool.services.MapValidationErrorService;
import demo.sbhdhr.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private MapValidationErrorService mapValidService;

	@PostMapping("")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {

		ResponseEntity<?> errorMap = mapValidService.mapErrors(result);
		if (errorMap != null)
			return errorMap;

		Project newProject = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
	}

}
