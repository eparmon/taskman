package by.eparmon.taskman.persistence.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {
    TO_DO("to do"), IN_PROGRESS("In Progress"), DONE("Done");

    private final String label;
}
