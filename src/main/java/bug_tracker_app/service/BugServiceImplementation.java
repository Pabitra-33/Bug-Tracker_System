package bug_tracker_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bug_tracker_app.entity.Bug;
import bug_tracker_app.repository.BugRepository;

@Service
public class BugServiceImplementation implements BugService {

	@Autowired
	private final BugRepository bugRepository;
	
	public BugServiceImplementation(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}
	
	@Override
	public Bug addBug(Bug bug) {
		if (bug.getDescription() == null || bug.getDescription().isEmpty()) {
		    throw new IllegalArgumentException("Description cannot be null or empty");
		}
		return bugRepository.save(bug);
	}

	@Override
	public List<Bug> getAllBugs() {
		return bugRepository.findAll();
	}

	@Override
	public Bug updateBug(Long id, Bug bugDetails) {
		Bug bug = bugRepository.findById(id).orElseThrow(() -> new RuntimeException("Bug id not found"));
		bug.setTitle(bug.getTitle());
		bug.setDescription(bug.getDescription());
		bug.setStatus(bug.getStatus());
		
		return bugRepository.save(bug);
	}

	@Override
	public void deleteBug(Long id) {
		bugRepository.deleteById(id);
	}
}