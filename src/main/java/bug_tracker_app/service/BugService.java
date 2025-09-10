package bug_tracker_app.service;

import java.util.List;

import bug_tracker_app.entity.Bug;

public interface BugService {

	//created abstract methods to achieve abstraction
	public Bug addBug(Bug bug);//to add new bugs
	public List<Bug> getAllBugs();//to get all bugs
	public Bug updateBug(Long id, Bug bugDetails);//to update existing bugs
	public void deleteBug(Long id);//to delete bugs
}