package bug_tracker_app;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bug_tracker_app.entity.Bug;
import bug_tracker_app.entity.Status;
import bug_tracker_app.service.BugService;

@SpringBootTest
class BugTrackerSystemApplicationTests {
	
	//performing unit testing(JUnit + Spring Boot Test)
	
	@Autowired
	private BugService bugService;

//	@Test
//	void contextLoads() {
//	}

	//positive test case
	@Test
    void testAddBug() {
        Bug bug = new Bug(null, "Login Issue", "Login button not working", Status.OPEN);
        Bug savedBug = bugService.addBug(bug);
        assertThat(savedBug.getId()).isNotNull();
    }
	
	
	//negative test case
	@Test
    void testAddBugWithNullDescription() {
        Bug bug = new Bug(null, "Login Issue", null, Status.OPEN);

        // Expecting an exception when description is null
        assertThatThrownBy(() -> bugService.addBug(bug))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Description cannot be null");
    }
}
