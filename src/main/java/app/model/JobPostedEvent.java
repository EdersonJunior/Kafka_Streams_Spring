package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobPostedEvent {
    private String jobId;
    private String jobTitle;
}