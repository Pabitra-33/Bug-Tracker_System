package bug_tracker_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping
	public Bug createBug(Bug bug) {
		return bugService.addBug(bug);
	}
	
	
	@GetMapping
	public List<Bug> getAllBugs(){
		return bugService.getAllBugs();
	}
}