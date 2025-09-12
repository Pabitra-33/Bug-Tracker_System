package bug_tracker_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bug_tracker_app.entity.Bug;
import bug_tracker_app.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

	@Autowired
	private final BugService bugService;
	
	public BugController(BugService bugService) {
		this.bugService = bugService;
	}
	
	
	//CRUD operation methods
	@PostMapping
	public Bug createBug(Bug bug) {
		return bugService.addBug(bug);
	}
	
	
	
	@GetMapping
	public List<Bug> getAllBugs(){
		return bugService.getAllBugs();
	}
	
	
	@PutMapping("/{id}")
	public Bug updateBug(@PathVariable Long id, @RequestBody Bug bug) {
		return bugService.updateBug(id, bug);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteBug(@PathVariable Long id) {
		bugService.deleteBug(id);
		return "Bug deleted successfully";
	}
}