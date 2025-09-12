package bug_tracker_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bugs_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bug {

	private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status; // OPEN, IN_PROGRESS, RESOLVED, CLOSED
}