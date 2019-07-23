package demo.sbhdhr.ppmtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.sbhdhr.ppmtool.exceptions.ProjectIdException;
import demo.sbhdhr.ppmtool.model.Project;
import demo.sbhdhr.ppmtool.services.MapValidationErrorService;
import demo.sbhdhr.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
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

	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProject(@PathVariable String projectId) {
		Project project = projectService.findByProjectIdentifier(projectId);
		if (project == null) {
			throw new ProjectIdException("Project ID: " + projectId.toUpperCase() + " does not exist.");
		}

		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Project> getAllProjects() {
		return projectService.findAll();
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
		projectService.deleteProjectById(projectId);

		return new ResponseEntity<String>("Project ID: " + projectId.toUpperCase() + " deleted.", HttpStatus.OK);
	}

	@PutMapping("/{projectId}")
	public ResponseEntity<?> updateProject(@PathVariable String projectId, @Valid @RequestBody Project project,
			BindingResult result) {
		
		ResponseEntity<?> errorMap = mapValidService.mapErrors(result);
		if (errorMap != null)
			return errorMap;
		
		

		Project oldProject = projectService.findByProjectIdentifier(projectId);
		if (oldProject == null) {
			throw new ProjectIdException("Project ID: " + projectId + " does not exist.");
		}else if (!(project.getProjectIdentifier().equals(projectId))) {
			throw new ProjectIdException("Project ID cannot be updated.");
		}
		
		project.setId(oldProject.getId());

		projectService.saveOrUpdateProject(project);
		Project newProject = projectService.findByProjectIdentifier(project.getProjectIdentifier());
		return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
	}
}
